package integration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://auto.ru/sankt-peterburg/cars/vaz/all/?query=Lada&from=searchline
public class SearchPage {

    @FindBy(xpath = "//div[@class='ListingItem ListingItem_ctbautoru128Exp'][1]/div[@class='ListingItem__main']/div[@class='ListingItem__description']/div[@class='ListingItem__summary']/h3")
    public WebElement firstSearchCar;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}