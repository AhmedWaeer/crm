<<<<<<< HEAD
<<<<<<< HEAD
# crm
# My first Java Spring boot project

## System Requirements


- Apache Tomcat
- Mysql
- Maven

Currently in progress:

- Deploying to AWS EC2
- API definition & integration with Frontend

---

# REST API Endpoints 
GET
​/customers
getAllCustomers
POST
​/customers
creatCustomer
GET
​/customers​/{id}
The Get User Details Web Service Endpoint
PUT
​/customers​/{id}
updateCustomer
DELETE
​/customers​/{id}
deleteCustomer
GET
​/customers​/{id}​/actions
getIncompleteActionsForCustomer
POST
​/customers​/{id}​/calls
recordBusinessCall
=======
# Customer Managment System
=======
#  Customer Managment System
>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e
#  Java Spring boot project


# General info 

<<<<<<< HEAD
The service is just a simple customer service system and can be part of customer relationship managment system(CRM). This system can perform customer CRUD operations. As well as, monitoring and recording customer business calls and actions related to this business call. The project focus is on the backend side, showing writing code skills, handling database, and developing Restful webservices and sharing them with frontend team.  
=======
The service is just a simple customer service system and can be part of customer relationship managment system(CRM). This system can perform customer CRUD operations. As well as, monitoring and recording customer business calls and actions related to this business call. The project focus is on the backend side, showing writing code skills, handling database, running unit testing and developing Restful webservices and sharing them with frontend team.  
>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e

------


# Technology Stack


| Component          | Technology              |
| ------------------ | ----------------------- |
| Backend (REST)     | Spring Boot (Java)      |
| REST Documentation | Swagger UI / Spring fox |
| REST Spec          | Open API Standard       |
| DB                 | MySQL                   |
| Persistence        | JPA (Using Spring Data) |
| Server Build Tools | Maven(Java)             |
| Application Server | Apache Tomcat           |

------


# REST API Endpoints 

To view Swagger ui API docs


> Run the server and browse to localhost:8080/swagger-ui/index.html

<<<<<<< HEAD


=======
>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e
- [`POST /crmsystem/customers`](#creatCustomerUsingPOST)
- [`DELETE /crmsystem/customers/{id}`](#deleteCustomerUsingDELETE)
- [`GET /crmsystem/customers`](#getAllCustomersUsingGET)
- [`GET /crmsystem/customers/{id}`](#getCustomerUsingGET)
- [`GET /crmsystem/customers/{id}/actions`](#getIncompleteActionsForCustomerUsingGET)
- [`POST /crmsystem/customers/{id}/calls`](#recordBusinessCallUsingPOST)
- [`PUT /crmsystem/customers/{id}`](#updateCustomerUsingPUT)

<<<<<<< HEAD
>>>>>>> cce254d98e7153c591442e47fac9fc016c1c76f7
=======
>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e

# Entities

## Customer

```json
{
  "ID": "xx",
  "CompanyName": "xx",
  "Email": "xx@x.com",
  "Telephone": 123,
<<<<<<< HEAD
<<<<<<< HEAD
  "Notes": "xxx",
  "Calls": "Calls[]",
  "Actions": "Actions[]"
=======
  "Calls": "Calls[]",
 
>>>>>>> cce254d98e7153c591442e47fac9fc016c1c76f7
=======

  "Notes": "xxx",
  "Calls": "Calls[]",
  "Actions": "Actions[]"

  "Calls": "Calls[]",
 

>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e
}
```

## Calls

```json
{
  "ID": String,
  "timestamp": datetime,
  "Notes": String
<<<<<<< HEAD
<<<<<<< HEAD
=======
   "Actions": "Actions[]"
>>>>>>> cce254d98e7153c591442e47fac9fc016c1c76f7
=======
   "Actions": "Actions[]"

>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e
}
```

## Actions

```json
{
  "ID": String,
  "details": String, //like notes
  "requiredBy": datetime,
  "CustomerId": Id,
  "isComplete": Boolean
}
```
<<<<<<< HEAD
<<<<<<< HEAD

# Tasks:

Phase I: Building BE Functionality (Done)

---

Phase II: Build Full-Stack (Customer List/Details)
**Target of Phase II: Online deployed link of FE connected to the BE thorugh OpenAPI**

- Define API Endpoints (done)

1. **GET /customers** (List)
2. **GET /customers/{{id}}** (Details)
   /GET /customers

```
[
    {
        ID: String,
        CompanyName:
        Email
        Telephone
        Notes
    }
]
```

/GET /customers/1234

```
{
    ID: 1234,
    CompanyName: xx
    Email: xx@xx.com
    Telephone: 123
    Notes: xx,
    Calls: [
        {
            "ID": String,
            "timestamp": datetime,
            "Notes": String
        }
    ],
    Actions: [
        {
            "ID": String,
            "details": String, //like notes
            "requiredBy": datetime,
            "CustomerId": Id,
            "isComplete": Boolean
        }
    ]
}
```

- Read about OpenApi (in progress)
- Find a genrator to Generate a API **swagger** file (using OpenApi) (in progress)
- Build Frontend (Tony) for two proposed endpoint (in progress)
- Deploy API to online server (AWS ?)
- Deploy Frontend (Netlify)
- Connect Frontend with API (HTTP) (no autnetication)

---

Phase III: System Improvements

- Secutiry
- Authentication
- Containerization
- CI/CD
=======
------
=======
>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e


# Setup 


The project is a Spring Boot application built using Maven. a jar file can be built and it can be run from the command line:
git https://github.com/AhmedWaeer/crm.git


> ./mvnw package
>
> java -jar target/*.jar


Or it can be run it from Maven directly using the Spring Boot Maven plugin:

> ./mvnw spring-boot:run

### Working with the project in IDE

### Prerequisites
The following items should be installed in the system:

- Java 8 or newer.
- git command line tool 
- Spring Tools Suite (STS) or Eclipse

#### Steps:

On the command line

> git clone https://github.com/spring-projects/spring-petclinic.git

Inside Eclipse or STS

File -> Import -> Maven ->  Existing Maven project
Then either build on the command line ./mvnw generate-resources or using the Eclipse launcher (right click on project and Run As -> Maven install) to generate the css. Run the application main method by right clicking on it and choosing Run As -> Java Application.
Before development, please install the following service software:

### MySQL

Edit the spring config profile src/main/resources/application.properties according to your settings.

### Install MySQL

> service mysql start
>
> mysql -u root -p;
>
> create database crm;


### Deploying the project to Tomcat 

change packaging in pom.xml to War instead of jar and then run the following command from cmd

------
> ./mvn install
------

the war file will be available in Target folder and ready to be deployed to Tomcat server.
<<<<<<< HEAD


>>>>>>> cce254d98e7153c591442e47fac9fc016c1c76f7

=======
>>>>>>> 9cc10df81f6a36530cadd444423d2c391a5cb65e
