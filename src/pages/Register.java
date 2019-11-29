package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    WebDriver driver;
    WebDriverWait waitDriver;

    By emailInputLocator = By.name("signup_email");
    By signUpNextBtnLocator = By.xpath("//button[contains(@class,'signUpNextButtonClass')]");
    By signUpPasswordLocator = By.name("signup_password");
    By phoneNumberLocator = By.xpath("//input[@placeholder='Mobile Number']");
    By usernameInputLocator = By.name("firstlastname");
    By submitRegisterBtnLocator = By.xpath("//button[@class='submitButton']");

    public Register(WebDriver driver) {
        this.driver = driver;
        waitDriver = new WebDriverWait(driver, 15);
    }

    public void registerUser(String email, String username, String phoneNumber, String password) {
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(signUpNextBtnLocator).click();

        //Fill username
        WebElement usernameValue = driver.findElement(usernameInputLocator);
        RetryTextInput(usernameValue, username);
        //Fill phone number
        WebElement phoneNumberValue = driver.findElement(phoneNumberLocator);
        RetryTextInput(phoneNumberValue, phoneNumber);
        //Fill password
        WebElement passwordValue = driver.findElement(signUpPasswordLocator);
        RetryTextInput(passwordValue, password);
        //Click submit
        waitDriver.until(ExpectedConditions.elementToBeClickable(submitRegisterBtnLocator)).click();
    }

    //Sometimes input elements erase it content.
    private void RetryTextInput(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
        try {
            new WebDriverWait(driver, 1).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            System.out.printf("Text in input not accordingly '" + text + "', setting again...\n");
            element.clear();
            element.sendKeys(text);
        }
    }

}
