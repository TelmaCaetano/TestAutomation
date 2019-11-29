package TestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Home;
import pages.Register;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class TestAutomation {

    public static WebDriver driver;

    public static void main(String[] args) {
        driver = getChrome(false);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String url = "https://staging.engineer.ai/welcome";
        Home home = new Home(driver);
        home.navigateToHomePage(url);
        home.skipTour();
        home.chooseCurrency("US Dollars");
        home.goToRegisterPage();

        Register register = new Register(driver);

        String email = TestAutomation.chooseRandomValue(15) + "@test.com";
        String username = chooseRandomValue(6);
        String password = chooseRandomValue(9);

        register.registerUser(email, username, "+351968936457", password);
        home.registrationConfirmation(username);

        driver.close();
    }

    public static String chooseRandomValue(int count) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final SecureRandom RANDOM = new SecureRandom();

        StringBuilder sequence = new StringBuilder();

        for (int i = 0; i < count; ++i) {
            sequence.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sequence.toString();
    }

    private static WebDriver getChrome(boolean headless) {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless");
        }
        driver = new ChromeDriver(chromeOptions);

        return driver;
    }
}
