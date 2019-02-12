<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:element name="getPackagesByUserId">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="userId" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getPackagesByUserIdResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getPackagesByUserIdResult" type="tns:ArrayOfPackage" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfPackage">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="Package" nillable="true" type="tns:Package" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Package">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="awb" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="senderId" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="receiverId" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="packageName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="packageDescription" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="senderCity" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="destinationCity" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="tracked" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="getPackagesByUserIdAwb">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="userId" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="awb" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getPackagesByUserIdAwbResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getPackagesByUserIdAwbResult" type="tns:ArrayOfPackage" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getRoutesByAwb">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="awb" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getRoutesByAwbResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getRoutesByAwbResult" type="tns:ArrayOfRoute" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfRoute">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="Route" nillable="true" type="tns:Route" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Route">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="awb" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="routeNr" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="city" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="receiveTime" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="registerUser">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="firstName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="lastName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="username" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="email" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="registerUserResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="registerUserResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="getPackagesByUserIdSoapIn">
    <wsdl:part name="parameters" element="tns:getPackagesByUserId" />
  </wsdl:message>
  <wsdl:message name="getPackagesByUserIdSoapOut">
    <wsdl:part name="parameters" element="tns:getPackagesByUserIdResponse" />
  </wsdl:message>
  <wsdl:message name="getPackagesByUserIdAwbSoapIn">
    <wsdl:part name="parameters" element="tns:getPackagesByUserIdAwb" />
  </wsdl:message>
  <wsdl:message name="getPackagesByUserIdAwbSoapOut">
    <wsdl:part name="parameters" element="tns:getPackagesByUserIdAwbResponse" />
  </wsdl:message>
  <wsdl:message name="getRoutesByAwbSoapIn">
    <wsdl:part name="parameters" element="tns:getRoutesByAwb" />
  </wsdl:message>
  <wsdl:message name="getRoutesByAwbSoapOut">
    <wsdl:part name="parameters" element="tns:getRoutesByAwbResponse" />
  </wsdl:message>
  <wsdl:message name="registerUserSoapIn">
    <wsdl:part name="parameters" element="tns:registerUser" />
  </wsdl:message>
  <wsdl:message name="registerUserSoapOut">
    <wsdl:part name="parameters" element="tns:registerUserResponse" />
  </wsdl:message>
  <wsdl:portType name="TrackingServiceClientSoap">
    <wsdl:operation name="getPackagesByUserId">
      <wsdl:input message="tns:getPackagesByUserIdSoapIn" />
      <wsdl:output message="tns:getPackagesByUserIdSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getPackagesByUserIdAwb">
      <wsdl:input message="tns:getPackagesByUserIdAwbSoapIn" />
      <wsdl:output message="tns:getPackagesByUserIdAwbSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getRoutesByAwb">
      <wsdl:input message="tns:getRoutesByAwbSoapIn" />
      <wsdl:output message="tns:getRoutesByAwbSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="registerUser">
      <wsdl:input message="tns:registerUserSoapIn" />
      <wsdl:output message="tns:registerUserSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="TrackingServiceClientSoap" type="tns:TrackingServiceClientSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="getPackagesByUserId">
      <soap:operation soapAction="http://tempuri.org/getPackagesByUserId" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getPackagesByUserIdAwb">
      <soap:operation soapAction="http://tempuri.org/getPackagesByUserIdAwb" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getRoutesByAwb">
      <soap:operation soapAction="http://tempuri.org/getRoutesByAwb" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="registerUser">
      <soap:operation soapAction="http://tempuri.org/registerUser" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="TrackingServiceClientSoap12" type="tns:TrackingServiceClientSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="getPackagesByUserId">
      <soap12:operation soapAction="http://tempuri.org/getPackagesByUserId" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getPackagesByUserIdAwb">
      <soap12:operation soapAction="http://tempuri.org/getPackagesByUserIdAwb" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getRoutesByAwb">
      <soap12:operation soapAction="http://tempuri.org/getRoutesByAwb" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="registerUser">
      <soap12:operation soapAction="http://tempuri.org/registerUser" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="TrackingServiceClient">
    <wsdl:port name="TrackingServiceClientSoap" binding="tns:TrackingServiceClientSoap">
      <soap:address location="http://localhost/PackageTrackingClient/TrackingServiceClient.asmx" />
    </wsdl:port>
    <wsdl:port name="TrackingServiceClientSoap12" binding="tns:TrackingServiceClientSoap12">
      <soap12:address location="http://localhost/PackageTrackingClient/TrackingServiceClient.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>