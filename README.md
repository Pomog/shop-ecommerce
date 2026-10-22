# Shopme E-Commerce

**A multi-module e-commerce web application built with Java and Spring Boot.**

This project is being developed to explore backend engineering, modular application architecture, relational persistence, and web application development.

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4.1.1
- **Build system:** Apache Maven
- **Web:** Spring MVC, Thymeleaf
- **Persistence API:** Jakarta Persistence (JPA)
- **Database:** MySQL (integration planned)
- **Development environment:** VS Code, Ubuntu Linux

## Project Architecture

| Module | Responsibility |
|---|---|
| `shop01` | Root Maven parent and aggregator |
| `shopmecommon` | Shared domain classes and JPA entities |
| `shopmeweb` | Parent configuration for web applications |
| `shopmebackend` | Administration application |
| `shopfrontend` | Customer-facing web application |

The project uses Maven's multi-module reactor and parent POM inheritance to organize the applications and shared code.

## Current Status

**Work in progress — initial project setup completed.**

- [x] Multi-module Maven configuration
- [x] Java 21 and Spring Boot 4.1.1 setup
- [x] Shared Common module
- [x] Backend and Frontend application scaffolding
- [x] Successful Maven build
- [ ] Implement shared domain entities
- [ ] Integrate MySQL persistence
- [ ] Implement product and category management
- [ ] Implement customer-facing shopping functionality
- [ ] Add authentication and authorization
- [ ] Expand automated tests

## Build

**Requirements:** JDK 21 and Maven.

From the repository root:

`cd common/shop01`

`mvn clean package`

The command builds the multi-module project.

## Run Frontend

After building the project:

`java -jar common/shopwebparent/shopmeweb/shopfrontend/target/shopfrontend-0.0.1-SNAPSHOT.jar --server.port=8080`

Run this command from the repository root.

Then open `http://localhost:8080`.

## Learning and Development

This project started as part of the Java Spring Boot E-Commerce Ultimate Udemy course. I am adapting the implementation to Java 21 and Spring Boot 4.1.1 and using it to develop my skills in Java, Spring Boot, and application architecture.

**Course reference:** [Java Spring Boot E-Commerce Ultimate](https://www.udemy.com/course/spring-boot-e-commerce-ultimate/)