package base;

import allure.MyTestListener;
import enums.DriverPaths;
import enums.SiteAddress;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utility.Utility;

import java.io.IOException;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

@Listeners(MyTestListener.class)
public class TestBase {
  //TODO реализовать прикрепление скриншота в аллюре

  protected static WebDriver webDriver;
  protected static String url;


  @BeforeClass
  public static void setUp(ITestContext context) throws IOException {
    url = SiteAddress.addressMainPage.value;

    /* Проверим код ответа сервера */
    Utility utility = new Utility();
    utility.getStatusCodeOfServer(url);

//    setProperty("browser", "Firefox");
    setProperty("browser", "Chrome");

    /* Инициализация браузера */
      if (getProperty("browser").contains("irefox")) {
        setProperty("webdriver.gecko.driver", DriverPaths.firefox.value);

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);

      } else if (getProperty("browser").contains("hrome") || getProperty("browser").contains("oogle")) {
        setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get(url);

      }

//      context.setAttribute("Base", webDriver);
    }

  public static WebDriver getWebDriver() {
     return webDriver;
  }

  @AfterClass
  public static void tearDown() {
    webDriver.quit();
  }


  //----------------------------------------------------------------------------

  public byte[] tekeScreenshot() {
    return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
  }

  /**
   * Ожидание появления элемента на странице и ожидание видимости.
   * @param element - элемент.
   * @param time - время ожидания сек.
   * @return - если элемент появился и видимый, то вернет true, иначе false.
   */
  public boolean waitVisibilityOrClickableElement(WebElement element, int time) {
    WebDriverWait wait = new WebDriverWait(webDriver, time);

    try {
      wait.until(ExpectedConditions.visibilityOf(element));
      wait.until(ExpectedConditions.elementToBeClickable(element));
      new Actions(webDriver).moveToElement(element).perform();
//      ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
      return true;
    }catch (TimeoutException e) {
      return false;
    }
  }

  /**
   * Ожидание загрузки страницы
   * @param driver - экземпляр драйвера
   */
  public void waitForPageLoad(WebDriver driver) {
    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
      }
    };
  }

}
