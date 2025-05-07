## API AUTOMATION USING REST ASSURED
Rest Assured is a Java library primarily used for testing and validating RESTful APIs. It simplifies the process of sending HTTP requests, receiving responses, and verifying the results, making API testing more manageable and efficient. Rest Assured supports various HTTP methods and provides a domain-specific language (DSL) for writing readable and powerful tests. 

## TECHNOLOGY WE USED
- SELENIUM
- GRADLE
- TESTNG
- DEPENDENCIES WE USED:
  
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.11.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.31.0")
    // https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    implementation("com.github.javafaker:javafaker:1.0.2")
    // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-csv
    implementation("org.apache.commons:commons-csv:1.14.0")
    // https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation("io.qameta.allure:allure-testng:2.29.1")

## TEST CASES WE USED FOR THIS PROJECT

1. Login by admin.
2. Create 2 new customers and a agent
3. Give 2000 tk from System account to the newly created agent
4. Deposit 1500 tk to a customer from the agent account
5. Withdraw 500 tk by the customer to the agent
6. Send money 500 tk to another customer
7. Payment 100 tk to any merchant by the recipient customer
8. Check balance of the recipient customer

## OUTPUT

![Screenshot (9)](https://github.com/user-attachments/assets/641b72e7-4f98-4c94-acb7-7d46bc604ee0)

