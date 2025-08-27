package catApiTests.tokenTests;

import org.ox.services.TokenService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectTokenTest {
    TokenService tokenService = new TokenService();

    @Test(description = "Verify Incorrect token return 400 status code")
    public void incorrectTokenTest() {
        int statusCode = tokenService.incorrectToken()
                .statusCode();

        Assert.assertTrue(statusCode != 200, "Actual status code is: " + statusCode);
    }
}
