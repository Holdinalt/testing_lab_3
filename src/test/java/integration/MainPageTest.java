package integration;


import integration.pages.MainPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.net.MalformedURLException;

@ExtendWith(DriverExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageTest{

    private String browser = null;
    private WebDriver driver;
    private MainPage mainPage;

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

//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.jetbrains.com/");

//        mainPage = new MainPage(driver);
    }

    @Nested
    class Login{

        @BeforeAll
        public void goLoginPage(){

        }

    }

    @Test
    public void tt(){
//        System.out.println(browser + " inside");
//        System.out.println(browser.equalsIgnoreCase("chrome"));
        Assertions.assertTrue(browser.equalsIgnoreCase("chrome"));
//        Assertions.assertTrue(true);
    }


}
