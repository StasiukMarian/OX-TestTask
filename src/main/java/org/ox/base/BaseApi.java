package org.ox.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.ox.helpers.GetToken;

import static org.ox.helpers.Constants.BASE_URL;

public class BaseApi {
    protected RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addFilter(new AllureRestAssured())
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("x-api-key", GetToken.getApiKey())
            .build();

}
