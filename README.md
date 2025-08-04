# 🏥 Hospital Management System

A **Spring Boot**-based backend application for managing hospital operations including patients, doctors, appointments, and billing. This project demonstrates the use of RESTful APIs, layered architecture, and integration with a relational database (e.g., MySQL).

---

## 📌 Features

- 👨‍⚕️ Manage Doctors (Add, View, Update, Delete)
- 🧑‍💼 Manage Patients
- 📅 Schedule and manage Appointments
- 🧾 Generate and manage Bills
- 🗂️ RESTful APIs for all operations
- 🛡️ Structured project with service, repository, and controller layers

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (or H2 for local testing)
- Maven
- IntelliJ IDEA

---

## 📁 Project Structure

```plaintext
Hospital-Management-System/
├── src/
│   └── main/
│       ├── java/com/in/hospitalManagementSystem/
│       │   ├── controllers/
│       │   ├── models/
│       │   ├── repository/
│       │   ├── services/
│       │   └── Application.java
│       ├── resources/
│       │   └── application.properties
│   └── test/
│       └── java/com/in/hospitalManagementSystem/ApplicationTests.java
├── pom.xml
└── .gitignore
```

## 🛠️ Setup Instructions

### 1. Clone the repository

``` 
git clone https://github.com/vijay-vatarkar/Hospital-Management-System.git
cd Hospital-Management-System
```
### 2. Open in IntelliJ or your preferred IDE
- Make sure Java 17 and Maven are properly configured.

### 3. Configure the database
- In src/main/resources/application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
💡 You can use H2 for testing if MySQL is not set up.

### 4.Build and run the project
````
./mvnw spring-boot:run
````
OR run Application.java directly from your IDE.

### 🚀 API Endpoints (Sample)
- POST /doctors – Add doctor

- GET /doctors – View all doctors

- GET /patients/{id} – View patient by ID

- POST /appointments – Book an appointment

- POST /bills – Generate a bill

Test using Postman or any API client.

### ✅ TODO (Optional)
- Add authentication (Spring Security + JWT)
- Add Swagger/OpenAPI documentation
- Add frontend (React/Angular/Thymeleaf)
- Dockerize the app


### 🧑‍💻 Author
Vijay Kumar Vatarkar


### 📄 License
This project is open-source and free to use under the MIT License.
