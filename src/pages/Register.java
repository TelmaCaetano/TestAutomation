package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    WebDriver driver;

    By emailInputLocator = By.name("signup_email");
    By dignUpNextBtnLocator = By.xpath("//button[@class=\"submitButton extraSpace signUpNextButtonClass\"]");
}
