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
![JWTAuthentication](https://github.com/user-attachments/assets/529e0fe8-227d-4ce4-9ccd-3dd5e9ac51f7)
![SecurityConfig](https://github.com/user-attachments/assets/dc896a2a-8b15-41c3-9835-995ed0a6c3c4)
![Registerauth](https://github.com/user-attachments/assets/5671bbc0-c369-493b-b0af-deda4bec3057)
![loginAuth](https://github.com/user-attachments/assets/2d452bda-e6ea-46f9-8b82-358ceccef585)
![securityUpload](https://github.com/user-attachments/assets/4a244bcc-6390-4c6b-a780-e1d8155a4c0f)
![Uploaddata](https://github.com/user-attachments/assets/4cba055a-37d6-4e9b-998c-62e77006a3fd)
![Getupload](https://github.com/user-attachments/assets/f33ef11f-d807-4838-8195-60bee0cabd51)
![basededonnee](https://github.com/user-attachments/assets/f4845b92-0298-4665-b8bf-bd9a3260086c)
![JWTTokenProvider](https://github.com/user-attachments/assets/a0dc64a3-cb51-48a7-a3b7-1aabd9456a09)

