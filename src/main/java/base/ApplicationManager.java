package base;

import enums.DriverPaths;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utility.WebDriverLogger;

import java.io.IOException;

import static java.lang.System.setProperty;

public class ApplicationManager {
    public static EventFiringWebDriver webDriver;
    public static Atlas atlas;
    private Configuration configuration = ConfigFactory.create(Configuration.class, System.getProperties(),
            System.getenv());

    public void init() throws IOException {

        try {
            if (configuration.browser().contains("hrome")) {
                setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);
                webDriver = new EventFiringWebDriver(new ChromeDriver());
                webDriver.register(new WebDriverLogger());
            } else if (configuration.browser().contains("irefox")) {
                setProperty("webdriver.gecko.driver", DriverPaths.firefox.value);
                webDriver = new EventFiringWebDriver(new FirefoxDriver());
                webDriver.register(new WebDriverLogger());
            }
        } catch (NullPointerException e) { // если в свойствах проекта не указан браузер
            setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);
            webDriver = new EventFiringWebDriver(new ChromeDriver());
            webDriver.register(new WebDriverLogger());
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
