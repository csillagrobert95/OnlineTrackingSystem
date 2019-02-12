OnlineTrackingSystem - Csillag Robert

A web application for online package tracking built using SOAP Web Services.

Functional requirements: 
 - The application has two types of users: administrators and clients.
 - After the login, the user is redirected to its corresponding page.
 - If the user does not have an account, it can register and become a simple user (client)
 - The Administrator can:
    - Add/remove package. The package has the following characteristics:
	o Sender – Client
	o Receiver – Client
	o Name
	o Description
	o Sender City
	o Destination City
	o Tracking – Boolean – initially false
    - Register package for tracking
	o The package becomes tracked, and a route is associated to it. This route
	  represents the path of the package to the destination, as pairs of (City,
	  Time).
    - Package status updating
	o A new entry (City, Time) is introduced to the route
 - The Client can:
    - List all its packages
    - Search packages
    - Package status checking

These functionalities are exposed as 2 web services:
 - client-operations-soap - .NET – SOAP Web Service: Client Registration and Simple Client Operations
 - admin-operations-soap - Java Spring Web Services – SOAP Web Service: Administrator Operations

Used technology stack:
- Java
- Spring Boot
- Spring Web Services
- .NET
- MySQL
- Hibernate
- JPA
- Thymeleaf
- HTML
- Bootstrap

Steps to install and run the application:
1. Create a new MySQL Database
2. Run the SQL schema: SQL\SQL_Schema
3. Insert some initial data
4. Import the projects (admin-operations-soap, onlinetracking) in Eclipse/Intellij
5. Import the client-operations-soap project in Visual Studio
6. Change the configuration to accomodate DB name, ip, port, user and password
7. Run the applications client-operations-soap and admin-operations-soap
8. Run the onlinetracking application 
9. Open the web browser (http://localhost:8093)