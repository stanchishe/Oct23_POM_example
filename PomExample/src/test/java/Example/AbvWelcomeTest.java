package Example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AbvWelcomeTest {
    private static WebDriver webDriver;

    @BeforeAll
    public static void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        webDriver = new ChromeDriver(options);
    }

    @AfterAll
    public static void close() {
         webDriver.close();
         webDriver.quit();
    }

    @Test
    @DisplayName("Test the ABV login with invalid userId and/or pass")
    public void shouldFailToLogin() {
        // setup stage
        String userId = "ABV_USER_ID";
        String userPass = "ABV_USER_PASS";

        // use stage
        AbvWelcomePage abvWelcomePage = new AbvWelcomePage(webDriver);
        abvWelcomePage.enterUserName(userId);
        abvWelcomePage.enterUserPassword(userPass);
        abvWelcomePage.attemptLogin();

        // assert
        String actualError = abvWelcomePage.getError();
        Assertions.assertFalse(actualError.equals("No error found!"));
    }

}
