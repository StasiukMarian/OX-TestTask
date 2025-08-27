package catApiTests.imagesTests;

import org.ox.pojo.imageResponse.ImageResponse;
import org.ox.services.ImageService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.ox.helpers.ResponseSpecs.responseSpecificationOk200;

public class RandomImageTest {
    private final ImageService imageService = new ImageService();

    @Test(description = "Verify that image URL contains image Id")
    public void GetRandomImageTest() {
        ImageResponse[] imageResponses = imageService.getRandomImage()
                .then()
                .spec(responseSpecificationOk200())
                .extract()
                .as(ImageResponse[].class);

        Assert.assertNotNull(imageResponses);
        Assert.assertTrue(Arrays.stream(imageResponses).allMatch(i -> i.getUrl().endsWith(i.getId() + ".jpg")), "Not all URLs ends with id.jpg");
    }
}
