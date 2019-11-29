##Web test automation

### Page object model

```java
public class TestAutomation {
    //Calls all test functions in the test project
      main(String[] args);
    //Generates a random string to use in test data
    chooseRandomValue(int count);
    //Gets a chrome browser by default (headless mode ca ne turned on or off)
    getChrome(boolean headless);
}
```

#### Pages:
- **Home**

```java
public class Home {
    //Navigates to Home Page:
    navigateToHomePage(String url);
    
    //Click on the button to take a tour and skip it
    skipTour();
    
    //Select the currency 
    chooseCurrency(String currency);
    
    //Proceeds to register page
    goToRegisterPage();
    
    //Validates register
    registrationConfirmation(String user);
}
```

- **Register**

```java
public class Register {
    //Create the new user on the register page
    registerUser();

    //Retry text
    RetryTextInput();
}
```


