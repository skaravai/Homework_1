import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SampleTest {

    protected static WebDriver driver;
    private String baseURL = "https://otus.ru/";
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");

    }

    @Test
    public void openPage() {
        driver.get(baseURL);
        logger.info("Открыта страница отус в хроме");
    }


    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
