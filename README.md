# Dice Rolls Simulator

Dice rolling simulator project built using spring boot and angular typescript

## Getting Started

git clone https://github.com/rodolfoldelapenajr/rldp-dice-app.git

### Prerequisites

- Java 8 or above
- Maven 3.6.0 or above
- Node Package Manager 6.13.4
- Mongodb 4.0.10
- Database named "diceapp-db" created in mongodb

### Installing

#### Type the following in the commandline

- cd rldp-dice-app/rldp-diceapp-service
- mvn clean install

- cd rldp-dice-app/rldp-diceapp-ui
- npm install

## Deployment

#### Local deployment
##### Start mongodb
Linux
- sudo service mongod start

Windows
- From Windows Explorer/File Explorer, go to C:\Program Files\MongoDB\Server\4.2\bin\ directory and double-click on mongo.exe.

##### Run Backend Service
- cd rldp-dice-app/rldp-diceapp-service
- java -jar -Dserver.port=8080 target/rldp-diceapp-service-0.0.1-SNAPSHOT.jar
###### Note: On default, the UI is pointed to http://localhost:8080. To change this, simply run sessionStorage.setItem('apiDomain', [BASE_URL_OF_API]) in your browser console. Ex. sessionStorage.setItem('apiDomain', "http://ec2-3-136-50-192.us-east-2.compute.amazonaws.com:8080")

##### Accessing backend service
- http://ec2-3-136-50-192.us-east-2.compute.amazonaws.com:8080/rldp-diceapp-service/dice/roll?pieces=2&sides=8&rolls=2
- http://localhost:8080/rldp-diceapp-service/dice/roll?pieces=2&sides=8&rolls=2
- http://ec2-3-136-50-192.us-east-2.compute.amazonaws.com:8080/rldp-diceapp-service/dice/report
- http://localhost:8080/rldp-diceapp-service/dice/report

##### Run UI
- cd rldp-dice-app/rldp-diceapp-ui
- ng serve

##### Accessint web application
- Open a browser and access http://localhost:4200
###### Note: On default, the UI is pointed to http://localhost:8080. To change this, simply run sessionStorage.setItem('apiDomain', [BASE_URL_OF_API]) in your browser console. Ex. sessionStorage.setItem('apiDomain', "http://ec2-3-136-50-192.us-east-2.compute.amazonaws.com:8080")


## Built With

* [Angular Typescript](https://angular.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Framework - Springboot](https://spring.io/) - Used to create backend services
* [Mongodb](https://docs.mongodb.com/manual/introduction/) - Database used

## Contributing



## Live

- http://ec2-3-136-50-192.us-east-2.compute.amazonaws.com:8080/rldp-diceapp-service
- https://rodolfoldelapenajr.github.io/ (Has Pending TODO)

## TODOs

- Swagger for API
- Live Web application still unable to access Live API
- Setting up Live DB to access in local machine

## Decissions Made

- Used mongodb to quickly accomodate changes in models

## Authors

* **Rodolfo L. dela Pena Jr.** 
