# JWT Authentication Spring Boot Application

This project is a simple Spring Boot application demonstrating JWT (JSON Web Token) authentication. The application provides a single REST API endpoint for user authentication, which returns a JWT token upon successful authentication.

## Features

- **JWT Authentication**: Securely authenticate users and issue JWT tokens.
- **In-Memory Authentication**: Uses hardcoded credentials for demonstration purposes.
- **REST API**: Exposes a single endpoint for user authentication.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven or Gradle
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Install dependencies**:

   Using Maven:

   ```bash
   mvn install
   ```

### Configuration

1. **Configure `user.properties`**:

   Create a `src/main/resources/user.properties` file and add the following content:

   ```properties
   user.username=john_doe
   user.password=$2a$10$D9QZtCJZP8qElA4lhq9BOuXBtG.UVv5lEj5yXppUoFMLsmPDPmOqu
   ```

   Note: The `user.password` should be the BCrypt hashed password. You can generate it using the provided utility or online BCrypt hash generators.

2. **Configure JWT Secret**:

   Add your JWT secret key in the `src/main/resources/application.properties` file:

   ```properties
   jwt.secret=your_secret_key
   ```

### Running the Application

1. **Start the Spring Boot application**:

   Using Maven:

   ```bash
   mvn spring-boot:run
   ```

2. **Access the API**:

   The application will start on `http://localhost:8080`.

### API Endpoints

- **POST /authenticate**

  **Request Body**:

  ```json
  {
    "username": "john_doe",
    "password": "password123"
  }
  ```

  **Response** (On Successful Authentication):

  ```json
  {
    "token": "your_generated_jwt_token"
  }
  ```

  **Response** (On Failed Authentication):

    - Status: `401 Unauthorized`

### Note

- **CSRF Protection**: CSRF protection is disabled for simplicity. Ensure proper CSRF handling in production environments.
