package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait waitDriver;

    By buttonTakeTourLocator = By.xpath("//div[@class='welcomesection']/div/button");
    By buttonSkipTourLocator = By.xpath("//div[@class='contentholder active']/div[@class='letsskip']/button");
    By currencyDropdownLocator = By.className("sel_state");
    By loginPanelLocator = By.xpath("//*[@class='loginPanel']//button");
    By buttonRegisterLocator = By.xpath("//*[@class='loginDropdown']//*[contains(text(),'Register')]");
    By doneCurrencyLocator = By.className("doneButton");
    By userLoggedInLocator = By.xpath("//*[@class='userPanel']//strong");

    public Home(WebDriver driver) {
        this.driver = driver;
        waitDriver = new WebDriverWait(driver, 15);
    }

    public void navigateToHomePage(String url) {
        System.out.println("Navigating to URL: " + url);
        driver.get(url);
    }

    public void skipTour() {
        waitDriver.until(ExpectedConditions.elementToBeClickable(buttonTakeTourLocator)).click();
        driver.findElement(buttonSkipTourLocator).click();
    }

    public void chooseCurrency(String currency) {
        driver.findElement(currencyDropdownLocator).click();
        driver.findElement(By.xpath("//*[@class='currencyName'][text()='" + currency + "']")).click();
    }

    public void goToRegisterPage() {
        waitDriver.until(ExpectedConditions.elementToBeClickable(loginPanelLocator)).click();
        waitDriver.until(ExpectedConditions.elementToBeClickable(buttonRegisterLocator)).click();
    }

    public void registrationConfirmation(String user) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(doneCurrencyLocator)).click();
        WebElement userDropdown = driver.findElement(userLoggedInLocator);
        assert userDropdown.getText().equals(user) : "Registered user " + user + " is not the same as in home page: " + userDropdown.getText();
        assert driver.getCurrentUrl().equals("https://staging.engineer.ai/home") : "Url of home page does not match";
    }
}
