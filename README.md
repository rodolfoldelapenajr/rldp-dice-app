# Dice Rolls Simulator

Dice rolling simulator project built using spring boot and angular typescript

## Getting Started

git clone https://github.com/rodolfoldelapenajr/rldp-dice-app.git

### Prerequisites

- Java 8 or above
- Maven 3.6.0 or above
- Node Package Manager 6.13.4
- Mongodb 4.0.10


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
###### Note: The UI is currently pointed to localhost:8080. To change this, simply run sessionStorage.setItem('apiDomain', [THE BASE URL WHERE YOUR API IS DEPLOYED]) in your browser console.

##### Run UI
- cd rldp-dice-app/rldp-diceapp-ui
- ng serve

##### Opening the application
- Open a browser and access http://localhost:4200
###### Note: The UI is currently pointed to localhost:8080. To change this, simply run sessionStorage.setItem('apiDomain', [THE BASE URL WHERE YOUR API IS DEPLOYED]) in your browser console.


## Built With

* [Angular Typescript](https://angular.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Framework - Springboot](https://spring.io/) - Used to create backend services
* [Mongodb](https://docs.mongodb.com/manual/introduction/) - Database used

## Contributing



## Versioning



## Authors

* **Rodolfo L. dela Pena Jr.** 
