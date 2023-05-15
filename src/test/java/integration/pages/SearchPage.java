package integration.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// page_url = https://auto.ru/cars/used/sale/lamborghini/urus/1118748585-aac44f12/
public class SearchPage {

    public static final String URL = "https://auto.ru/sankt-peterburg/cars/used/";

    WebDriver driver;

    @FindBy(xpath = "//div[@class='ListingItem ListingItem_ctbautoru128Exp'][1]/div[@class='ListingItem__main']/div[@class='ListingItem__description']/div[@class='ListingItem__summary']/h3")
    public WebElement firstSearchCar;

    @FindBy(xpath = "//button[@class='Button Button_color_blue Button_size_m Button_type_button Button_width_full']")
    public WebElement buttonShowResult;

    @FindBy(xpath = "(//div[@class='Select Select_size_m Select_mode_radio-check Select_hasClear'][1]/button[@class='Button Button_size_m Button_type_button Button_width_default Select__button']/span[@class='Button__content'])[1]")
    public WebElement inputEngineCapacityFrom;

    //(//div[@class='MenuItem MenuItem_size_m'])[1] - первый в списке

    @FindBy(xpath = "(//div[@class='Select Select_size_m Select_mode_check Select_width_full Select_hasClear']/button[@class='Button Button_size_m Button_type_button Button_width_default Select__button']/span[@class='Button__content'])[3]")
    public WebElement inputEngine;

    @FindBy(xpath = "(//div[@class='Select Select_size_m Select_mode_check Select_width_full Select_hasClear']/button[@class='Button Button_size_m Button_type_button Button_width_default Select__button']/span[@class='Button__content'])[4]")
    public WebElement inputDriveUnit;

    @FindBy(xpath = "(//div[@class='Select Select_size_m Select_mode_check Select_width_full Select_hasClear']/button[@class='Button Button_size_m Button_type_button Button_width_default Select__button']/span[@class='Button__content'])[2]")
    public WebElement inputTransmission;

    @FindBy(xpath = "(//div[@class='Select Select_size_m Select_mode_check Select_width_full Select_hasClear']/button[@class='Button Button_size_m Button_type_button Button_width_default Select__button']/span[@class='Button__content'])[1]")
    public WebElement inputCarBody;

    @FindBy(xpath = "(//div[@class='Select Select_size_m Select_mode_radio-check Select_hasClear'][1]/button[@class='Button Button_size_m Button_type_button Button_width_default Select__button'])[2]")
    public WebElement inputYearFrom;

    @FindBy(xpath = "(//div[@class='TextInput__input TextInput__input_r8'])[1]/span/div/input")
    public WebElement inputMileageFrom;

    @FindBy(xpath = "(//div[@class='TextInput__input TextInput__input_r8'])[3]/span/div/input")
    public WebElement inputPriceFrom;

    private WebElement getFirstMenuItem(){
        return driver.findElement(By.xpath("(//div[@class='MenuItem MenuItem_size_m'])[1]"));
    }

    void waitUntilPageLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    void waitUntilCarStartLoad(){

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(200))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='ListingCars__loaderOverlay ListingCars__loaderOverlay_visible']"))
                );
    }

    void waitUntilCarListLoad(){

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='ListingCars__loaderOverlay']"))
        );
    }

    void goLastTab(){

        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

    }

    private String goToFirstPageAfterInputClick(){
        String Choice = getFirstMenuItem().getText();
        getFirstMenuItem().click();
        buttonShowResult.click();

        waitUntilCarStartLoad();
        waitUntilCarListLoad();

        firstSearchCar.click();

        goLastTab();

        waitUntilPageLoad();

        return Choice;
    }

    public void filterByCarType(){
        inputCarBody.click();

        Assertions.assertEquals(goToFirstPageAfterInputClick().toLowerCase(), new SalePage(driver).bodyType.getText().toLowerCase());
    }

    public void filterByTransmission(){
        inputTransmission.click();

//        Assertions.assertEquals(goToFirstPageAfterInputClick().toLowerCase(), (new SalePage(driver).transmission.getText().toLowerCase()));
        Assertions.assertTrue(List.of(new String[]{"автоматическая", "автомат", "робот", "вариатор"}).contains(goToFirstPageAfterInputClick().toLowerCase()));
    }

    public void filterByEngine(){
        inputEngine.click();

        String Choice = goToFirstPageAfterInputClick().toLowerCase();

        String[] dataSplit = new SalePage(driver).engine.getText().toLowerCase().split("/");

        Assertions.assertEquals(Choice, dataSplit[2].trim());
    }

    public void filterByDriveUnit(){
        inputDriveUnit.click();

        String Choice = goToFirstPageAfterInputClick();

        Assertions.assertTrue(Choice.equalsIgnoreCase(new SalePage(driver).drive.getText()));
    }

    public void filterByYearFrom(){
        inputYearFrom.click();
        Assertions.assertTrue(Integer.parseInt(goToFirstPageAfterInputClick()) <= Integer.parseInt(new SalePage(driver).yearOfManufacture.getText()));
    }

    public void filterByMileageFrom(){
        inputMileageFrom.sendKeys("200000");
        buttonShowResult.click();

        waitUntilCarStartLoad();
        waitUntilCarListLoad();

        firstSearchCar.click();

        goLastTab();

        waitUntilPageLoad();

        String[] kmAgeSplit = new SalePage(driver).kmAge.getText().split(" ");

        StringBuilder kmAge = new StringBuilder();

        for(int i = 0; i < kmAgeSplit.length - 1; i++){
            kmAge.append(kmAgeSplit[i]);
        }

        int kmAgeInt = Integer.parseInt(kmAge.toString());

        Assertions.assertTrue(200000 <= kmAgeInt);
    }

    public void filterByPriceFrom(){
        inputPriceFrom.sendKeys("2000000");
        buttonShowResult.click();

        waitUntilCarStartLoad();
        waitUntilCarListLoad();

        firstSearchCar.click();

        goLastTab();

        waitUntilPageLoad();

        String[] priceSplit = new SalePage(driver).price.getText().split(" ");

        StringBuilder price = new StringBuilder();

        for(int i = 0; i < priceSplit.length - 1; i++){
            price.append(priceSplit[i]);
        }

        int priceInt = Integer.parseInt(price.toString());

        Assertions.assertTrue(2000000 <= priceInt);
    }

    public SearchPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}