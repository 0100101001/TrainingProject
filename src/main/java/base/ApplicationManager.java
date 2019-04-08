package base;

import enums.DriverPaths;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import static java.lang.System.setProperty;

public class ApplicationManager {
    public static WebDriver webDriver;
    public static Atlas atlas;
    private Configuration configuration = ConfigFactory.create(Configuration.class, System.getProperties());

    public void init() throws IOException {

        try {
            if (configuration.browser().contains("hrome")) {
                setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);
                webDriver = new ChromeDriver();
            } else if (configuration.browser().contains("irefox")) {
                setProperty("webdriver.gecko.driver", DriverPaths.firefox.value);
                webDriver = new FirefoxDriver();
            }
        } catch (NullPointerException e) { // если в свойствах проекта не указан браузер
            setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);
            webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();

        atlas = new Atlas(new WebDriverConfiguration(webDriver));

    }

    public void stop() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
