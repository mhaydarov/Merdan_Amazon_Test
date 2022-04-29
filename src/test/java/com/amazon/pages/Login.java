package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    @FindBy (xpath = "//input[@type=\"email\"]")
    public WebElement usernameInput;

    @FindBy (xpath = "//input[@id=\"continue\"]")
    public WebElement continueButton;

    @FindBy (xpath = "//input[@type=\"password\"]")
    public WebElement passwordInput;

    @FindBy (xpath = "//input[@id=\"signInSubmit\"]")
    public WebElement submitButton;



}
