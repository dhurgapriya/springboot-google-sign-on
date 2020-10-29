# springboot-google-sign-on

## Description
This is an project demonstrating how to configure and use the OAuth services provided by Google, i.e. how to enable 'Login with Google' functionality in a ecommerce application.

## In Scope
1. Sign-in with google: If the email is not already signed in, the user will be signing up with a question whether they are a seller or consumer.

2. The users will be redirected to sellers/consumer page based on the role assigned to them. The users can later edit their roles.

## Running the Application
1. Import the project to the IDE of your choosing as a Maven project.

2. To run this example, you will need to apply for an client id and client secret from Google and add it to the `application.properties` file under `src/main/resources`. 

Please refer the following links to create oauth credentials: 
https://chillyfacts.com/integrate-login-with-google-in-websites-with-java/,
https://dzone.com/articles/getting-started-with-google-sign-in-in-spring-boot

3. Modify the following database configrations in `application.properties` file - spring.datasource.url, spring.datasource.username, spring.datasource.password. The default one is running with spring boot h2 database, you can also use mysql database.

Reference links:
https://attacomsian.com/blog/spring-data-jpa-h2-database,
https://spring.io/guides/gs/accessing-data-mysql/

4. Run the application using `mvn spring-boot:run` or by running the `BestPickApplication` class directly from your IDE.If you want to run the application locally in the production mode, run `mvn spring-boot:run -Pproduction`.

5. Open http://localhost:8080/ in your browser.
