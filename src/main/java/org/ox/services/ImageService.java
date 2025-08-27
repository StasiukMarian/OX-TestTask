package org.ox.services;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.ox.base.BaseApi;

public class ImageService extends BaseApi {
    public Response getRandomImage() {
        Allure.step("Get random cat image");
        return RestAssured.given()
                .spec(requestSpecification)
                .get("images/search");

    }

    public Response getImageById(String id) {
        Allure.step("Get cat image by id: " + id);
        return RestAssured.given()
                .spec(requestSpecification)
                .get("images/" + id);
    }
}
