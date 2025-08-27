package catApiTests.imagesTests;

import io.restassured.response.Response;
import org.ox.services.ImageService;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ImageByIncorrectIdTest {
    private final ImageService imageService = new ImageService();

    @Test(description = "Verify that user is not able to extract specific cat by incorrect id")
    public void GetImageByIncorrectIdTest() {
        Response imageByIncorrectId = imageService.getImageById("catApiTests");

        Assert.assertEquals(imageByIncorrectId.getStatusCode(), 400, "Actual status code is: " + imageByIncorrectId.getStatusCode());
    }
}
