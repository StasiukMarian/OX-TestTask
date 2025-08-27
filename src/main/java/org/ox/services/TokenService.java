package org.ox.services;

import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.ox.helpers.GetToken;
import org.ox.pojo.favourite.FavouriteRequest;

import static org.ox.helpers.Constants.BASE_URL;

public class TokenService {
    public Response incorrectToken() {
        Allure.step("Incorrect status code test");
        return RestAssured.given()
                .filter(new AllureRestAssured())
                .header("x-api-key", GetToken.getApiKey() + "a")
                .get(BASE_URL + "favourites");
    }
}
