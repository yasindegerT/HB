package com.optiim.stepDefinition;

import com.optiim.pages.Cartpage;
import com.optiim.pages.DashboardPage;
import com.optiim.pages.LoginPage;
import com.optiim.utilities.DriverFactory;
import com.optiim.utilities.LogHelper;
import com.optiim.utilities.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class hepsiBuradaStepImpl {

    WebDriver driver = DriverFactory.getDriver();
    Cartpage cartpage = new Cartpage();
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    private String productName = "";


    @Given("Kullanıcı {string} url'ine gider.")
    public void kullanıcı_url_ine_gider(String url) {
        String testURL = ReadProperties.getProperty("testURL");
        driver.get(testURL);
        LogHelper.log(hepsiBuradaStepImpl.class,url+" ine navigate olunur");
    }
    @Then("{string} sayfasına gidildiği doğrulanır.")
    public void sayfasına_gidildiği_doğrulanır(String url) {
        assertTrue(driver.getCurrentUrl().equals(url));
        LogHelper.log(hepsiBuradaStepImpl.class,url+" ine navigate olunduğu doğrulanır");
    }

    @Then("Çerezleri kabul et butonuna tıklanır.")
    public void çerezleri_kabul_et_butonuna_tıklanır() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Kabul et']"))));
        driver.findElement(By.xpath("//button[.='Kabul et']")).click();
        LogHelper.log(hepsiBuradaStepImpl.class,"cerezleri kabul et butonuna tıklanır");
    }
    @Given("Kullanıcı giriş yap butonuna tıklar.")
    public void kullanıcı_giriş_yap_butonuna_tıklar() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.girisYapButton));
        loginPage.girisYapButton.click();
        loginPage.girisYapLink.click();

    }
    @Then("Kullanıcı login sayfasının geldiğini doğrular.")
    public void kullanıcı_login_sayfasının_geldiğini_doğrular() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginPageGirisYapButtonEmail));
        assertTrue(loginPage.loginPageGirisYapButtonEmail.isDisplayed());
    }
    @Then("Kullanıcı e-posta adresi olarak {string} değerini girer")
    public void kullanıcı_e_posta_adresi_olarak_değerini_girer(String email) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailInputBox));
        loginPage.emailInputBox.sendKeys(email);
    }
    @Then("E-posta sayfası giriş yap butonuna tıklar.")
    public void giriş_yap_butonuna_tıklar() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginPageGirisYapButtonEmail));
        loginPage.loginPageGirisYapButtonEmail.click();
    }
    @Then("Kullanıcı password değeri olarak {string} değerini girer")
    public void kullanıcı_password_değeri_olarak_değerini_girer(String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInputBox));
        loginPage.passwordInputBox.sendKeys(password);
    }
    @Then("Password sayfası giriş yap butonuna tıklar.")
    public void giriş_yap_butonuna_tıklar2() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginPageGirisYapButtonPassword));
        loginPage.loginPageGirisYapButtonPassword.click();
    }
    @Then("Arama alanına {string} yazılır ve arama butonuna tıklanır.")
    public void arama_alanına_yazılır_ve_arama_butonuna_tıklanır(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.searchBar));
        dashboardPage.searchBar.sendKeys(searchText);
        dashboardPage.searchButton.click();
    }
    @Then("Sol menüden sırasıyla telefon takiben cep telefonu tıklanır.")
    public void sol_menüden_sırasıyla_telefon_takiben_cep_telefonu_tıklanır() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.telefonLink));
        dashboardPage.telefonLink.click();
        dashboardPage.cepTelefonuLink.click();
    }
    @Then("Gelen sayfada {string} için sonuç bulunduğu doğrulanır.")
    public void gelen_sayfada_için_sonuç_bulunduğu_doğrulanır(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.searchResultElement));
        assertTrue(dashboardPage.searchResultElement.getText().contains(searchText));
    }
    @Then("Üstten {int}. ürün tıklanır.")
    public void üstten_ürün_tıklanır(int nth) {
        wait.until(ExpectedConditions.visibilityOfAllElements(dashboardPage.productListContent));
        List<WebElement> productListContent = dashboardPage.productListContent;
        productListContent.get(--nth).click();
    }
    @Then("Ürün detayında beğen butonuna tıklanır.")
    public void ürün_detayında_beğen_butonuna_tıklanır() {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.productName));
        productName = dashboardPage.productName.getText();
        dashboardPage.begenButonu.click();
    }
    @Then("Hesabım alanında beğendiklerim tıklanır.")
    public void hesabım_alanında_beğendiklerim_tıklanır() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.girisYapButton));
        actions.moveToElement(loginPage.girisYapButton)
                .moveToElement(dashboardPage.begendiklerimLink)
                .click().perform();
    }
    @Then("Beğendiğim ürünün listemde olduğu doğrulanır.")
    public void beğendiğim_ürünün_listemde_olduğu_doğrulanır() {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.begenilenProductName));
        assertTrue(dashboardPage.begenilenProductName.equals(productName));
    }
    @Then("Kullanıcı beğendiği ürünü sepete ekler.")
    public void kullanıcı_beğendiği_ürünü_sepete_ekler() {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.begenilenProduct));
        actions.moveToElement(dashboardPage.begenilenProduct)
                .moveToElement(cartpage.sepeteEkleButton)
                .click().perform();
    }
    @And("Kullanıcı sepetim butonuna tıklar.")
    public void kullanıcı_sepetim_butonuna_tıklar() {
        wait.until(ExpectedConditions.elementToBeClickable(cartpage.sepetimButton));
        cartpage.sepetimButton.click();
    }
    @Then("Sepetim sayfasının açıldığı doğrulanır.")
    public void sepetim_sayfasının_açıldığı_doğrulanır() {
        wait.until(ExpectedConditions.visibilityOf(cartpage.sepetimSayfaTitle));
        assertTrue(cartpage.sepetimSayfaTitle.isDisplayed());
    }
    @And("Kullanıcı sepetteki ürün için kaldır butonuna tıklar.")
    public void kullanıcı_sepetteki_ürün_için_kaldır_butonuna_tıklar() {
        wait.until(ExpectedConditions.elementToBeClickable(cartpage.sepettenKaldirButton));
        cartpage.sepettenKaldirButton.click();
    }
    @Then("{string} popup yazısının görüldüğü doğrulanır.")
    public void ürün_sepetten_kaldırıldı_popup_yazısının_görüldüğü_doğrulanır(String message) {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.toastMessage));
        assertTrue(dashboardPage.toastMessage.getText().equals(message));

    }
    @Then("Sepetin şu an boş yazısının çıktığı doğrulanır.")
    public void sepetin_şu_an_boş_yazısının_çıktığı_doğrulanır() {
        wait.until(ExpectedConditions.visibilityOf(cartpage.sepetinSuAnBosTitle));
        assertTrue(cartpage.sepetinSuAnBosTitle.isDisplayed());
    }

}
