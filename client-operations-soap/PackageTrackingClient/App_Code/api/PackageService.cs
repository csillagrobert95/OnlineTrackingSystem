using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Dapper;
using MySql.Data.MySqlClient;

/// <summary>
/// Summary description for PackageService
/// </summary>
public class PackageService
{
    private readonly MySqlConnection _conn;

    private static string host = "127.0.0.1"; // The IP address 127.0.0.1 is the same as "localhost" 
    private static string database = "online_tracking_system";    
    private static string user = "root";      // Default WampServer MySQL username
    private static string password = "";      // Default WampServer MySQL password (no password!)

    // Create a provider string from our details
    private string connectionString = "Server=" + host 
                + ";Database=" + database
                + ";User ID=" + user
                + ";Password=" + password;

    public PackageService()
    {
        _conn = new MySqlConnection(connectionString);
    }

    public List<Package> getPackagesByUserId(int userId)
    {
        var sql = "SELECT awb, sender_id, receiver_id, package_name, package_description, sender_city, destination_city, tracked FROM package WHERE sender_id = @UserId OR receiver_id = @UserId";
        var result = this._conn.Query<PackageDAO>(sql, new { UserId = userId }).ToList();
        var convertedResult = new List<Package>();

        foreach(PackageDAO packageDAO in result){
            convertedResult.Add(Converter.PackageDAOToDTO(packageDAO));
        }

        return convertedResult;
    }

    public List<Package> getPackagesByUserIdAwb(int userId, int awb)
    {
        var sql = "SELECT awb, sender_id, receiver_id, package_name, package_description, sender_city, destination_city, tracked FROM package WHERE (sender_id = @UserId OR receiver_id = @UserId) AND awb = @Awb";
        var result = this._conn.Query<PackageDAO>(sql, new { UserId = userId, Awb = awb }).ToList();
        var convertedResult = new List<Package>();

        foreach (PackageDAO packageDAO in result)
        {
            convertedResult.Add(Converter.PackageDAOToDTO(packageDAO));
        }

        return convertedResult;
    }

    public List<Route> getRoutesByAwb(int awb)
    {
        var sql = "SELECT awb, route_nr, city, receive_time FROM routes WHERE awb = @Awb ORDER BY receive_time ASC";
        var result = this._conn.Query<RouteDAO>(sql, new { Awb = awb }).ToList();
        var convertedResult = new List<Route>();

        foreach (RouteDAO routeDAO in result)
        {
            convertedResult.Add(Converter.RouteDAOToDTO(routeDAO));
        }

        return convertedResult;
    }

    public string registerUser(string firstName, string lastName, string username, string password, string email)
    {

        string insertUserSql = "INSERT INTO user(active, first_name, last_name, username, password, email) VALUES(1, @FirstName, @LastName, @Username, @Password, @Email);";

        _conn.Execute(insertUserSql, new
                                    {
                                        FirstName = firstName,
                                        LastName = lastName,
                                        Username = username,
                                        Password = password,
                                        email = email
                                    });

        string selectInsertedUID = "SELECT user_id FROM user WHERE first_name = @FirstName AND last_name = @LastName AND username = @Username AND email = @Email";

        int newUserId = _conn.QuerySingle<int>(selectInsertedUID,
                                        new
                                        {
                                            FirstName = firstName,
                                            LastName = lastName,
                                            Username = username,
                                            email = email
                                        });

        _conn.Execute("INSERT INTO user_role (user_id, role_id) VALUES (@UserId, 2)", new { UserId = newUserId});

        return "OK";
    }

}