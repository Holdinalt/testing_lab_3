package integration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(xpath = "//div[@class='TextInput__input TextInput__input_r8 SearchLineSuggest__inputControl']/span[@class='TextInput__box']/div[@class='TextInput__inputWrap']/input[@class='TextInput__control']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='IndexMarks__col'][1]/a[@class='IndexMarks__item'][2]/div[@class='IndexMarks__item-name']")
    public WebElement audiFilterButton;

//    @FindBy(xpath = "")
//    public WebElement a;

    public MainPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
