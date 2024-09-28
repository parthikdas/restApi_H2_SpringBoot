# Rest Api in SpringBoot

## Description
This is a simple api build in springboot using STS4.

## Features
- Feature 1: Get all the users details.
- Feature 2: Get a particular user detail by specifying id.
- Feature 3: Create a new user.
- Feature 4: Update user details by specifying id and new details body.
- Feature 5: Delete a user by specifying id.

## Dependencies
 - Spring Boot Starter web
 - JPA
 - Spring Dev tools
 - H2 Database
 - Mockito
 
# Testing
 - Postman testing is done
 - curl Testing is done :
 	curl -X GET http://localhost:8080/api/users/
 	curl -X POST http://localhost:8080/api/users/ -H "Content-Type: application/json" -d '{"name":"John Doe","email":"john@example.com","password":"password123"}'
 - mockito testing is done, tests are available in src/test/java	