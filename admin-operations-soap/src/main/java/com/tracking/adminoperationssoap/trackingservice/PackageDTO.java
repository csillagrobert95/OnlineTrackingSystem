
package com.tracking.adminoperationssoap.trackingservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for packageDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="packageDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="awb" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="receiverId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="packageDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="senderCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="destinationCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tracked" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "packageDTO", namespace = "http://spring.io/guides/gs-producing-web-service", propOrder = {
    "awb",
    "senderId",
    "receiverId",
    "packageName",
    "packageDescription",
    "senderCity",
    "destinationCity",
    "tracked"
})
public class PackageDTO {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected int awb;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected int senderId;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected int receiverId;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String packageName;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String packageDescription;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String senderCity;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String destinationCity;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected int tracked;

    /**
     * Gets the value of the awb property.
     * 
     */
    public int getAwb() {
        return awb;
    }

    /**
     * Sets the value of the awb property.
     * 
     */
    public void setAwb(int value) {
        this.awb = value;
    }

    /**
     * Gets the value of the senderId property.
     * 
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * Sets the value of the senderId property.
     * 
     */
    public void setSenderId(int value) {
        this.senderId = value;
    }

    /**
     * Gets the value of the receiverId property.
     * 
     */
    public int getReceiverId() {
        return receiverId;
    }

    /**
     * Sets the value of the receiverId property.
     * 
     */
    public void setReceiverId(int value) {
        this.receiverId = value;
    }

    /**
     * Gets the value of the packageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets the value of the packageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * Gets the value of the packageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageDescription() {
        return packageDescription;
    }

    /**
     * Sets the value of the packageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageDescription(String value) {
        this.packageDescription = value;
    }

    /**
     * Gets the value of the senderCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderCity() {
        return senderCity;
    }

    /**
     * Sets the value of the senderCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderCity(String value) {
        this.senderCity = value;
    }

    /**
     * Gets the value of the destinationCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * Sets the value of the destinationCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationCity(String value) {
        this.destinationCity = value;
    }

    /**
     * Gets the value of the tracked property.
     * 
     */
    public int getTracked() {
        return tracked;
    }

    /**
     * Sets the value of the tracked property.
     * 
     */
    public void setTracked(int value) {
        this.tracked = value;
    }

}
