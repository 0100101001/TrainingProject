package base;

import enums.DriverPaths;
import enums.SiteAddress;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Utility;

import java.io.IOException;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

public class ApplicationManager {
  protected static WebDriver webDriver;
  protected static Atlas atlas;
  protected String url;

  protected void init() throws IOException {

    url = SiteAddress.addressMainPage.value;

    /* Проверим код ответа сервера */
    Utility utility = new Utility();
    utility.getStatusCodeOfServer(url);

    /* Инициализация браузера */
    try {
      if (getProperty("browser").contains("irefox")) {
        setProperty("webdriver.gecko.driver", DriverPaths.firefox.value);

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);
        atlas = new Atlas(new WebDriverConfiguration(webDriver));

      } else if (getProperty("browser").contains("hrome") || getProperty("browser").contains("oogle")) {
        setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);
        atlas = new Atlas(new WebDriverConfiguration(webDriver));
      }
    } catch (NullPointerException e) {
      setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);

      webDriver = new ChromeDriver();
      webDriver.manage().window().maximize();

      webDriver.get(url);
      atlas = new Atlas(new WebDriverConfiguration(webDriver));
    }
  }

  protected void stop() {
    webDriver.quit();
  }
}
