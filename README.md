# Documentation
## Design Patterns
This project is using MVC design pattern, Singleton pattern and Dependency Injection pattern.

## MVC design pattern
This project contains controller(C), model(M). Packages are separated by layer and then by feature. 
List of packages:
    - Constant
      Contains all the enum and constants
    - Controller
      Handle all API requests.
    - Database
      Using hibernate. It performs CRUD operation on database.
    - Exception
      Contains all custom exceptions. 
    - Job
      Contains all spring batch jobs. Extract the data from datasource and insert into database
    - Model
      Contains database model, response object model etc
    - Security
      Custom security to do basic auth on every request. Could implement jwt auth as well.
    - Service
      Contains all business logics for controllers.
    - Util
      Contains all data utils and pagination utils that will be used by other controllers

## Singleton pattern
This project is using @Bean, @Component, @Service to define a singleton and initialize it 

## Dependency Injection pattern(DI)
@Autowired is used to do inject dependency. 

## Class diagram
[Class diagram link](https://drive.google.com/file/d/1-6JgI7J1BXu8SyZpG9d_GaWdgc5vc_F2/view?usp=sharing)

## Activity diagram
[Activity diagram link](https://drive.google.com/file/d/1YZClnLskrm-uXclyRYyAWzn5URjPdYlr/view?usp=sharing)
