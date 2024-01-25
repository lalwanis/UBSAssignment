# Getting Started
 
> This RESTful API application helps validate Credit Card using Luhn's Algorithm

### How to use this application
* Download the application from https://github.com/lalwanis/UBSAssignment/tree/master
* From Local IntelliJ or Eclipse Editor (assuming it is setup correctly with Java 17), Run Mvn clean,build and create executable Jar CreditCardValidation-1.0.0.jar (under the target directory)
* In case you are unable to do that you can download this jar from https://github.com/lalwanis/UBSAssignment/tree/master/target
* I have also included `ValidationControllerWithoutSpringFramework` class in case you want to invoke validations directly through another application


### Steps to start the application
* From the command prompt go to the folder where CreditCardValidation-1.0.0.jar is downloaded or created
* run `java -jar CreditCardValidation-1.0.0.jar`
* Check if the application is up and running and no errors on the CommandPrompt

### Steps to Test the application and Validate the Card(s)
* Open Browser and go to Swagger link http://localhost:8080/swagger-ui/index.html#
* For Single Card Validation:
  * Goto http://localhost:8080/swagger-ui/index.html#/validation-controller/checkCardNumber_1
  * Enter the CardNumber and Press Execute Button
* For Multiple Card Validation:
  * Goto http://localhost:8080/swagger-ui/index.html#/validation-controller/checkCardNumber
  * Enter List of Card numbers in the following format ["5555555555554444","5555-5555-5555-4444","5555 5555 5555 4444"]

### About
* This application is a RESTFul Web based application
* There are two end points under this web application
  * To test single `/validation/card={card}`
  * To test multiple in one go `/validation/cards`
  * If you enter invalid format then you get following message: 
    * `"Error: Enter 16 digit Credit Card Number in xxxx xxxx xxxx xxxx or xxxx-xxxx-xxxx-xxxx  or xxxxxxxxxxxxxxxx format"`
  * If you enter valid card number or an invalid card number you get following message:
    * `"Credit Card is valid."`
    * `"Credit Card is not valid."`


### Reference Documentation
For further reference, please consider the following sections:

* [Luhn Alogirthm](https://en.wikipedia.org/wiki/Luhn_algorithm)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.8/maven-plugin/reference/html/)




