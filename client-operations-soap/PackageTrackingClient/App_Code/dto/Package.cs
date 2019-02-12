using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Package
/// </summary>
public class Package
{
    public Package()
    {   
        
    }

    public int awb { get; set; }
    public int senderId { get; set; }
    public int receiverId { get; set; }
    public string packageName { get; set; }
    public string packageDescription { get; set; }
    public string senderCity { get; set; }
    public string destinationCity { get; set; }
    public int tracked { get; set; }
}