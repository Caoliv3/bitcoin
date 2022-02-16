package br.com.alura.controller;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BitcoinControllerTest {

    @Test
    public void testarStatusCodeRequisiçao200(){
        RestAssured
                .given().get("/bitcoins").then().statusCode(200);
    }
}
