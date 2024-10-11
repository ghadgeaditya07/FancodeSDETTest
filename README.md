# Fancode SDET Test Project

## Overview

This project is a solution for the Fancode SDET assignment. The project automates the verification of users from "FanCode city" having more than 50% of their todos completed. The project is built using:
- **Java**
- **REST-assured** for API automation
- **TestNG** for test execution

## Project Structure

fancode-sdet-assignment/
│
├── pom.xml                                  # Maven configuration file
├── README.md                                # Documentation
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   ├── services/
│                   │   ├── UserService.java            # Service to handle user-related operations
│                   │   ├── TodoService.java            # Service to handle todo-related operations
│                   └── utils/
│                       ├── ValidationUtils.java        # Utility to validate completion percentages
│                   └── tests/
│                       └── FancodeSDETTest.java        # Test class with TestNG test cases
└── target/                                     # Maven's build output




## Setup Instructions

### Prerequisites
To run this project, ensure that the following are installed:
- **Java 8 or higher**
- **Maven** (for dependency management)
- **Git** (for cloning the project)
- **IDE** (like Eclipse or IntelliJ IDEA)

### Clone the Project
1. Open a terminal and run the following command to clone the repository:

   ```bash
   git clone https://github.com/ghadgeaditya07/FancodeSDETTest.git

2.After cloning the project, navigate to the root project directory:

cd FancodeSDETTest

3. Install the Dependencies
This project uses Maven to manage dependencies. To install the necessary dependencies, run the following command:

mvn clean install

4. Run the Tests via Maven
To run the tests using Maven, execute the following command in your terminal:

mvn test




