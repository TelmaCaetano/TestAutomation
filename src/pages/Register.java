package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    WebDriver driver;

    By emailInputLocator = By.name("signup_email");
    By signUpNextBtnLocator = By.xpath("//button[contains(@class,'signUpNextButtonClass')]");
    By signUpPasswordLocator = By.name("signup_password");
    By phoneInputLocator = By.xpath("//input[@placeholder='Mobile Number']");
    By usernameInputLocator = By.name("firstlastname");
    By submitRegisterBtnLocator = By.xpath("//button[@class='submitButton']");

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public void SignUpAndRegister(String email, String username, String phoneNumber, String password) {
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(signUpNextBtnLocator).click();
        driver.findElement(usernameInputLocator).sendKeys(username);
        //Fill phone number
        driver.findElement(phoneInputLocator).sendKeys(phoneNumber);
        //Fill password
        driver.findElement(signUpPasswordLocator).sendKeys(password);
        //Click submit
        driver.findElement(submitRegisterBtnLocator).click();
    }
}
