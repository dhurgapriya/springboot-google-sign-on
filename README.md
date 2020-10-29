# Spring boot demo application with Google sign-on integration

## Description
This is an project demonstrating how to configure and use the OAuth services provided by Google in spring boot application.

## In Scope
1. Sign-in with google: If the email is not already signed in, the user will be signing up with a question whether they are a seller or consumer.

2. The users will be redirected to sellers/consumer page based on the role assigned to them. The users can later edit their roles.

## Running the Application
1. Import the project to the IDE of your choosing as a Maven project.

2. To run this example, you will need to apply for an client id and client secret from Google and add it to the `application.properties` file under `src/main/resources`. 

Please refer the following links to create oauth credentials: \
https://chillyfacts.com/integrate-login-with-google-in-websites-with-java/ \
https://dzone.com/articles/getting-started-with-google-sign-in-in-spring-boot

3. Modify the following database configrations in `application.properties` file - spring.datasource.url, spring.datasource.username, spring.datasource.password. The default one is running with spring boot h2 database, you can also use mysql database.

Reference links: \
https://attacomsian.com/blog/spring-data-jpa-h2-database \
https://spring.io/guides/gs/accessing-data-mysql/

4. Execute the below command to compile:
```
mvn clean install
```
5. Run the application using  below command: 
```
mvn spring-boot:run
```
6. Access the demo page using the below URL:
```
http://localhost:8080/
```

