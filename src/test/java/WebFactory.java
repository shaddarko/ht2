import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;


public class WebFactory {


    @BeforeMethod
    public WebStorage beforeTest(String browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeDriver chromeDriver = new ChromeDriver();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Wrong webdriver type");

        }
    }

        @Test
                public void openPage () {
            String browser = System.getProperty("browser").toLowerCase();
            WebDriver wd = (WebDriver) beforeTest(browser);
            wd.get("https://google.com");


        }


}

  /*  public static void main(String[] args) {

        WebDriver wd = create(WebDriverType.CHROME);

        wd.get("https://google.com");
    }

    public static WebDriver create (WebDriverType driverType) {

        switch (driverType) {

            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeDriver chromeDriver = new ChromeDriver();
                return new ChromeDriver();



            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                return new FirefoxDriver();


            default: throw new IllegalArgumentException("Wrong webdriver type");


        }


    }

}*/
