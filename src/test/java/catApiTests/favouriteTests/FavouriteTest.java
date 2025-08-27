package catApiTests.favouriteTests;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.ox.pojo.favourite.FavouriteByIdResponse;
import org.ox.pojo.favourite.FavouriteRequest;
import org.ox.pojo.favourite.FavouriteResponse;
import org.ox.pojo.imageResponse.ImageResponse;
import org.ox.services.FavouriteService;
import org.ox.services.ImageService;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.ox.helpers.Constants.SUB_ID;
import static org.ox.helpers.ResponseSpecs.responseSpecificationOk200;

public class FavouriteTest {
    private final ImageService imageService = new ImageService();
    private final FavouriteService favouriteService = new FavouriteService();
    private String imageId;
    private Integer favouriteId;

    @BeforeTest
    public void getRandomImage() {
        ImageResponse[] imageResponses = imageService.getRandomImage()
                .then()
                .spec(responseSpecificationOk200())
                .extract()
                .as(ImageResponse[].class);

        imageId = imageResponses[0].getId();
    }

    @Test(priority = 1, description = "Verify user is able to add image to favourite")
    public void addToFavouriteTest() {
        FavouriteRequest favouriteRequest = new FavouriteRequest();
        favouriteRequest.setImage_id(imageId);
        favouriteRequest.setSub_id(SUB_ID);

        FavouriteResponse favouriteResponse = favouriteService.addToFavourite(favouriteRequest)
                .then()
                .spec(responseSpecificationOk200())
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/favourite.json"))
                .extract()
                .as(FavouriteResponse.class);

        Assert.assertEquals(favouriteResponse.getMessage(), "SUCCESS");

        favouriteId = favouriteResponse.getId();
    }

    @Test(priority = 2, description = "Verify user is able to get image from favourite by id")
    public void getFavouriteByIdTest() {
        FavouriteByIdResponse favouriteByIdResponse = favouriteService.getFavouriteById(favouriteId)
                .then()
                .spec(responseSpecificationOk200())
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/favouriteById.json"))
                .extract()
                .as(FavouriteByIdResponse.class);

        Assert.assertEquals(favouriteByIdResponse.getId(), favouriteId);
        Assert.assertEquals(favouriteByIdResponse.getSub_id(), SUB_ID);
    }

    @AfterTest(description = "Verify user is able to clean favourites")
    public void removeFromFavourite() {
        favouriteService.removeFromFavouriteById(favouriteId)
                .then()
                .spec(responseSpecificationOk200());
    }
}
