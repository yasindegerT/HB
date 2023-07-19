package com.optiim.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{


    @FindBy(xpath = "//span[@data-test-id='account']")
    public WebElement girisYapButton;

    @FindBy(id = "#login")
    public WebElement girisYapLink;

    @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement emailInputBox;

    @FindBy(id = "#btnLogin")
    public WebElement loginPageGirisYapButtonEmail;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@id='btnEmailSelect']")
    public WebElement loginPageGirisYapButtonPassword;



}
