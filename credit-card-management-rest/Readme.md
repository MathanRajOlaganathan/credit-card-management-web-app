# Credit Card Management Rest Service

## Requirements

1. Java - 1.16

2. Maven - 3.8.2

3. Spring Boot - 2.5.2

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/MathanRajOlaganathan/credit-card-management-web-app.git
```

**2. Build and run the app using maven**

```bash
cd credit-card-management-rest
mvn clean install
java -jar target/credit-card-rest-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```
Alternatively, you can run the built  jar which is  placed under credit-card-management-rest directory -

```bash
java -jar target/credit-card-rest-1.0.0.jar 
```

**3. Run the app using docker**

```bash
 docker run -p 8080:8080 mathanpointer/credit-card-rest:1.0.0
```

The server will start at <http://localhost:8080>

The swagger will start at <http://localhost:8080/swagger-ui/>

## Exploring the Rest APIs

The application defines following REST APIs

```
1. GET /api/sapient/creditcard - Get all credit cards

2. GET /api/sapient/creditcard/{id} - Find credit card by id

3. POST /api/sapient/creditcard - Add new credit card

{
  "cardNumber": "string",
  "cardHolderName": "string",
  "cardLimit": 0
}

```
## API Screenshots

**1.Get ALL Credit Cards**

<http://localhost:8080/api/sapient/creditcard>

![getAllCreditCards](https://github.com/MathanRajOlaganathan/credit-card-management-web-app/blob/main/credit-card-management-rest/images/getAllCreditCards.png)


**2.Get Credit Card By Id*

<http://localhost:8080/api/sapient/creditcard/1>.

![getCreditCardById](https://github.com/MathanRajOlaganathan/credit-card-management-web-app/blob/main/credit-card-management-rest/images/getCreditCardById.png)


**3.Add Credit Card**

POST
<http://localhost:8080/api/sapient/creditcard>.

![addCreditCard](https://github.com/MathanRajOlaganathan/credit-card-management-web-app/blob/main/credit-card-management-rest/images/addCreditCard.png)




