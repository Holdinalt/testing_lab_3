package integration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://auto.ru/cars/used/sale/vaz/2113/1118531540-a228d302/
public class SalePage {

    public String testAvailability = "В наличии";
    public String testYearOfManufacture = "2010";
    public String testKmAge = "150 000 км";
    public String testBodyType = "хэтчбек 3 дв.";
    public String testColor = "серый";
    public String testEngine = "1.6 л / 81 л.с. / Бензин";
    public String testTransportTax = "972 ₽ / год";
    public String testTransmission = "механическая";
    public String testDrive = "передний";
    public String testWheel = "Левый";
    public String testState = "Не требует ремонта";
    public String testOwnersCount = "3 или более";
    public String testPts = "Оригинал";
    public String testCustoms = "Растаможен";
    public String testExchange = "Рассмотрю варианты";
    public String testTitle = "LADA (ВАЗ) 2113, 2010";
    public String testID = "№ 1118531540";
    public String testPrice = "135 000 ₽";
    public String testSellerName = "Михаил";
    public String testDescription = "Без вложений по ходовой\nЧистая по документам\nНе гнилая вообще";


    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_availability']/span[@class='CardInfoRow__cell'][2]")
    public WebElement availability;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_year']/span[@class='CardInfoRow__cell'][2]")
    public WebElement yearOfManufacture;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_kmAge']/span[@class='CardInfoRow__cell'][2]")
    public WebElement kmAge;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_bodytype']/span[@class='CardInfoRow__cell'][2]")
    public WebElement bodyType;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_color']/span[@class='CardInfoRow__cell'][2]")
    public WebElement color;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_engine']/span[@class='CardInfoRow__cell'][2]/div")
    public WebElement engine;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_transportTax']/span[@class='CardInfoRow__cell'][2]")
    public WebElement transportTax;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_transmission']/span[@class='CardInfoRow__cell'][2]")
    public WebElement transmission;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_drive']/span[@class='CardInfoRow__cell'][2]")
    public WebElement drive;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_wheel']/span[@class='CardInfoRow__cell'][2]")
    public WebElement wheel;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_state']/span[@class='CardInfoRow__cell'][2]")
    public WebElement state;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_ownersCount']/span[@class='CardInfoRow__cell'][2]")
    public WebElement ownersCount;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_pts']/span[@class='CardInfoRow__cell'][2]")
    public WebElement pts;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_customs']/span[@class='CardInfoRow__cell'][2]")
    public WebElement customs;

    @FindBy(xpath = "//li[@class='CardInfoRow CardInfoRow_exchange']/span[@class='CardInfoRow__cell'][2]")
    public WebElement exchange;

    @FindBy(xpath = "//h1[@class='CardHead__title']")
    public WebElement title;

    @FindBy(xpath = "//div[@class='CardHead__infoItem CardHead__id']")
    public WebElement id;

    @FindBy(xpath = "//span[@class='OfferPriceCaption__price']")
    public WebElement price;

    @FindBy(xpath = "//div[@class='CardSellerNamePlace__name']")
    public WebElement sellerName;

    @FindBy(xpath = "//div[@class='CardDescriptionHTML']/span")
    public WebElement description;

    public SalePage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
