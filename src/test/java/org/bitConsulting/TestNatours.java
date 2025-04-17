package org.bitConsulting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNatours {

    /*public static void main(String[] args) {

        ///api/v1/tours/getAllTours
        getAllTours();
        getTourById();
    }*/

    @Test
    public static void getAllTours(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://natorusdevops.azurewebsites.net/api/v1/tours/getAllTours";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification reqSpec = RestAssured.given();
        String response =
                reqSpec.get()
                        .then().assertThat().statusCode(200)
                        .extract().response().asString();
        // Print the status and message body of the response received from the server
        System.out.println(" v1 Response=> " + response);

        JsonPath js= new JsonPath(response);
        System.out.println(js.getString("status"));
        Assert.assertEquals(js.getString("status"), "succes 16/4");
    }

    @Test
    public static void getTourById(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://natorusdevops.azurewebsites.net/api/v1/tours/1001";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification reqSpec = RestAssured.given();
        String response =
                reqSpec.get()
                        .then().assertThat().statusCode(200)
                        .extract().response().asString();
        // Print the status and message body of the response received from the server
        System.out.println("v1 Response=>" + response);

        JsonPath js= new JsonPath(response);
        System.out.println(js.getString("status"));
        Assert.assertEquals(js.getString("status"), "succes 16/4 azure");
    }
}
