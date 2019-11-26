package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait wait;

    By xLocator = By.xpath("");
    By yLocator = By.xpath("");
    By zLocator = By.xpath("");

    public Home(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void NavigateToPage(String url) {
        System.out.println("Navigating to URL: " + url);
        driver.get(url);
    }
}
