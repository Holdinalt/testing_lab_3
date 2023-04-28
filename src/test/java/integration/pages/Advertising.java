package integration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Advertising{

    @FindBy(xpath = "//div[@class='Modal Modal_visible Modal_has-animation']/div[@class='Modal__container']/div[@class='Modal__closer']")
    public WebElement adCloseButton;

    public Advertising(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
