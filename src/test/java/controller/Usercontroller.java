package controller;

import config.Usermodel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Usercontroller {

   public Properties prop;

    public Usercontroller(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";

    }

    @Test
    public Response login() {

        return given().contentType("application/json").body("{\n" +
                "    \"email\":\"admin@roadtocareer.net\",\n" +
                "    \"password\":\"1234\"\n" +
                "}").when().post("/user/login").then().assertThat().statusCode(200).extract().response();

    }

    public Response createuser(Usermodel us) {


        return given().contentType("application/json").body(us)
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/user/create");


    }

    public Response depositMoney(String fromAccount, String toAccount, int amount) {


        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("from_account", fromAccount);
        requestBody.put("to_account", toAccount);
        requestBody.put("amount", amount);
        return given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .body(requestBody)
                .when()
                .post("/transaction/deposit");
    }

    public Response withdraw(String fromAccount, String toAccount, int amount) {

        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("from_account", fromAccount);
        requestBody.put("to_account", toAccount);
        requestBody.put("amount", amount);
        return given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .body(requestBody)
                .when()
                .post("/transaction/withdraw");


    }

    public Response sendmoney(String fromAccount, String toAccount, int amount) {

        RestAssured.baseURI = "http://dmoney.roadtocareer.net";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("from_account", fromAccount);
        requestBody.put("to_account", toAccount);
        requestBody.put("amount", amount);
        return given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .body(requestBody)
                .when()
                .post("/transaction/sendmoney");


    }

    public Response payment(String fromAccount, String toAccount, int amount) {

        RestAssured.baseURI = "http://dmoney.roadtocareer.net";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("from_account", fromAccount);
        requestBody.put("to_account", toAccount);
        requestBody.put("amount", amount);
        return given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .body(requestBody)
                .when()
                .post("/transaction/payment");

    }


    public Response checkbalance(String accountnumber) {


        RestAssured.baseURI = "http://dmoney.roadtocareer.net";
        return given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when()
                .get("/transaction/balance/" + accountnumber);

    }


}
