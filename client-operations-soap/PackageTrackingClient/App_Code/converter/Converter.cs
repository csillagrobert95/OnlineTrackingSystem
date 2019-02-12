using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Converter
/// </summary>
public class Converter
{
    public Converter()
    {

    }

    public static Package PackageDAOToDTO (PackageDAO packageDAO)
    {
        Package convertedPackage = new Package();

        convertedPackage.awb = packageDAO.awb;
        convertedPackage.senderId = packageDAO.sender_id;
        convertedPackage.receiverId = packageDAO.receiver_id;
        convertedPackage.packageName = packageDAO.package_name;
        convertedPackage.packageDescription = packageDAO.package_description;
        convertedPackage.senderCity = packageDAO.sender_city;
        convertedPackage.destinationCity = packageDAO.destination_city;
        convertedPackage.tracked = packageDAO.tracked;

        return convertedPackage;
    }

    public static Route RouteDAOToDTO(RouteDAO routeDAO)
    {
        Route convertedRoute = new Route();

        convertedRoute.awb = routeDAO.awb;
        convertedRoute.routeNr = routeDAO.route_nr;
        convertedRoute.city = routeDAO.city;
        convertedRoute.receiveTime = routeDAO.receive_time;

        return convertedRoute;
    }
}