# Advanced Security Project

## Overview
This is a Java-based security project designed to demonstrate the implementation of modern authentication and file handling practices using Spring Boot. The project includes secure user registration, login, and file upload features, ensuring compliance with best practices for securing sensitive data.

---

## Features
- **User Authentication and Authorization**:
  - Registration and login endpoints secured with JWT-based authentication.
  - Role-based access control.

- **File Management**:
  - Secure file upload and storage in a MySQL database.
  - File retrieval with content type validation.
  - File visualization endpoint for enhanced user interaction.

- **Security Enhancements**:
  - Prevention of CSRF attacks (optional depending on configuration).
  - XSS protection and prevention of malicious file uploads.

- **Development Tools**:
  - Integrated with Spring Boot DevTools for efficient development.
  - Powered by Hibernate Validator for input validation.

---

## Technologies Used
- **Backend**:
  - Java
  - Spring Boot (Data JPA, Security, Web, Validation, etc.)
- **Database**:
  - MySQL (with JDBC integration)
- **Security**:
  - JWT (JSON Web Tokens) for stateless authentication
  - Apache Tika for file type validation
  - BCrypt for password encryption

---

## How to Run
### Prerequisites:
1. **Java**: Ensure Java 11 or higher is installed.
2. **Maven**: Build the project using Maven.
3. **MySQL**: Set up a MySQL database and configure the connection in the `application.properties` file.

### Steps:
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/java-security-project.git
   ```

2. Navigate to the project directory:
   ```bash
   cd java-security-project
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application at:
   ```
http://localhost:8080

6.captures :
![loginAuth](https://github.com/user-attachments/assets/4fd99222-ff8b-4358-8f47-9336e7f844e3)
![securityUpload](https://github.com/user-attachments/assets/6256efad-a0df-40a0-b269-fd93d9a5f377)
![Uploaddata](https://github.com/user-attachments/assets/f3f4e406-136a-40af-a575-c366f1d2f0c3)
![Getupload](https://github.com/user-attachments/assets/0c069aaf-9ad5-4cf9-b25a-c223f9c26c44)
![basededonnee](https://github.com/user-attachments/assets/d64c3d1a-854b-427d-b66e-888fcee2008d)
![JWTTokenProvider](https://github.com/user-attachments/assets/ce75731e-954b-431f-ba8a-2b43f0a8dcce)
![JWTAuthentication](https://github.com/user-attachments/assets/5ae75bfb-5c5d-407e-8e9d-5d8cc66662dc)
![SecurityConfig](https://github.com/user-attachments/assets/6a7d91e1-6df1-43e9-8da8-42fe476b1fbf)
![Registerauth](https://github.com/user-attachments/assets/ccab9ddf-39e4-40b3-a3e2-de01834022a9)

```



---

## Endpoints
### Authentication Endpoints
- **POST /auth/register**: Register a new user.
- **POST /auth/login**: Log in with credentials.

### File Management Endpoints
- **POST /files/upload**: Upload a file.
- **GET /files/{id}**: Download a file by its ID.
- **GET /files/visualize/{id}**: View the contents of a file.

---

## Screenshots
### Project Capture:
![Project Screenshot](path/to/project-capture.png)

### Execution Example:
![Execution Example](path/to/execution-capture.png)

---

## Contribution
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a feature branch.
3. Submit a pull request with a detailed description.

---

## License
This project is licensed under the MIT License. See `LICENSE` for details.

---

## Contact
For questions or support, contact:
- Email: [your-email@example.com](mailto:your-email@example.com)
- GitHub: [your-username](https://github.com/your-username)


