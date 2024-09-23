# Customer Management System

This project is a customer management system developed with Thymeleaf and Spring Boot.

## Description
The Customer Management System is a web application designed to help businesses manage their customer information efficiently. Users can perform operations such as creating, editing, and deleting customer records. The system supports internationalization, allowing users to switch between English and Spanish. It also features role-based access control to ensure that only authorized users can perform certain actions. The intuitive interface built with Thymeleaf makes it easy for users to navigate through customer data.

## Technology Stack
- Java 21
- Spring Boot 3.3.2
- Thymeleaf  
- Hibernate (JPA)
- Maven
- MapStruct

## Setup and Execution
To run this project locally, follow these steps:

1. Clone this repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Set up your PostgreSQL database (see below).
4. Run the command `mvn spring-boot:run` in the project's root directory.
5. Open your web browser and go to `http://localhost:8080` to access the system.

## Database Setup
1. Install and run PostgreSQL.
2. Create a new database (e.g., `customer_management`).
3. Update the `application.properties` file: properties
spring.datasource.url=jdbc:postgresql://localhost:5432/customer_management
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
The application will automatically generate the necessary tables when it starts.
Running Tests
To run the test suite, use the following command:

bash
Copiar código
mvn test
Project Structure
/html_templates: Contains HTML templates for different pages of the system.
/css: Contains custom CSS files.
/js: Contains custom JavaScript files.
/resources: Contains property files for internationalization and validation messages.
Key Features
Creation, editing, and deletion of customers.
Customer listing with detailed information.
Internationalization for English and Spanish languages.
Access control with user roles.
API Endpoints
Endpoint	HTTP Method	Description
/customers	GET	List all customers
/customers/{id}	GET	Get customer by ID
/customers	POST	Create a new customer
/customers/{id}	PUT	Update customer by ID
/customers/{id}	DELETE	Delete customer by ID
Known Issues
Performance degradation with a large number of customers.
Basic error handling.
Contributing
We welcome contributions! If you would like to contribute to this project, follow these steps:

Fork this repository.
Create a new branch for your feature (git checkout -b feature/new-feature).
Make your changes and commit them (git commit -am 'Add a new feature').
Push the branch (git push origin feature/new-feature).
Create a new Pull Request.
License
This project is licensed under the MIT License. For more details, see the LICENSE file.

Contact
If you have any questions or comments about this project, feel free to contact me at kvnrodas@gmail.com.

All Rights Reserved © Kevin Rodas | Developed with ❤️
