package integration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Advertising{

//    @FindBy(xpath = "//div[@class='Modal Modal_visible Modal_has-animation']/div[@class='Modal__container']/div[@class='Modal__closer']")
    public WebElement adCloseButton;

    public Advertising(final WebDriver driver) {

        adCloseButton = (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .pollingEvery(Duration.ofMillis(500))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='Modal Modal_visible Modal_has-animation']/div[@class='Modal__container']/div[@class='Modal__closer']"))
                );
        adCloseButton.click();

//        WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wd.pollingEvery(Duration.ofMillis(500));
//        wd.ignoring(NoSuchElementException.class);
//        wd.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Modal Modal_visible Modal_has-animation']/div[@class='Modal__container']/div[@class='Modal__closer']")));

//        adCloseButton = wd

//        PageFactory.initElements(driver, this);
    }
}
