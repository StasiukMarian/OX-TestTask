package catApiTests.imagesTests;

import org.ox.pojo.imageResponse.ImageResponse;
import org.ox.services.ImageService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.ox.helpers.ResponseSpecs.responseSpecificationOk200;

public class ImageByIdTest {
    private final ImageService imageService = new ImageService();

    @Test(description = "Verify that user is able to extract specific cat by id")
    public void GetImageByIdTest() {
        ImageResponse[] imageResponses = imageService.getRandomImage()
                .then()
                .spec(responseSpecificationOk200())
                .extract()
                .as(ImageResponse[].class);

        String id = imageResponses[0].getId();

        ImageResponse imageResponseById = imageService.getImageById(id)
                .then()
                .spec(responseSpecificationOk200())
                .extract()
                .as(ImageResponse.class);

        Assert.assertEquals(imageResponses[0].getId(), imageResponseById.getId(),
                "Id's are different." +
                        " First id: " + imageResponses[0].getId() +
                        " Second id: " + imageResponseById.getId()
        );
    }
}
