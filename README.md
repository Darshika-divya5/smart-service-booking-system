# Smart Service Booking System

A backend application built using Spring Boot that allows users to book services and enables admins to manage bookings, services, and users securely.

## Project Overview

The Smart Service Booking System is designed to simulate real-world service booking workflows.  
It provides secure authentication, role-based authorization, and efficient booking management using REST APIs.
This project focuses on building a scalable backend architecture with proper layering and security implementation.

##  Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- MySQL (Relational Database)
- REST APIs
- Postman (API Testing)

##  Features

- User authentication using JWT
- Role-based authorization (ADMIN, USER)
- Secure REST API endpoints
- Booking management system (Create, Update, Delete, Filter)
- Layered architecture (Controller, Service, Repository)
- Real-world database handling using MySQL
- API testing and validation using Postman

##  Project Architecture

The project follows a layered architecture:

- **Controller Layer** → Handles incoming API requests
- **Service Layer** → Contains business logic
- **Repository Layer** → Handles database operations using JPA
- **Security Layer** → Manages authentication and authorization using JWT

##  Authentication & Security

- Implemented JWT-based authentication
- Custom JWT filter to validate requests
- Secured endpoints using Spring Security
- Role-based access control for ADMIN and USER

##  Database Design

- Used MySQL to store application data
- Entities include:
  - User
  - Service
  - Provider
  - Booking
- Managed relationships using JPA (Hibernate)
- Inserted 20+ real-world sample records for testing

---

##  API Endpoints

- Authentication APIs (Login)
- Booking APIs (Create, Update, Delete, Filter)
- User and Service management APIs

All APIs are tested using Postman.

##  Testing

- Tested all REST APIs using Postman
- Verified authentication using Bearer Token
- Ensured proper request and response handling

##  Key Highlights

- Implemented secure backend using JWT and Spring Security
- Designed scalable layered architecture
- Built and tested multiple REST API endpoints
- Worked with real-world database scenarios

---

## Future Improvements

- Add frontend (React / Angular)
- Implement real user registration system
- Add payment integration
- Deploy application on cloud




