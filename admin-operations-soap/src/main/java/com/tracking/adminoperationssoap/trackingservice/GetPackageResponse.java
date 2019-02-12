
package com.tracking.adminoperationssoap.trackingservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="package" type="{http://spring.io/guides/gs-producing-web-service}packageDTO"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "_package"
})
@XmlRootElement(name = "getPackageResponse", namespace = "http://spring.io/guides/gs-producing-web-service")
public class GetPackageResponse {

    @XmlElement(name = "package", namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected PackageDTO _package;

    /**
     * Gets the value of the package property.
     * 
     * @return
     *     possible object is
     *     {@link PackageDTO }
     *     
     */
    public PackageDTO getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageDTO }
     *     
     */
    public void setPackage(PackageDTO value) {
        this._package = value;
    }

}
