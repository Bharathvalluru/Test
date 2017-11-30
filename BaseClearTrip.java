import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BaseClearTrip {
    public static WebDriver driver;
    @BeforeMethod
    public void openBrowser()
    {
        setDriverPath();
        driver=new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
    public static void setDriverPath() {
        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (System.getProperty("os.name").contains("Windows")) {
            System.out.println();
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
}
