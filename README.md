# Student Management System (Spring Boot + React)

This is a full-stack CRUD application built for the Advance OOP take-home assignment.

The system allows managing students using a Spring Boot REST API and a React TypeScript frontend.

---

## Project Structure

advance-oop-tests/
├── backend/
├── frontend/
├── .devcontainer/
└── README.md


---

## Technologies

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database

### Frontend
- React
- TypeScript

---

## How to Run

### Start Backend

```bash
cd backend
./mvnw spring-boot:run ```

Backend runs at:
http://localhost:8080
API Endpoints

POST /students
GET /students
GET /students/{id}
PUT /students/{id}
PATCH /students/{id}
DELETE /students/{id}
