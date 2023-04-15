package com.example.testing_lab_3;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Collection;
import java.util.List;




//@ExtendWith(CustomParameterResolver.class)
@RunWith(Parameterized.class)
public class MainPageTest {

//    String br;
//
//    public MainPageTest(String brow){
//        super();
//        this.br = brow;
////        System.out.println(br);
//    }
//
//    @Parameterized.Parameters
//    public static Collection input() {
//        return List.of("Chrome, FireFox);
//    }
//
//
//
//    @Test
//    public void st(){
//        System.out.println(br);
//    }

//    private MainPage mainPage;
//
//    public static Stream<Arguments> browser() {
//        return Stream.of(
//                arguments("Chrome"),
//                arguments("Firefox")
//        );
//    }

//    WebDriver driver;
//    @Test
//
//    public void testExamplePageOnMultipleBrowsers (String browserType) {
//        if (browserType.equalsIgnoreCase("Chrome")) {
////            WebDriverManager.chromedriver().setup();
////            driver = new ChromeDriver();
//            System.out.println("chrome");
//        }
//        else if (browserType.equalsIgnoreCase("Edge")) {
////            WebDriverManager.edgedriver().setup();
////            driver = new EdgeDriver();
//            System.out.println("edge");
//        }
//        else if (browserType.equalsIgnoreCase("Firefox")) {
////            WebDriverManager.firefoxdriver().setup();
////            driver = new FirefoxDriver();
//            System.out.println("ff");
//        }
////        driver.manage().window().maximize();
////        driver.get("https://example.testproject.io/web/index.html");
////        System.out.println(browserType + ": " + driver.getTitle());
//    }

//    public void browserSetup(String browser) throws MalformedURLException {
//        System.out.println("Setup " + browser);
//
//        if (browser.equalsIgnoreCase("chrome")){
//            ChromeOptions chromeOptions = new ChromeOptions();
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
//
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
//        }
//    }

//    @BeforeEach
//    public void beforeEach(String platformName, String platformVersion, String deviceName) {
//        System.out.println("Before each:");
//        System.out.println("platformName: " + platformName);
//        System.out.println("platformVersion: " + platformVersion);
//        System.out.println("deviceName: " + deviceName);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"IOS,13.0,iPhone X Simulator", "Android,1.0,Pixel 5", "Windows,11.0,Win"})
//    void testLogin(String platformName, String platformVersion, String deviceName) {
//        MutableCapabilities capabilities = new MutableCapabilities();
//        capabilities.setCapability("platformName", platformName);
//        capabilities.setCapability("platformVersion", platformVersion);
//        capabilities.setCapability("deviceName", deviceName);
//    }

//    String dr;
//
//    @BeforeEach
//    public void beforeEach(String browser) {
//        System.out.println("Before each:");
//        System.out.println("browser" + browser);
//        dr = browser;
//    }
//
//    @ParameterizedTest
//    @MethodSource("browser")
//    void testLogin(String browser) {
//        MutableCapabilities capabilities = new MutableCapabilities();
//        capabilities.setCapability("browser", browser);
//    }

//    @Test
//    void test(){
//        System.out.println(dr);
//    }

//    @BeforeEach
//    public void init() throws MalformedURLException {
//        browserSetup(browser);
//        System.out.println(browser);
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.jetbrains.com/");
//        mainPage = new MainPage(driver);
//    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
//
//    @Test
//    public void search() {
//        mainPage.searchButton.click();
//
//        WebElement searchField = driver.findElement(By.cssSelector("[data-test='search-input']"));
//        searchField.sendKeys("Selenium");
//
//        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
//        submitButton.click();
//
//        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test='search-input']"));
//        assertEquals("Selenium", searchPageField.getAttribute("value"));
//    }
//
//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.click();
//
//        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='main-submenu']"));
//        assertTrue(menuPopup.isDisplayed());
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeDeveloperToolsButton.click();
//        mainPage.findYourToolsButton.click();
//
//        WebElement productsList = driver.findElement(By.id("products-page"));
//        assertTrue(productsList.isDisplayed());
//        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
//    }

//    @BeforeEach
//    public void setUp() throws MalformedURLException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.jetbrains.com/");
//
//        mainPage = new MainPage(driver);
//    }

//    @BeforeEach
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.jetbrains.com/");
//
//        mainPage = new MainPage(driver);
//    }


}
