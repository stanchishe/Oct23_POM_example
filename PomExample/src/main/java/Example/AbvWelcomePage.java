package Example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbvWelcomePage {
    private static final String webUrl = "https://www.abv.bg/";
    private WebDriver webDriver;
    @FindBy(id = "username")
    WebElement userInput;
    @FindBy(id = "password")
    WebElement userPass;
    @FindBy(id = "loginBut")
    WebElement loginButton;
    public AbvWelcomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(webUrl);
        PageFactory.initElements(webDriver, this);
    }

    public void enterUserName(String userId) {
        userInput.sendKeys(userId);
    }

    public void enterUserPassword (String userPassword) {
        userPass.sendKeys(userPassword);
    }

    public void attemptLogin() {
        userPass.sendKeys(Keys.ENTER);
    }

    public String getError() {
        WebElement error;
        try {
            error = webDriver.findElement(By.className("abv-red"));
        } catch (Exception e) {
            return "No error found!";
        }
        return error.getText();
    }
}
