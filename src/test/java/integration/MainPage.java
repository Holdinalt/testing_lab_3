package integration;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.jupiter.api.Assertions.*;
@ConfigurationParameter(key = "browser", value = "chrome")
@ExtendWith(DriverExtension.class)
public class MainPage{

    private final String browser;

    public MainPage(String browser){
        this.browser = browser;
    }

//    @BeforeTest
//    @Parameters( {"BrowserType"} )
//    public void testExamplePageOnMultipleBrowsers (String browserType) {
//        if (browserType.equalsIgnoreCase("Chrome")) {
////            WebDriverManager.chromedriver().setup();
////            driver = new ChromeDriver();
//            dr = "Chrome";
//        }
//        else if (browserType.equalsIgnoreCase("Edge")) {
////            WebDriverManager.edgedriver().setup();
////            driver = new EdgeDriver();
//            dr = "Edge";
//        }
//        else if (browserType.equalsIgnoreCase("Firefox")) {
////            WebDriverManager.firefoxdriver().setup();
////            driver = new FirefoxDriver();
//            dr = "FF";
//        }
////        driver.manage().window().maximize();
////        driver.get("https://example.testproject.io/web/index.html");
////        System.out.println(browserType + ": " + driver.getTitle());
//        System.out.println(dr + "hi");
//    }

    @Test
    public void tt(){
        System.out.println(browser);
//        Assertions.assertTrue(browser.equalsIgnoreCase("chrome"));
        Assertions.assertTrue(true);
    }


}
