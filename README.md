# Insurance Management Platform
This is an insurance management platform built with Spring Boot and Java. It allows users to manage insurance policies, clients, and claims using RESTful APIs and an embedded database.

Features
Create, read, update, and delete clients
Create, read, update, and delete insurance policies
Create, read, update, and delete claims
Associate policies with clients and claims with policies
Exception handling and validation to ensure proper API usage and data integrity


Project Structure
The project follows the standard Spring Boot project structure:


insurance-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.insurance/
│   │   │       ├── controller/
│   │   │       ├── exception/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com.example.insurance/
│               └── service/
└── pom.xml


src/main/java/com.example.insurance/controller: Contains the RESTful API endpoints
src/main/java/com.example.insurance/exception: Contains the custom exception classes
src/main/java/com.example.insurance/model: Contains the domain model classes
src/main/java/com.example.insurance/repository: Contains the Spring Data JPA repository interfaces
src/main/java/com.example.insurance/service: Contains the service classes that implement the business logic
src/main/resources/application.properties: Contains the configuration properties for the application
src/test/java/com.example.insurance/service: Contains the JUnit and Mockito test classes for the services



## How to Run Locally
Clone the GitHub repository
Open the project in your favorite IDE (Eclipse, IntelliJ, etc.)
Make sure you have Java 8 or later installed
Make sure you have Maven installed
Update the spring.datasource.url property in src/main/resources/application.properties to connect to your desired database (embedded H2 or external MySQL)
Run the InsuranceManagementApplication class to start the Spring Boot application
Use a tool like Postman to interact with the RESTful APIs at http://localhost:8080/api



## API Documentation
The API endpoints and their parameters are documented using Swagger. You can access the Swagger UI at http://localhost:8080/swagger-ui.html after starting the application.

That's it! Enjoy managing your insurance policies, clients, and claims with this platform.


