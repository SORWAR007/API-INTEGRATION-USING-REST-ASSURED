package testrunner;

import controller.Usercontroller;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;
import config.Setup;
import utils.Utilis;

public class Testrunner extends Setup {

    //    @Test(priority = 1,description = "admin login")
    public void dologin() throws ConfigurationException, InterruptedException {
        Usercontroller us = new Usercontroller(prop);
        Response res = us.login();
        System.out.println(res.asString());
        JsonPath jsonObj = res.jsonPath();
        String token = jsonObj.get("token");
        System.out.println(token);
        Utilis.setEnvVar("token", token);

    }


//    @Test(priority = 2, description = "create customer 1")
//    public void docreaTcustomer1() throws ConfigurationException, InterruptedException {
//        Usercontroller us = new Usercontroller(prop);
//        Usermodel ua = new Usermodel();
//        Faker faker = new Faker();
//        ua.setName(faker.name().firstName());
//        ua.setEmail(faker.internet().emailAddress());
//        ua.setNid("07841" + Utilis.generateraqndom(100000, 999999));
//        ua.setPassword(faker.internet().password());
//        ua.setRole("Customer");
//        ua.setPhone_number("01790" + Utilis.generateraqndom(100000, 999999));
//        Response RES = us.createuser(ua);
//        System.out.println(RES.asString());
//        JsonPath js = RES.jsonPath();
//        int userid = js.get("user.id");
//        Utilis.setEnvVar("userid", String.valueOf(userid));
//        String customer1number = js.get("user.phone_number");
//        Utilis.setEnvVar("customer1number", String.valueOf(customer1number));
//        JsonPath jsonPath = RES.jsonPath();
//        String message = jsonPath.get("message");
//        Assert.assertTrue(message.contains("User created"));
//        delay();
//
//
//    }
//
//    @Test(priority = 3, description = "create customer 2")
//    public void docreatecustomer2() throws ConfigurationException, InterruptedException {
//        Usercontroller us = new Usercontroller(prop);
//        Usermodel ua = new Usermodel();
//        Faker faker = new Faker();
//        ua.setName(faker.name().firstName());
//        ua.setEmail(faker.internet().emailAddress());
//        ua.setNid("07841" + Utilis.generateraqndom(100000, 999999));
//        ua.setPassword(faker.internet().password());
//        ua.setRole("Customer");
//        ua.setPhone_number("01790" + Utilis.generateraqndom(100000, 999999));
//        Response RES = us.createuser(ua);
//        System.out.println(RES.asString());
//        JsonPath js = RES.jsonPath();
//        int userid = js.get("user.id");
//        Utilis.setEnvVar("userid", String.valueOf(userid));
//        String customer2number = js.get("user.phone_number");
//        Utilis.setEnvVar("customer2number", String.valueOf(customer2number));
//        JsonPath jsonPath = RES.jsonPath();
//        String message = jsonPath.get("message");
//        Assert.assertTrue(message.contains("User created"));
//        delay();
//
//    }
//
//    @Test(priority = 4, description = "create agent")
//    public void docreateagent() throws ConfigurationException, InterruptedException {
//        Usercontroller us = new Usercontroller(prop);
//        Usermodel ua = new Usermodel();
//        Faker faker = new Faker();
//        ua.setName(faker.name().firstName());
//        ua.setEmail(faker.internet().emailAddress());
//        ua.setNid("07841" + Utilis.generateraqndom(100000, 999999));
//        ua.setPassword(faker.internet().password());
//        ua.setRole("Agent");
//        ua.setPhone_number("01790" + Utilis.generateraqndom(100000, 999999));
//        Response RES = us.createuser(ua);
//        System.out.println(RES.asString());
//        JsonPath js = RES.jsonPath();
//        int userid = js.get("user.id");
//        Utilis.setEnvVar("userid", String.valueOf(userid));
//        String agentnumber = js.get("user.phone_number");
//        Utilis.setEnvVar("agentnumber", String.valueOf(agentnumber));
//        JsonPath jsonPath = RES.jsonPath();
//        String message = jsonPath.get("message");
//        Assert.assertTrue(message.contains("User created"));
//        delay();
//
//    }
//
//    @Test(priority = 5, description = "create merchant")
//    public void docreatmerchent() throws ConfigurationException {
//        Usercontroller us = new Usercontroller(prop);
//        Usermodel ua = new Usermodel();
//        Faker faker = new Faker();
//        ua.setName(faker.name().firstName());
//        ua.setEmail(faker.internet().emailAddress());
//        ua.setNid("07841" + Utilis.generateraqndom(100000, 999999));
//        ua.setPassword(faker.internet().password());
//        ua.setRole("Merchant");
//        ua.setPhone_number("01790" + Utilis.generateraqndom(100000, 999999));
//        Response RES = us.createuser(ua);
//        System.out.println(RES.asString());
//        JsonPath js = RES.jsonPath();
//        int userid = js.get("user.id");
//        Utilis.setEnvVar("userid", String.valueOf(userid));
//        String merchentnumber = js.get("user.phone_number");
//        Utilis.setEnvVar("merchantnumber", String.valueOf(merchentnumber));
//        JsonPath jsonPath = RES.jsonPath();
//        String message = jsonPath.get("message");
//        Assert.assertTrue(message.contains("User created"));
//
//    }


    @Test(priority = 1, description = "deposit money system to customer1")
    public void depositsystemtoagent() throws InterruptedException {

        delay();
        Usercontroller us = new Usercontroller(prop);

        Response RES = us.depositMoney("SYSTEM", prop.getProperty("agentnumber"), 2000);
        System.out.println(RES.asString());
        JsonPath jsonPath = RES.jsonPath();
        String message = jsonPath.get("message");
        System.out.println(message);
        // Assert.assertTrue(message.contains("Deposit successful"));


    }

    @Test(priority = 2, description = "deposit money agent to customer1")
    public void agenttocustomer() throws InterruptedException {
        delay();
        Usercontroller us = new Usercontroller(prop);
        Response RES = us.depositMoney(prop.getProperty("agentnumber"), prop.getProperty("customer1number"), 1500);
        System.out.println(RES.asString());
        JsonPath jsonPath = RES.jsonPath();
        String message = jsonPath.get("message");
        //Assert.assertTrue(message.contains("Deposit successful"));

    }

    @Test(priority = 3, description = "deposit money customer1 to agent")
    public void customertopagent() throws InterruptedException {
        delay();
        Usercontroller us = new Usercontroller(prop);
        Response RES = us.withdraw(prop.getProperty("customer1number"), prop.getProperty("agentnumber"), 200);
        System.out.println(RES.asString());
        JsonPath jsonPath = RES.jsonPath();
        String message = jsonPath.get("message");
        // Assert.assertTrue(message.contains("Deposit successful"));


    }

    @Test(priority = 4, description = "deposit money customer1 to customer2")
    public void customertocustomer() throws InterruptedException {
        delay();
        Usercontroller us = new Usercontroller(prop);

        Response RES = us.sendmoney(prop.getProperty("customer1number"), prop.getProperty("customer2number"), 100);
        System.out.println(RES.asString());
        JsonPath jsonPath = RES.jsonPath();
        String message = jsonPath.get("message");
        // Assert.assertTrue(message.contains("Deposit successful"));


    }

    @Test(priority = 5, description = "payment customer1 to merchant")
    public void paymenttomerchant() throws InterruptedException {
        delay();
        Usercontroller us = new Usercontroller(prop);
        Response RES = us.payment(prop.getProperty("customer1number"), prop.getProperty("merchantnumber"), 100);
        System.out.println(RES.asString());
        JsonPath jsonPath = RES.jsonPath();
        String message = jsonPath.get("message");
        // Assert.assertTrue(message.contains("Deposit successful"));


    }

    @Test(priority = 6, description = "checking the balance of customer1")
    public void checkingbalance() throws InterruptedException {

        delay();
        Usercontroller us = new Usercontroller(prop);

        us.checkbalance(prop.getProperty("customer1number"));


    }


    public void delay() throws InterruptedException {
        Thread.sleep(3000);
    }


}

