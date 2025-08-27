package org.ox.services;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.ox.base.BaseApi;
import org.ox.pojo.favourite.FavouriteRequest;

public class FavouriteService extends BaseApi {

    public Response addToFavourite(FavouriteRequest favouriteRequest) {
        Allure.step("Add to favourite: " + favouriteRequest);
        return RestAssured.given()
                .spec(requestSpecification)
                .body(favouriteRequest)
                .post("favourites");
    }

    public Response getFavouriteById(int id) {
        Allure.step("Get favourite item with id: " + id);
        return RestAssured.given()
                .spec(requestSpecification)
                .get("favourites/" + id);
    }

    public Response removeFromFavouriteById(int id){
        Allure.step("Remove from favourite image with id : " + id);
        return RestAssured.given()
                .spec(requestSpecification)
                .delete("favourites/" + id);
    }
}
