# spring-boot-microservices

The complete architecture that i Have followed :

![Screenshot (4)](https://user-images.githubusercontent.com/67635598/222085188-2927a053-1eb4-416a-bb58-42985f076e4c.png)

How to build :

 1) To Clone this repository  run ```git clone https://github.com/Sharath-majjigi/shopping-cart.git```</br>
 
 2) I have used TestContainers Image to write Integration tests and MongoDb Image from Docker </br>
 
 3) You will need 4 Docker images so make sure you pull these images and have in your Docker registry </br>
 
     1. Keykloak (For Authorizing requests through Api-Gateway) </br>
       Go to keykloak.org and inside getting started page you can see docker and the command. </br>
       To pull docker image run, </br>
      ``` docker run -p 8080:8080 -e KEYCLOAK_ADMIN=username -e KEYCLOAK_ADMIN_PASSWORD=password quay.io/keycloak/keycloak:21.0.1 start-dev``` </br>
          * ports 8080:8080 first port refers to inside of our application and 2 ones refers to world </br>
          * KEYCLOAK_ADMIN=username -e KEYCLOAK_ADMIN_PASSWORD=password  set username and password </br>
          * start-dev run in dev-environment </br>

     2. Kafka-confluent (For Async Communication between services) </br>
         * Go to [Confuent-kafka](https://developer.confluent.io/quickstart/kafka-docker/) </br>
         
     3. zipkin and zookeeper (For tracing the the request Lifecycle)
         * Go to [Zipkin-platform](https://zipkin.io/pages/quickstart.html)
         * Run ```docker run -d -p 9411:9411 openzipkin/zipkin```
         
     4. Jre-version of the Java JDK youre using (optional : Incase you want to reduce the size while dockerizing your entire microservices in containers)
    
 4) Once you have image of Keycloak try logging in with port you have exposed while pulling the image and username and password that you have set. Create a new realm         and create a client finally add the JWT-Issuer uri in Api-gateway properties file.
 
 
 5) I have used webclient and not webmvc for calling the apis to services feel free to change for yourselves.
 
 
