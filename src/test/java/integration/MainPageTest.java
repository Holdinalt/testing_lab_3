package integration;


import integration.pages.Advertising;
import integration.pages.MainPage;
import integration.pages.SalePage;
import integration.pages.SearchPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

@ExtendWith(DriverExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageTest{

    private final String browser;
    private WebDriver driver;

    public MainPageTest(final String browserConst){
        browser = browserConst;
    }

    @BeforeAll
    void initDriver() throws MalformedURLException {

        AbstractDriverOptions options = new ChromeOptions();

        if ("Chrome".equalsIgnoreCase(browser)) {
            options = new ChromeOptions();
        }
        else if ("Firefox".equalsIgnoreCase(browser)) {
            options = new FirefoxOptions();
        }

        final HashMap<String, Object> capabilityMap = new HashMap<>();
        capabilityMap.put("sessionTimeout", "0.5m");
        capabilityMap.put("enableVNC", true);
        capabilityMap.put("enableVideo", true);
        capabilityMap.put("videoName", "last test");

        options.setCapability("selenoid:options", capabilityMap);



        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        mainPage = new MainPage(driver);
    }

//    @Nested
//    class Login{
//
//        @BeforeAll
//        public void goLoginPage(){
//
//        }
//
//    }

    @Nested
    class Search{

        private  MainPage mainPage;

        @BeforeEach
        void goSearchPage(){
            driver.get("https://auto.ru/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            try{
                final Advertising advertising = new Advertising(driver);
                advertising.adCloseButton.click();
            }catch (Exception ignored){}

           mainPage = new MainPage(driver);
        }

        @Test
        void searchAble(){

            SearchPage searchPage;
            final String search = "LADA";

            mainPage.searchInput.sendKeys(search);

            try{
                final Advertising advertising = new Advertising(driver);
                advertising.adCloseButton.click();
            }catch (Exception ignored){}

            mainPage.searchInput.sendKeys(Keys.ARROW_DOWN);
            mainPage.searchInput.sendKeys(Keys.ENTER);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            searchPage = new SearchPage(driver);

            Assertions.assertTrue(searchPage.firstSearchCar.getText().contains(search));
        }

        @Test
        void filterAbleAudi(){
            mainPage.audiFilterButton.click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            try{
                final Advertising advertising = new Advertising(driver);
                advertising.adCloseButton.click();
            }catch (Exception ignored){}

            final SearchPage searchPage = new SearchPage(driver);

            Assertions.assertTrue(searchPage.firstSearchCar.getText().contains("Audi"));
        }
    }


    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class SalePost{

        private SalePage salePage;

        @BeforeAll
        public void goSalePage(){
            driver.get("https://auto.ru/cars/used/sale/vaz/2113/1118531540-a228d302/");

            salePage = new SalePage(driver);
        }

        @Test
        void title(){
            Assertions.assertEquals(salePage.title.getText(), salePage.testTitle);
        }

        @Test
        void sellerName(){
            Assertions.assertEquals(salePage.sellerName.getText(), salePage.testSellerName);
        }

        @Test
        void price(){
            Assertions.assertEquals(salePage.price.getText(), salePage.testPrice);
        }

        @Test
        void availability(){
            Assertions.assertEquals(salePage.availability.getText(), salePage.testAvailability);
        }

        @Test
        void yearOfManufacture(){
            Assertions.assertEquals(salePage.yearOfManufacture.getText(), salePage.testYearOfManufacture);
        }

        @Test
        void kmAge(){
            Assertions.assertEquals(salePage.kmAge.getText(), salePage.testKmAge);
        }

        @Test
        void bodyType(){
            Assertions.assertEquals(salePage.bodyType.getText(), salePage.testBodyType);
        }

        @Test
        void color(){
            Assertions.assertEquals(salePage.color.getText(), salePage.testColor);
        }

        @Test
        void engine(){
            Assertions.assertEquals(salePage.engine.getText(), salePage.testEngine);
        }

        @Test
        void transportTax(){
            Assertions.assertEquals(salePage.transportTax.getText(), salePage.testTransportTax);
        }

        @Test
        void transmission(){
            Assertions.assertEquals(salePage.transmission.getText(), salePage.testTransmission);
        }

        @Test
        void wheel(){
            Assertions.assertEquals(salePage.wheel.getText(), salePage.testWheel);
        }

        @Test
        void state(){
            Assertions.assertEquals(salePage.state.getText(), salePage.testState);
        }

        @Test
        void ownersCount(){
            Assertions.assertEquals(salePage.ownersCount.getText(), salePage.testOwnersCount);
        }

        @Test
        void pts(){
            Assertions.assertEquals(salePage.pts.getText(), salePage.testPts);
        }

        @Test
        void customs(){
            Assertions.assertEquals(salePage.customs.getText(), salePage.testCustoms);
        }

        @Test
        void exchange(){
            Assertions.assertEquals(salePage.exchange.getText(), salePage.testExchange);
        }

        @Test
        void description(){
            Assertions.assertEquals(salePage.description.getText(), salePage.testDescription);
        }

        @Test
        void drive(){
            Assertions.assertEquals(salePage.drive.getText(), salePage.testDrive);
        }

        @Test
        void id(){
            Assertions.assertEquals(salePage.id.getText(), salePage.testID);
        }
    }

//    @Test
//    public void tt(){
////        System.out.println(browser + " inside");
////        System.out.println(browser.equalsIgnoreCase("chrome"));
//        Assertions.assertTrue(browser.equalsIgnoreCase("chrome"));
////        Assertions.assertTrue(true);
//    }


}
