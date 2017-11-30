import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseClearTrip {

    @FindBy(linkText = "Your trips")
    private WebElement yourTrips;

    @FindBy(id = "SignIn")
    private WebElement signIn;

    @FindBy(id = "signInButton")
    private WebElement signInButton;

    @FindBy(id = "errors1")
    private WebElement errorMessage;




 @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
     SignInTest page = PageFactory.initElements(driver,SignInTest.class);
        page.yourTrips.click();
        page.signIn.click();
        driver.switchTo().frame("modal_window");
        page.signInButton.click();
        Assert.assertTrue(page.errorMessage.getText().contains("There were errors in your submission"));


    }
}
