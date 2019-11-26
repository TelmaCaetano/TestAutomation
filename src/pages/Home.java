package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait wait;

    By tourButtonLocator = By.xpath("//button[text()=\"TAKE A TOUR \"]");
    By skipTourButtonLocator = By.xpath(".//app-welcome//div[@class='letsskip']/button");
    By closeDisclaimerLocator = By.xpath(".//*[@class='icon-cancel']");
    By usdLocator = By.className("sel_state");
    By usdCurrencyLocator = By.xpath("//span[text()=\"US Dollars\"]");
    By signInLocator = By.xpath("//*[@class = 'loginPanel']//button");
    By registerLocator =By.xpath("//strong[contains(text(),'Register')]");



    public Home(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void NavigateToPage(String url) {
        System.out.println("Navigating to URL: " + url);
        driver.get(url);
    }

    public void TakeAndSkipTour() {
        clickTouButton();
        clickSkipTourButton();
        clickCloseDisclaimer();
    }


    private void clickTouButton() {
        WebElement tourButton = driver.findElement(tourButtonLocator);
        wait.until((ExpectedConditions.elementToBeClickable(tourButton)));
    }

    private void clickSkipTourButton() {
        WebElement tourButton = driver.findElement(skipTourButtonLocator);
        wait.until((ExpectedConditions.elementToBeClickable(tourButton)));
    }

    private void clickCloseDisclaimer() {
        WebElement tourButton = driver.findElement(closeDisclaimerLocator);
        wait.until((ExpectedConditions.elementToBeClickable(tourButton)));
    }
    public void selectUSD() {
        WebElement usd = driver.findElement(usdLocator);
        wait.until((ExpectedConditions.elementToBeClickable(usd))).click();
        driver.findElement(usdCurrencyLocator).click();
    }
    public void clickSignIn () {
        WebElement register = driver.findElement(closeDisclaimerLocator);
        wait.until((ExpectedConditions.elementToBeClickable(register))).click();
    }



}
