package catApiTests.favouriteTests;

import org.ox.pojo.favourite.FavouriteRequest;
import org.ox.pojo.favourite.FavouriteResponse;
import org.ox.pojo.imageResponse.ImageResponse;
import org.ox.services.FavouriteService;
import org.ox.services.ImageService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ox.helpers.ResponseSpecs.responseSpecificationBadRequest400;
import static org.ox.helpers.ResponseSpecs.responseSpecificationOk200;

public class DuplicateFavouriteTest {
    private final ImageService imageService = new ImageService();
    private final FavouriteService favouriteService = new FavouriteService();
    private String imageId;
    private Integer favouriteId;

    @BeforeMethod
    public void getRandomImage() {

        ImageResponse[] imageResponses = imageService.getRandomImage()
                .then()
                .spec(responseSpecificationOk200())
                .extract()
                .as(ImageResponse[].class);

        imageId = imageResponses[0].getId();
    }

    @Test(description = "Verify user is not able to add same image to favourite twice")
    public void addToFavouriteTest() {
        FavouriteRequest favouriteRequest = new FavouriteRequest();
        favouriteRequest.setImage_id(imageId);
        favouriteRequest.setSub_id("MarianStasiuk");

        FavouriteResponse favouriteResponse = favouriteService.addToFavourite(favouriteRequest)
                .then()
                .spec(responseSpecificationOk200())
                .extract()
                .as(FavouriteResponse.class);

        favouriteService.addToFavourite(favouriteRequest)
                .then()
                .spec(responseSpecificationBadRequest400());

        Assert.assertEquals(favouriteResponse.getMessage(), "SUCCESS");

        favouriteId = favouriteResponse.getId();
    }

    @AfterMethod(description = "Verify user is able to clean favourites")
    public void removeFromFavourite() {
        favouriteService.removeFromFavouriteById(favouriteId)
                .then()
                .spec(responseSpecificationOk200());
    }
}
