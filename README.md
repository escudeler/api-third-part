# API Third Part
Third Part - Demo project for gRPC

## Projects list for gRPC example
**Follow the respectives readmes for build and execute them in following list order:**
```sh
git clone https://github.com/escudeler/api-common-proto.git
git clone https://github.com/escudeler/api-listen.git
git clone https://github.com/escudeler/api-speak.git
git clone https://github.com/escudeler/api-third-part.git
```

## Prerequisites
You have installed:
 - JDK 11
 - Maven
 - Docker (docker-compose 1.13.0+)

## Initialize Project 
**Execute this commands on the project folder**

- In the folder where is Dockerfile, you must execute:
```sh
# build project with your dependencies
mvn clean package

# generate image
docker build -t escudeler/api-third-part .
```
- In the folder where is docker-compose.yml, you must execute:
```sh
# up container
docker-compose up -d
```

**For logs**
```sh
docker logs -f api-third-part
```

**Postman Collection**
- The Posts examples can be obtained [Here](https://www.getpostman.com/collections/ad0f4be8e0eb643d4cde).

## Specification of gRPC

API Third Part's service use gRPC connection for fastest integration with **Speak** API.
- Method: **authorize** -> generate authorization for (server of) the Speak API to communicate with the Listen API in response to "Person".

_More info about gRPC Communication is in [Third Part Service Proto](https://github.com/escudeler/api-common-proto/blob/master/src/main/proto/ThirdPartService.proto/)._
