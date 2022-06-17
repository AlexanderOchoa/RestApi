# RestApi
REST API to insert and list the grades.

# Java
Version 8

# Spring Boot
Version 2.1.5.RELEASE

# Spring Framework
Version 5.1.7.RELEASE

# Port
8090

# Security
endpoint: /login

**username**: EO2022
**password**: 12345

**username**: SR2022
**password**: 67891

# Manage Dependencies
Maven

# DB
Embedded DB (H2)

Pre inserted data: src/main/resources/import.sql

# Endpoints
http://localhost:8090/login (POST)

http://localhost:8090/v1/grades (POST and GET)

# Test REST API
Use RestApi.postman_collection.json