import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest extends  BaseClearTrip{


    @FindBy(id = "OneWay")
    private WebElement oneWayRadioButton;

    @FindBy(id = "FromTag")
    private WebElement orginationField;

    @FindBy(id = "ToTag")
    private WebElement destinationField;
    @FindBy(id = "SearchBtn")
    private WebElement searchButton;
    @FindBy(xpath = "//a[text()='20']")
    private WebElement dateSelection;
    @FindBy(className = "searchSummary")
    private WebElement summary;

    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        FlightBookingTest page = PageFactory.initElements(driver,FlightBookingTest.class);
        page.oneWayRadioButton.click();
        page.orginationField.clear();
        page.orginationField.sendKeys("Bangalore");
        //select the first item from the orgination auto complete list
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();
        page.destinationField.clear();
        page.destinationField.sendKeys("Delhi");


        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        page.dateSelection.click();

        //all fields filled in. Now click on search
        page.searchButton.click();


        //verify that result appears for the provided journey search
        Assert.assertTrue(page.summary.isDisplayed());



    }


}
