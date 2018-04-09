# Caching & persist using Springboot, Spring Security, Ignite and Couchbase

##Step to start the application:

1. Open terminal, run the following command to start the couchbase DB:



    > docker-compose up -d

2. Run the following command to start 3 server nodes:


    > mvn spring-boot:run -D server.port=8085 -Dspring.profiles.active="server"
    > mvn spring-boot:run -D server.port=8086 -Dspring.profiles.active="server"
    > mvn spring-boot:run -D server.port=8087 -Dspring.profiles.active="server"
 

3. Run the following command to start client:


    > mvn spring-boot:run -D server.port=8082 -Dspring.profiles.active="client"
    

Some useful endpoints:
- /cache/getall                     -> to get all available cache across server nodes
- /cache/get?cacheName=abc&key=xyz  -> to get cache value from cacheName and the specific key


See the *Controller classes for the other endpoints.