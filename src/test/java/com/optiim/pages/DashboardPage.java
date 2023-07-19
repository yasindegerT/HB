package com.optiim.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//div[@id='react-autowhatever-1']/../input")
    public WebElement searchBar;

    @FindBy(xpath = "//div[.='ARA']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@data-test-id='tree-node-title']/div[.='Telefon']")
    public WebElement telefonLink;

    @FindBy(xpath = "//div[@data-test-id='tree-node-title']/div[.='Cep Telefonu']")
    public WebElement cepTelefonuLink;

    @FindBy(xpath = "//h1[starts-with(@class,'searchResultSummaryBar')]")
    public WebElement searchResultElement;
    @FindBy(xpath = "//ul[starts-with(@class,'productListContent')]/li")
    public List<WebElement> productListContent;

    @FindBy(xpath = "//h1[@id='product-name']")
    public WebElement productName;

    @FindBy(xpath = "//div[starts-with(@class,'customerAccount-Like')]/div[1]")
    public WebElement begenButonu;

    @FindBy(xpath = "//div[@class='hb-toast-text']")
    public WebElement toastMessage;

    @FindBy(xpath = "//a[@title='Beğendiklerim']")
    public WebElement begendiklerimLink;

    @FindBy(xpath = "//div[@data-test-id='carousel-container']")
    public WebElement begenilenProduct;

    @FindBy(xpath = "//h3[@data-test-id='product-card-name']")
    public WebElement begenilenProductName;
}
