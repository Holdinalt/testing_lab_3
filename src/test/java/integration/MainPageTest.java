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

    private String browser = null;
    private WebDriver driver;

    public MainPageTest(String browserConst){
        browser = browserConst;
    }

    @BeforeAll
    public void initDriver() throws MalformedURLException {
        AbstractDriverOptions options = new ChromeOptions();

//        System.out.println(browser + " beforall");

        if (browser.equalsIgnoreCase("Chrome")) {
            options = new ChromeOptions();
        }
        else if (browser.equalsIgnoreCase("Firefox")) {
            options = new FirefoxOptions();
        }

        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to set session timeout */
            put("sessionTimeout", "0.5m");
            put("enableVNC", true);
            put("enableVideo", true);
            put("videoName", "last test");
        }});

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
        public void goSearchPage(){
            driver.get("https://auto.ru/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            try{
                Advertising advertising = new Advertising(driver);
                advertising.adCloseButton.click();
            }catch (Exception ignored){}

           mainPage = new MainPage(driver);
        }

        @Test
        public void searchAble(){

            SearchPage searchPage;
            final String search = "LADA";

            mainPage.searchInput.sendKeys(search);

            try{
                Advertising advertising = new Advertising(driver);
                advertising.adCloseButton.click();
            }catch (Exception ignored){}

            mainPage.searchInput.sendKeys(Keys.ARROW_DOWN);
            mainPage.searchInput.sendKeys(Keys.ENTER);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            searchPage = new SearchPage(driver);

            Assertions.assertTrue(searchPage.firstSearchCar.getText().contains(search));
        }

        @Test
        public void filterAbleAudi(){
            mainPage.audiFilterButton.click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            try{
                Advertising advertising = new Advertising(driver);
                advertising.adCloseButton.click();
            }catch (Exception ignored){}

            SearchPage searchPage = new SearchPage(driver);

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
        public void title(){
            Assertions.assertEquals(salePage.title.getText(), salePage.testTitle);
        }

        @Test
        public void sellerName(){
            Assertions.assertEquals(salePage.sellerName.getText(), salePage.testSellerName);
        }

        @Test
        public void price(){
            Assertions.assertEquals(salePage.price.getText(), salePage.testPrice);
        }

        @Test
        public void availability(){
            Assertions.assertEquals(salePage.availability.getText(), salePage.testAvailability);
        }

        @Test
        public void yearOfManufacture(){
            Assertions.assertEquals(salePage.yearOfManufacture.getText(), salePage.testYearOfManufacture);
        }

        @Test
        public void kmAge(){
            Assertions.assertEquals(salePage.kmAge.getText(), salePage.testKmAge);
        }

        @Test
        public void bodyType(){
            Assertions.assertEquals(salePage.bodyType.getText(), salePage.testBodyType);
        }

        @Test
        public void color(){
            Assertions.assertEquals(salePage.color.getText(), salePage.testColor);
        }

        @Test
        public void engine(){
            Assertions.assertEquals(salePage.engine.getText(), salePage.testEngine);
        }

        @Test
        public void transportTax(){
            Assertions.assertEquals(salePage.transportTax.getText(), salePage.testTransportTax);
        }

        @Test
        public void transmission(){
            Assertions.assertEquals(salePage.transmission.getText(), salePage.testTransmission);
        }

        @Test
        public void wheel(){
            Assertions.assertEquals(salePage.wheel.getText(), salePage.testWheel);
        }

        @Test
        public void state(){
            Assertions.assertEquals(salePage.state.getText(), salePage.testState);
        }

        @Test
        public void ownersCount(){
            Assertions.assertEquals(salePage.ownersCount.getText(), salePage.testOwnersCount);
        }

        @Test
        public void pts(){
            Assertions.assertEquals(salePage.pts.getText(), salePage.testPts);
        }

        @Test
        public void customs(){
            Assertions.assertEquals(salePage.customs.getText(), salePage.testCustoms);
        }

        @Test
        public void exchange(){
            Assertions.assertEquals(salePage.exchange.getText(), salePage.testExchange);
        }

        @Test
        public void description(){
            Assertions.assertEquals(salePage.description.getText(), salePage.testDescription);
        }

        @Test
        public void drive(){
            Assertions.assertEquals(salePage.drive.getText(), salePage.testDrive);
        }

        @Test
        public void id(){
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
