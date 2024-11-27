# user-profile
Test project 

## Description
The User Profile REST API is a backend application designed to manage user profiles. It offers functionality to retrieve, update, and validate profile data while supporting avatar uploads

## Core Features
Retrieve Profile: Fetch detailed profile information via a GET endpoint.
Update Profile: Modify profile fields using a PUT request with input validation for accuracy.
Create Profile: Create profile using a POST request with input validation for accuracy.
Upload Avatar: Accept image uploads via POST with file size and format restrictions, saving the file locally and providing a URL for access.

## Validation Highlights
Comprehensive validation for fields like name, surname, phone number, and visibility settings.
File validation for avatar uploads, supporting .jpg, .jpeg, and .png formats with a size limit of 5 MB.

## Technology Stack 
Kotlin for concise and expressive code.
Spring Boot for rapid backend development.
PostgreSQL as the database to store user profile information.
Docker setup for streamlined database deployment.

## Instructions for running the app

### **1. Prerequisites**
Make sure the following tools are installed on your local machine:

- **Java Development Kit (JDK)**: Version **22.0.1** (compatible with OpenJDK).
- **Apache Maven**: Version **3.9.9** or newer to manage dependencies and build the project.
- **PostgreSQL**: A running PostgreSQL instance to handle the database.

Optionally, you can run **PostgreSQL** in a Docker container to avoid manual installation.

### **2. Clone the Repository**
Clone the repository to your local machine by running the following command in your terminal:
```
git clone https://github.com/Olefirenko057/user-profile.git
cd user-profile
```

### **3. Configure Database**
Ensure that PostgreSQL is set up and running. You can either use a local instance or run PostgreSQL in a Docker container.

If you're running PostgreSQL locally, ensure you have the correct credentials and update the `application.properties` file with the appropriate database connection details. For example:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres
```

If using Docker, you can run PostgreSQL in a container with this command:
```
docker run --name user-profile-db-1 -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:14
```

### **4. Build the Application**

Navigate to the project folder and run the following Maven command to build the project:
```
mvn clean install
```
This will compile the code, run tests, and create a `.jar` file in the `target` directory.


### **5. Run the Application**

To start the application, execute the following command:
```
mvn spring-boot:run
```

This will start the Spring Boot application, and you can access it at:
```
http://localhost:8080
```
