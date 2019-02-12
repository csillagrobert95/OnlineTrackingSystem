using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for PackageDAO
/// </summary>
public class PackageDAO
{
    public PackageDAO()
    {

    }

    public int awb { get; set; }
    public int sender_id { get; set; }
    public int receiver_id { get; set; }
    public string package_name { get; set; }
    public string package_description { get; set; }
    public string sender_city { get; set; }
    public string destination_city { get; set; }
    public int tracked { get; set; }
}