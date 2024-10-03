# ** S4 SDAT QAP4 - OOP Maven, Junit Testing & Git Actions **
# ** Java Based - Medical Clinic Management System* *

Welcome to the **Medical Clinic Management System**! This Java-based project is designed for managing the operations of a medical clinic, including managing patients, doctors, and scheduling appointments. It follows **CLEAN CODE** principles and is supported by comprehensive unit testing with **JUnit 5**. Additionally, the project is automated with **GitHub Actions** to ensure Continuous Integration (CI) and Continuous Testing.

## **Table of Contents**
1. [Project Overview](#project-overview)
2. [Key Features](#key-features)
3. [Installation and Setup](#installation-and-setup)
4. [CLEAN CODE Practices](#clean-code-practices)
5. [Unit Testing Overview](#unit-testing-overview)
    - [Why Unit Testing is Important](#why-unit-testing-is-important)
    - [Test Coverage](#test-coverage)
    - [JUnit 5 Testing Details](#junit-5-testing-details)
6. [GitHub Actions & CI](#github-actions--ci)
    - [Maven Build Workflow](#maven-build-workflow)
    - [Testing Workflow](#testing-workflow)
7. [Branching Workflow](#branching-workflow)
8. [Developer Information](#developer-information)
9. [License](#license)

---

## **Project Overview**

The **Medical Clinic Management System** is built using **Java** and designed to manage patients, doctors, and appointments. The project follows **Object-Oriented Design** principles and uses **CLEAN CODE** practices for maintainability and scalability. The system is structured as a **Maven** project, ensuring ease of dependency management and build automation. Additionally, all core functionalities are verified through comprehensive unit tests, making it a robust and reliable application.

---

## **Key Features**

- **Patient Management**: Add, view, and search for patients by name or phone number.
- **Doctor Management**: Manage doctors and their specializations.
- **Appointment Scheduling**: Schedule and manage appointments between patients and doctors.
- **Comprehensive Unit Testing**: 25 unit tests covering all core functionalities of the system.
- **Continuous Integration**: Automated testing using **GitHub Actions** with separate workflows for building and testing.

---

## **Installation and Setup**

### **Prerequisites**
To run the project, you will need:
- **Java 18+**
- **Maven 3.8.1+**

### **Clone the Repository**

1. Clone the repository:
   ```bash
   git clone https://github.com/brendaleearmstrong/S4-SDAT-QAP1.git
   cd S4-SDAT-QAP1
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the project (if applicable):
   ```bash
   mvn exec:java
   ```

### **Running Unit Tests**
To run the unit tests:
```bash
mvn test
```

---

## **CLEAN CODE Practices**

The project follows **CLEAN CODE** principles, ensuring that the code is well-structured, maintainable, and easy to read. Key practices include:

1. **Meaningful Naming**: All variables, methods, and classes are named clearly and descriptively to reflect their roles.
2. **Single Responsibility Principle (SRP)**: Each class has one responsibility, such as managing patients, doctors, or appointments.
3. **Modularization**: The project is divided into packages (`model`, `service`, `cli`), ensuring that different parts of the system are independent and reusable.
4. **Avoiding Code Duplication**: Common functionalities are encapsulated in reusable methods and classes.
5. **Test-Driven Development**: Tests were written alongside the code, ensuring that all features work as expected.

---

## **Unit Testing Overview**

Unit testing is an integral part of the development process. The system is tested with **25 unit tests**, which cover the core components of the system. Each test verifies that the functionalities work as expected under normal and edge cases.

### **Why Unit Testing is Important**
- **Early Bug Detection**: Unit tests catch bugs early, reducing the cost of fixing issues later in development.
- **Improved Code Quality**: Writing tests forces developers to write cleaner, modular code.
- **Safe Refactoring**: With a robust suite of tests, code can be safely refactored without breaking existing functionality.
- **Documentation**: Tests serve as documentation, showing how different parts of the system are expected to work.

### **Test Coverage**

The project contains **25 unit tests** that cover:
- **PatientService**: Adding, searching, and retrieving patients.
- **DoctorService**: Adding and retrieving doctors by name or specialization.
- **AppointmentService**: Scheduling and retrieving appointments.
- **Model Tests**: The `Patient`, `Doctor`, and `Appointment` models are tested for correct behavior of constructors, getters, and setters.
- **CLI Tests**: The command-line interface for managing patients, doctors, and appointments is tested to ensure correctness.

### **JUnit 5 Testing Details**

Tests are implemented using **JUnit 5**. Key testing methods include:
- **Assertions**: Use of `assertEquals()`, `assertNotNull()`, and `assertTrue()` ensures that the code behaves as expected.
- **Setup and Teardown**: Tests use `@BeforeEach` for setup, ensuring a consistent starting state for each test.
- **Edge Case Testing**: The unit tests cover edge cases such as invalid inputs and boundary values to ensure the system handles unexpected scenarios correctly.

---

## **GitHub Actions & CI**

This project uses **GitHub Actions** to automate testing and building processes. The project uses **two workflows**:

### **Maven Build Workflow**

The **maven.yml** workflow builds the project when changes are pushed to the `main` branch or a pull request is created targeting `main`.

```yaml
name: Java CI with Maven

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v4
    - name: Set up JDK 22
      uses: actions/setup-java@v3
      with:
        java-version: '22'
        distribution: 'temurin'
        cache: maven
    - name: Build with Maven
      run: mvn -B package --file pom.xml
```

### **Testing Workflow**

The **testing.yml** workflow is triggered by pushes to the `testing` branch or pull requests targeting `main`. It builds the project and runs unit tests.

```yaml
name: Testing Workflow

on:
  pull_request:
    branches: [ "main" ]
  push:
    branches:
      - testing

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v4
    - name: Set up JDK 18
      uses: actions/setup-java@v4
      with:
        java-version: '18'
        distribution: 'temurin'
        cache: maven
    - name: Build with Maven
      run: mvn -B package --file pom.xml
    - name: Run Tests
      run: mvn test
```

---

## **Branching Workflow**

This project follows a **trunk-based development workflow** with the following branches:
- **Main branch**: This branch contains the production-ready code.
- **Dev branch**: This branch is used for feature development. Once the feature is stable, it is merged into `main` after testing.
- **Testing branch**: This branch is dedicated to running tests. Once the tests pass successfully, the changes are merged into `main`.

---

## **Developer Information**

**Brenda Armstrong**  
**Keyin College, Software Development**  
**SD10 Semester 4 - SDAT & DevOps**
