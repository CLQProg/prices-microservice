# Project prices-microservice

## Overview

This repository contains the solution for a technical test in the microservices domain.
The project provides an API for managing product prices.

### Project Details

- **Group ID**: `es.technical.test.microservices`
- **Artifact ID**: `prices-microservice`
- **Version**: `0.0.1-SNAPSHOT`
- **Name**: `prices`
- **Description**: API for managing product prices.

## POM review

### Dependencies:

The project utilizes various dependencies for different functionalities:

- **Spring Modules**:
    - spring-boot-starter.
    - spring-boot-starter-web.
- **DB Module**:
    - spring-boot-starter-data-jpa.
    - flyway-core.
    - jakarta.validation-api.
    - hibernate-validator.
    - h2 (runtime).
- **OpenAPI Module**:
    - springfox-swagger2.
    - swagger-annotations.
    - jackson-databind-nullable.
    - springdoc-openapi-starter-webmvc-ui.
- **Mappers Module**:
    - jackson-databind.
    - mapstruct.
- **Tools**:
    - lombok.
- **Testing Module**:
    - spring-boot-starter-test (test scope).
    - junit-vintage-engine.
    - junit-jupiter-engine.
    - mockito-junit-jupiter.
    - podam.
    - cucumber-java.
    - cucumber-junit.
    - cucumber-spring.
- **Monitoring Module**:
    - slf4j-api.
    - logstash-logback-encoder.

### Plugins

The pom.xml file includes several plugins for different purposes:

- **Maven Plugins**:
    - maven-surefire-plugin: To execute unit tests.
    - maven-failsafe-plugin: To execute integration tests.
    - maven-source-plugin.
    - maven-compiler-plugin: To compile source code and process annotations like Lombok and MapStruct.
    - maven-jar-plugin.
    - maven-install-plugin.
    - maven-deploy-plugin.
    - maven-dependency-plugin: To unpack OpenAPI dependencies.
- **Spring Boot Plugin**:
    - spring-boot-maven-plugin: To package the application as an executable JAR file.
- **OpenAPI Plugin**:
    - OpenAPI Generator Maven Plugin: To generate Java code from an OpenAPI specification.
- **Coverage Plugin**:
    - jacoco-maven-plugin: To generate code coverage reports.
- **Code Analysis Plugin** (To perform static code analysis, style checking, and dependency analysis):
    - sonar-maven-plugin.
    - dependency-check-maven.
    - maven-checkstyle-plugin.
    - maven-javadoc-plugin.
    - dependency-check-maven.
    - spotbugs-maven-plugin.
    - maven-pmd-plugin.

### Profiles

The pom.xml file defines several profiles, such as coverage, code analysis, and integration tests, which can be
activated as per the project's needs.

1. **Coverage Profile**:
    - Activated when `skipCoverage` property is not set.
    - Adds coverage reports to testing.
2. **Code Analysis Profile**:
    - Activated when `skipCodeAnalysis` property is not set.
    - Performs static code analysis and style checks.
3. **Integration Test Profile**:
    - Activated by default.
    - Executes integration tests.
4. **Sonar Profile**:
    - Activated when explicitly chosen.
    - Analyzes the project with SonarQube.

### How to Run tests and code analysis:

- Clone this repository, preferably the master branch.

- To run tests and generate coverage:
  ```
  mvn clean verify -Pcoverage
  ```
- To perform static code analysis and style checks:
  ```
  mvn clean verify -PcodeAnalysis
  ```
- To execute integration tests:
  ```
  mvn clean verify -PintegrationTest
  ```
- To analyze the project with SonarQube, create a project in your SonarQube and modify the projectKey,
  the host.url and the token within the sonar-project.properties file in the root of this project. Then
  execute this command:
  ```
  mvn sonar:sonar -Psonar
  ```

### How to run the app

Run the application with your IDE and launch GET HTTP requests to http://localhost:8080/prices
with the following mandatory parameters in the form of a query: productId, brandId and a date.
The easiest way is to use the Swagger UI: http://localhost:8080/swagger-ui/index.html
<br>
You can also use Postman or a terminal:

  ```
  curl -X GET "http://localhost:8080/v1/prices?productId=35455&brandId=1&date=2020-06-14-10.00.00"
  ```


## Source Code Review

### Hexagonal Architecture

Hexagonal Architecture, also known as Ports and Adapters Architecture, is a design pattern that emphasizes the
separation of concerns and the decoupling of application logic from external dependencies. Here's why I chose to design
our application using Hexagonal Architecture and its advantages:

- Modularity and Separation of Concerns

Hexagonal Architecture organizes the application into distinct layers: the core business logic, input and output
adapters, and external dependencies. This separation facilitates better understanding, maintenance, and testing of each
component independently.

- Flexibility and Adaptability

Decoupling the application logic from external dependencies allows for easier swapping or modification of components.
For instance, we can replace a database with minimal changes to the core business logic.

- Testability

Hexagonal Architecture promotes easier unit testing of the core business logic without relying on external dependencies.
Mocking or stubbing adapters enables isolated testing, leading to comprehensive test coverage and faster test execution.

- Portability and Technology Agnosticism.

Reducing dependencies on specific frameworks or technologies makes the application more portable and adaptable to
different environments. This flexibility is invaluable as technology landscapes evolve over time.

- Domain-Driven Design (DDD) Alignment

Hexagonal Architecture complements Domain-Driven Design principles by emphasizing a clear separation between the domain
model and infrastructure concerns. This alignment fosters a domain-centric approach to application design, improving
domain understanding and maintainability.

- Clear Boundaries and Contracts

The use of ports and adapters explicitly defines interfaces (ports) through which the application interacts with
external systems. This approach establishes clear boundaries and contracts between different parts of the system,
promoting better communication and collaboration among development teams.

- Resilience and Fault Isolation

Encapsulating external dependencies within adapters enhances system resilience by preventing failures in external
systems from propagating to the core business logic. This isolation improves system stability and fault tolerance.

In summary, Hexagonal Architecture offers a structured and adaptable approach to designing software systems, promoting
modularity, flexibility, testability, and resilience. These benefits make it particularly suitable for complex
applications where maintainability, scalability, and evolution are critical considerations.

### Main Design Patterns

Ports and Adapters (Hexagonal Architecture)

- Purpose: Ports and Adapters pattern defines a clear separation between the core business logic (ports) and external
  dependencies (adapters).
- Benefits: Encourages modularity, testability, and flexibility by allowing different implementations of adapters
  without affecting the core logic.

Dependency Inversion Principle (DIP)

- Purpose: DIP decouples high-level modules from low-level modules by introducing abstractions and relying on interfaces
  rather than concrete implementations.
- Benefits: Promotes flexibility, maintainability, and testability by reducing the direct dependencies between
  components and allowing for easier substitution of implementations.

Dependency Injection (DI)

- Purpose: DI is a fundamental pattern in Spring Boot that facilitates loose coupling and inversion of control by
  injecting dependencies into classes rather than having them create dependencies themselves.
- Benefits: Promotes modularity, testability, and maintainability by decoupling components and allowing for easier
  replacement or customization of dependencies.

Repository

- Purpose: Repository pattern abstracts data access logic from higher-level business logic by providing a consistent
  interface for interacting with a data source (e.g., database).
- Benefits: Improves maintainability, testability, and flexibility by encapsulating database interactions and providing
  a clear separation between business logic and data access concerns.

In summary, while both Hexagonal Architecture and Spring Boot emphasize principles such as modularity, abstraction, and
separation of concerns, they utilize different design patterns to achieve these goals. Understanding and applying these
patterns appropriately can lead to more robust, maintainable, and scalable software solutions.

![ALT TEXT](https://www.baeldung.com/wp-content/uploads/2019/12/DDD-Layers-implemented.png)
*<small>Font: https://www.baeldung.com/wp-content/uploads/2019/12/DDD-Layers-implemented.png</small>*

### Gherkin and Cucumber for Integration Testing

I chose to use Gherkin and Cucumber for integration testing due to several compelling reasons:

- Business Readability

Gherkin is a human-readable language that uses a simple syntax to describe the behavior of software in a natural
language format. This allows stakeholders, including non-technical members of the team, to understand and contribute to
the test scenarios easily.

- Collaboration and Communication

Gherkin scenarios serve as living documentation that bridges the gap between business requirements and technical
implementation. By writing scenarios in a structured format, stakeholders, developers, and testers can collaborate
effectively to ensure that the software meets the intended functionality.

- Test Automation

Cucumber enables the automation of Gherkin scenarios, turning them into executable tests. By automating these tests, we
ensure consistent and repeatable verification of the application's behavior across different environments and
configurations.

- Maintainability and Scalability

The modular nature of Gherkin scenarios allows us to create reusable step definitions that can be shared across multiple
scenarios. This promotes code reusability, reduces duplication, and enhances the maintainability of the test suite as
the application evolves.

- Behavior-Driven Development (BDD) Approach

Gherkin and Cucumber follow the principles of Behavior-Driven Development (BDD), which encourages focusing on the
desired behavior of the system from a user's perspective. This approach helps align development efforts with business
objectives, leading to the creation of software that meets user needs effectively.

- Cross-Functional Team Involvement

By using Gherkin and Cucumber, we involve stakeholders from different roles, including product owners, business
analysts, developers, and testers, in the testing process. This collaboration ensures that everyone has a shared
understanding of the system's behavior and promotes collective ownership of quality.
Integration with Continuous Integration (CI) Pipelines

Cucumber tests can be easily integrated into Continuous Integration (CI) pipelines, allowing us to automate the
execution of tests whenever changes are made to the codebase. This enables early detection of issues, faster feedback
loops, and ensures that the application remains reliable and stable.

In summary, the combination of Gherkin and Cucumber offers a powerful approach to integration testing that emphasizes
collaboration, readability, automation, and alignment with business objectives. These benefits make it a valuable choice
for ensuring the quality and reliability of our software.

## Support

Please enter an issue in the repo for any questions or problems.
<br> Alternatively, please contact me at carlos.lencina.q@gmail.com