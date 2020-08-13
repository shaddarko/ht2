import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebFactory {
    public static void main(String[] args) {
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

}
