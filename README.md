-----Inventory Management System – Backend (Spring Boot)-----

This is the backend part of the Full Stack Inventory Management System.
It provides REST APIs for managing products, stock, and orders.

--->Technology Stack

Backend: Java, Spring Boot
Database: MySQL
API: RESTful services
Build Tool: Maven

--->Frontend Repository

The frontend of this project is built using Angular, TypeScript, HTML, CSS:
[Inventory Management System – Frontend](https://github.com/preethi-fullstack/ims-frontend)

--->Features

Add, update, and delete products
Track stock levels
Process orders
REST API endpoints for frontend integration

--->Project Structure

InventorySystem/
├─ src/main/java/com/example/inventorysystem
│ ├─ controller/ → REST controllers
│ ├─ model/ → Java entity classes
│ ├─ repository/ → Database interfaces
│ └─ service/ → Business logic
├─ src/main/resources
│ └─ application.properties → Database & Spring Boot configuration
└─ pom.xml → Maven dependencies

--->How to Run

Clone the repo: git clone https://github.com/preethi-fullstack/ims-backend.git
Open the project in Eclipse or VS Code
Configure MySQL database in application.properties
Run InventorySystemApplication.java as a Java application
Backend will run on http://localhost:8080/

--->Contribution
This repo is mainly for demonstration as part of my full stack project.
The frontend communicates with this backend via REST API.

This repo is mainly for demonstration as part of my full stack project.
The frontend communicates with this backend via REST API.
