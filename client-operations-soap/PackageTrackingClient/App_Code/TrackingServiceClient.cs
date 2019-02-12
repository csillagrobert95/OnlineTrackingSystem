using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Summary description for TrackingServiceClient
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class TrackingServiceClient : System.Web.Services.WebService
{
    private PackageService packageService = new PackageService();

    public TrackingServiceClient()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public List<Package> getPackagesByUserId(int userId)
    {
        return packageService.getPackagesByUserId(userId);
    }

    [WebMethod]
    public List<Package> getPackagesByUserIdAwb(int userId, int awb)
    {
        return packageService.getPackagesByUserIdAwb(userId, awb);
    }

    [WebMethod]
    public List<Route> getRoutesByAwb(int awb)
    {
        return packageService.getRoutesByAwb(awb);
    }

    [WebMethod]
    public string registerUser(string firstName, string lastName, string username, string password, string email)
    {
        return packageService.registerUser(firstName, lastName, username, password, email);
    }
}
