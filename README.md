# README #

This project is a definition of an application for a technical test for the company CI&T.
The main goal of this project is to create an API to manipulate data related to olympic competitions. 

### PROJECT REQUIREMENTS ###

* Java 8
* Maven 3.3.9

### HOW TO CONFIGURE ###

1. Import the project as maven project using an IDEA

### HOW TO RUN AS WEB APPLICATION ###

1. Execute **mvn install** inside of the **root folder**
2. Execute **mvn spring-boot:run** inside of the **root folder**
3. Use the following address **http://localhost:8080/** to access the API endpoints.

### ENDPOINTS ###

* GET /competitions
* GET /competitions/types
* POST /competitions
* GET /sports
* GET /places