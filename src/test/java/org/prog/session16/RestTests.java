/*package org.prog.session16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.prog.session16.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

//TODO: add location to request
//TODO: validate street number and name in location are not empty

public class RestTests {

    @Test
    public void testApiCall() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat");

        Response response = requestSpecification.get();
        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        validatableResponse.body("results[0].gender",
                Matchers.equalTo("female"));
    }

    @Test
    public void testApiCall2() {
        RestAssured
                .given()
                .baseUri("https://randomuser.me/")
                .basePath("/api/")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results[0].gender", Matchers.equalTo("female"));
    }

    @Test
    public void testApiCall3() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat");

        Response response = requestSpecification.get();
        ResultsDto dto = response.as(ResultsDto.class);
        System.out.println(dto.getResults().size());
        Assert.assertEquals(dto.getResults().get(0).getGender(), "female");
    }
}*/package org.prog.session16;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.prog.session16.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTests {

    @Test
    public void testApiCall() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat,location");

        Response response = requestSpecification.get();
        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);

        validatableResponse.body("results[0].gender",
                Matchers.equalTo("female"));

        validatableResponse.body("results[0].location.street.number",
                Matchers.notNullValue());

        validatableResponse.body("results[0].location.street.name",
                Matchers.not(Matchers.isEmptyOrNullString()));
    }

    @Test
    public void testApiCall2() {
        RestAssured
                .given()
                .baseUri("https://randomuser.me/")
                .basePath("/api/")
                .queryParam("noinfo")
                .queryParam("inc", "gender,name,nat,location")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results[0].gender", Matchers.equalTo("female"))
                .body("results[0].location.street.number", Matchers.notNullValue())
                .body("results[0].location.street.name", Matchers.not(Matchers.isEmptyOrNullString()));
    }

    @Test
    public void testApiCall3() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat,location");

        Response response = requestSpecification.get();
        ResultsDto dto = response.as(ResultsDto.class);

        System.out.println(dto.getResults().size());

        Assert.assertEquals(dto.getResults().get(0).getGender(), "female");
        Assert.assertNotNull(dto.getResults().get(0).getLocation());
        Assert.assertNotNull(dto.getResults().get(0).getLocation().getStreet());
        Assert.assertNotNull(dto.getResults().get(0).getLocation().getStreet().getNumber());
        Assert.assertNotNull(dto.getResults().get(0).getLocation().getStreet().getName());
        Assert.assertFalse(dto.getResults().get(0).getLocation().getStreet().getName().isEmpty());
    }
}