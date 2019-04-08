package utility;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ActionsOnElements {

    public void scrollToElement(AtlasWebElement element, WebDriver webDriver) {
        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);
    }
}
