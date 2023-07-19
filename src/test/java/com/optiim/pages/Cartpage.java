package com.optiim.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cartpage extends BasePage{

    @FindBy(xpath = "//button[@data-test-id='product-info-button']")
    public WebElement sepeteEkleButton;

    @FindBy(xpath = "//span[.='Sepetim']/..")
    public WebElement sepetimButton;

    @FindBy(xpath = "//h1[.='Sepetim']")
    public WebElement sepetimSayfaTitle;

    @FindBy(xpath = "//a[@aria-label='Sepetten Çıkar']")
    public WebElement sepettenKaldirButton;

    @FindBy(xpath = "//h1[.='Sepetin şu an boş']")
    public WebElement sepetinSuAnBosTitle;
}
