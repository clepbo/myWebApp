# myWebApp

myWebApp is a web application built using Spring Boot and Spring MVC that allows users to perform CRUD (Create, Read, Update, Delete) operations on a list of user records in a database. The user records have the following parameters: Id, Email, First name, Last name, and Status.

## Prerequisites

Before running the myWebApp, make sure you have the following installed:

- Java 8 or higher
- Maven 3.x or higher
- MySQL Server 5.6 or higher

## Installation

1. Clone the repository or download the source code as a ZIP file.

2. Open a terminal or command prompt and navigate to the root directory of the project.

3. Run the following command to build the project:
    `mvn clean install`

4. Create a new MySQL database called mywebapp with the following SQL command:
    `CREATE DATABASE usersdb;`
        
5. Set up the database tables by running the following command:
    `mysql -u <username> -p usersdb < src/main/resources/db/schema.sql`
    
Replace `<username>` with your MySQL username.

6. Edit the `src/main/resources/application.properties` file to configure the database connection details. Replace `<username>` and `<password>` with your MySQL username and password:
   `spring.datasource.url=jdbc:mysql://localhost:3306/usersdb
    spring.datasource.username=<username>
    spring.datasource.password=<password>
    spring.jpa.hibernate.ddlAuto=update
    spring.jpa.properties.hibernate.show_sql=true`
    
7. Run the following command to start the application:
  `java -jar target/myWebApp-1.0.0.jar`
  or use the run (play) button from your IDE  
This will start the application on port 8080.


## Usage

myWebApp provides a simple web interface for managing user records. You can add a new user, edit an existing user, view a list of all users, or delete a user.

To use the application, follow these steps:

1. Open a web browser and navigate to http://localhost:8080.
![image](https://github.com/clepbo/myWebApp/assets/53521843/9281075e-b30e-4fe2-81ea-99406ecfb5de)


2. Click on the "Manage Users" link to view a list of all users.
![image](https://github.com/clepbo/myWebApp/assets/53521843/0d003d76-f499-4aec-92af-8f6f40ffa3f2)


3. To add a new user, click on the "Add User" button and fill out the form.
![image](https://github.com/clepbo/myWebApp/assets/53521843/3f845135-51de-4cb2-9c25-56211219d96f)


4. To edit an existing user, click on the "Edit" button next to the user you want to edit and make your changes in the form.
![image](https://github.com/clepbo/myWebApp/assets/53521843/f8fc5d96-8f7b-4d4c-a3ac-3284e713d40c)


5. To delete a user, click on the "Delete" button next to the user you want to delete.

## Contributing

If you find any bugs or issues with myWebApp, feel free to submit a GitHub issue or pull request. All contributions are welcome!






