# Backend Architecture Overview

This project is a **modular backend API** built with **Spring Boot**, designed to be reusable across multiple projects.
The architecture focuses on **clean structure, consistent API responses, centralized exception handling, and
extensibility**.

Main technologies used:

* Spring Boot
* Spring Security
* JWT Authentication
* MyBatis
* Flyway
* OpenAPI / Swagger

---

# 1. Project Structure

The project follows a **layered modular architecture**.

```
src/main/java/com/api/coreapi

auth
 ├── controller
 ├── service
 ├── mapper
 └── dto

sys
 ├── controller
 ├── service
 ├── mapper
 └── dto

common
 ├── config
 ├── constant
 ├── dto
 ├── exception
 ├── response
 └── util

security
 ├── JwtAuthenticationFilter
 ├── SessionUser
 └── JwtProperties
```

### Module Responsibilities

| Module   | Responsibility                                      |
|----------|-----------------------------------------------------|
| auth     | Authentication APIs and JWT logic                   |
| sys      | System-level modules (users, roles, permissions)    |
| common   | Shared utilities, DTOs, response models, exceptions |
| security | Security filters and JWT handling                   |
| config   | Application configurations                          |

---

# 2. API Response Format

All APIs return a **standardized response structure**.

Example response:

```json
{
  "code": "200",
  "message": "Success",
  "data": {}
}
```

Response model:

```
BaseResponseDto<T>
```

Fields:

| Field   | Description          |
|---------|----------------------|
| code    | response status code |
| message | response message     |
| data    | response payload     |

Response creation is centralized through:

```
ResponseReturn
```

Example usage:

```
return ResponseReturn.success(data);
```

---

# 3. Exception Handling

The system uses **centralized exception handling**.

Main components:

```
BaseApiException
BadRequestException
UnauthorizedException
ForbiddenException
NotFoundException
GlobalExceptionHandler
```

Example error response:

```json
{
  "code": "USER_NOT_FOUND",
  "message": "User not found",
  "data": null
}
```

Advantages:

* Consistent error format
* Clean controller code
* Easier debugging

---

# 4. Authentication & Security

Authentication is implemented using **JWT (JSON Web Token)**.

Main components:

```
JwtAuthenticationFilter
JwtProperties
SessionUser
```

Authentication flow:

```
Client
  ↓
Security Filter Chain
  ↓
JwtAuthenticationFilter
  ↓
Controller
  ↓
Service
```

Clients must send the token in the header:

```
Authorization: Bearer <token>
```

---

# 5. Database Layer

The project uses **MyBatis** for database access.

Structure:

```
mapper
 ├── UserMapper.java
 └── UserMapper.xml
```

Responsibilities:

| Layer            | Role           |
|------------------|----------------|
| Mapper Interface | Java interface |
| Mapper XML       | SQL queries    |

Example query:

```sql
SELECT *
FROM users
WHERE id = #{id}
```

---

# 6. Database Migration

Database schema changes are managed using **Flyway**.

Migration files location:

```
src/main/resources/db/migration
```

Example files:

```
V1__init_schema.sql
V2__create_user_table.sql
```

Flyway runs automatically when the application starts.

---

# 7. API Documentation

API documentation is generated using **OpenAPI / Swagger**.

Available endpoints:

```
/swagger-ui/index.html
/v3/api-docs
```

Swagger automatically scans controllers and generates API documentation.

---

# 8. Request Flow

Typical API request flow:

```
Client
   ↓
Security Filter
   ↓
Controller
   ↓
Service
   ↓
Mapper (MyBatis)
   ↓
Database
```

Responsibilities:

| Layer      | Responsibility       |
|------------|----------------------|
| Controller | Handle HTTP request  |
| Service    | Business logic       |
| Mapper     | Database interaction |
| Database   | Data storage         |

---

# 9. Coding Principles

The project follows these design principles:

* Controllers contain **no business logic**
* Services handle **business rules**
* Mappers handle **database queries**
* Responses follow **a consistent structure**
* Exceptions are **centralized**

This ensures:

* Maintainability
* Scalability
* Clean architecture

---

# 10. Planned Core Improvements

Future enhancements planned for the core template:

* CORS configuration
* Global date/time format (UTC)
* Pagination response model
* Request logging filter
* Request ID tracing
* API versioning

These features will improve maintainability and production readiness.
