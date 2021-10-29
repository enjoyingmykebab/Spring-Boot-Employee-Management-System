BONDO PANGAJI EMS
============

[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/bondopangaji/Spring-Boot-Employee-Management-System/Java%20CI%20with%20Maven?style=for-the-badge)](https://github.com/bondopangaji/Spring-Boot-Employee-Management-System/actions/workflows/maven.yml) [![GitHub release (latest by date)](https://img.shields.io/github/v/release/bondopangaji/Spring-Boot-Employee-Management-System?style=for-the-badge)](https://github.com/bondopangaji/Spring-Boot-Employee-Management-System/releases/) [![License](https://img.shields.io/badge/license-MIT-green?style=for-the-badge)](./LICENSE) [![GitHub contributors](https://img.shields.io/github/contributors/bondopangaji/Spring-Boot-Employee-Management-System?style=for-the-badge)](https://github.com/bondopangaji) [![GitHub last commit](https://img.shields.io/github/last-commit/bondopangaji/Spring-Boot-Employee-Management-System?style=for-the-badge)](https://github.com/bondopangaji/Spring-Boot-Employee-Management-System/commits/) [![GitHub Release Date](https://img.shields.io/github/release-date/bondopangaji/Spring-Boot-Employee-Management-System?style=for-the-badge)](https://github.com/bondopangaji/Spring-Boot-Employee-Management-System/releases/) [![GitHub language count](https://img.shields.io/github/languages/count/bondopangaji/Spring-Boot-Employee-Management-System?style=for-the-badge)](#) [![GitHub top language](https://img.shields.io/github/languages/top/bondopangaji/Spring-Boot-Employee-Management-System?style=for-the-badge)](#) [![GitHub repo size](https://img.shields.io/github/repo-size/bondopangaji/Spring-Boot-Employee-Management-System?style=for-the-badge)](#)

## Overview
Bondo Pangaji EMS is a web application created to manage and maintain employee details within a company, this project intended to complete *Spring Boot Project "Enterprise Application"* assigned by Faculty Muhamad Hudya Ramadhana in the third semester. Professional Program in Information Technology (Software Engineering), CCIT - Fakultas Teknik Universitas Indonesia.

## Features
- Manage employee
- Manage payroll
- Payroll invoice

## Technology Stack
This project a number of technology to work properly
- Java 11
- Maven 3.6.3
- Spring Boot 2.5.5
- Java Presistence API
- Hibernate ORM
- Thymeleaf 2.5.5
- MySQL + Apache Tomcat
- JUnit 5.7.2
- Mockito 3.9.0

## Preview
#### Login
![Preview1](https://github.com/bondopangaji/Employee-Management-System-Spring-Boot/blob/main/preview/employee-mgmt-login.png?raw=true)
#### Admin Dashboard (Manage Employee)
![Preview2](https://github.com/bondopangaji/Employee-Management-System-Spring-Boot/blob/main/preview/employee-mgmt-emp.png?raw=true)
#### Admin Dashboard (Manage Payroll)
![Preview1](https://github.com/bondopangaji/Employee-Management-System-Spring-Boot/blob/main/preview/employee-mgmt-payroll.png?raw=true)
#### Employee Dashboard (Invoice)
![Preview1](https://github.com/bondopangaji/Employee-Management-System-Spring-Boot/blob/main/preview/employee-mgmt-invoice.png?raw=true)

## Installation

Install required dependency\
Import ems.sql into MySQL and start the web server\
Open terminal in project directory

Compile + package the project:
```sh
mvn clean install
```
Run the project:
```sh
mvn spring-boot:run
```
Stop the project:
```sh
mvn spring-boot:stop
```
## User Credentials
#### Admin
- Email: admin@bondopangaji.com
- Password: password
#### Employee
- Email: employee1@bondopangaji.com
- Password: password

## License
- [MIT License](https://choosealicense.com/licenses/mit/)
- [AdminLTE License](https://adminlte.io/docs/2.4/license)

## Author
- [Bondo Pangaji](https://github.com/bondopangaji)
