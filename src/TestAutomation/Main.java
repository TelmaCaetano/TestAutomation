package TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = GetChrome(false);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String url = "https://staging.engineer.ai/welcome";
        Home home = new Home(driver);
        home.NavigateToPage(url);
        home.TakeAndSkipTour();
        home.selectUSD();
        home.clickSignIn();
    }

    private static WebDriver GetChrome(boolean headless) {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless");
        }
        WebDriver driver = new ChromeDriver(chromeOptions);

        return driver;
    }
}
