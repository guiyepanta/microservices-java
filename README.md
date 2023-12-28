# microservices-java
Ejercicio de desarrollo de microservicios.


## Para el despliegue en Docker:
### Linux:
ejecutar el siguiente script

```bash
./start.sh
```
### Windows:
ejecutar los siguientes comandos
```bash
docker-compose down
docker rmi eureka-server:latest
docker rmi api-gateway:latest
docker rmi user-service:latest
docker rmi product-service:latest
docker rmi order-service:latest

mvn clean install -f ./eureka-server/pom.xml
mvn clean install -f ./api-gateway/pom.xml
mvn clean install -f ./user-service/pom.xml
mvn clean install -f ./product-service/pom.xml
mvn clean install -f ./order-service/pom.xml

docker build -t eureka-server:latest -f ./eureka-server/Dockerfile ./eureka-server
docker build -t api-gateway:latest -f ./api-gateway/Dockerfile ./api-gateway
docker build -t user-service:latest -f ./user-service/Dockerfile ./user-service
docker build -t product-service:latest -f ./product-service/Dockerfile ./product-service
docker build -t order-service:latest -f ./order-service/Dockerfile ./order-service

docker-compose up -d

mvn flyway:migrate -f ./user-service/pom.xml
mvn flyway:migrate -f ./product-service/pom.xml
mvn flyway:migrate -f ./order-service/pom.xml

```


## API Reference

#### Get all items via api-gateway

```http
  GET http://localhost:9876/user-service/
  GET http://localhost:9876/product-service/
  GET http://localhost:9876/order-service/
```

#### Get all items via services
```http
  GET http://user-service:5555/user-service/
  GET http://product-service:6666/product-service/
  GET http://order-service:7777/order-service/
```
#### Get item via api-gateway

```http
  GET http://localhost:9876/user-service/{id}
  GET http://localhost:9876/product-service/{id}
  GET http://localhost:9876/order-service/{id}
```

#### Get item via services
```http
  GET http://user-service:5555/user-service/{id}
  GET http://product-service:6666/product-service/{id}
  GET http://order-service:7777/order-service/{id}
```

#### Add order
```http
  // via gateway
  POST http://localhost:9876/order-service/
  // via service
  POST http://order-service:7777/order-service/

    // body:
    {
        "userId": 1,
        "orderLines": [
            {
                "productId": 1,
                "quantity": 1
            },
            {
                "productId": 2,
                "quantity": 1
            },
            {
                "productId": 3,
                "quantity": 2
            }
        ]
    }
```
## Stack tecnológico

**Client:** Java 17, Springboot framework, Maven

**Server:** Postgres, Spring Cloud Eureka server
## Authors

- [github: guiyepanta](https://github.com/guiyepanta)
