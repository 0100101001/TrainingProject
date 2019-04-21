package utility;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static constants.Colors.ANSI_PURPLE;
import static constants.Colors.ANSI_RESET;
import static utility.WebDriverLogger.LOGGER;

public class ActionsOnElements {

    public static void scrollToElement(AtlasWebElement element, WebDriver webDriver) {
        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);
    }

    public static void moveToElement(AtlasWebElement element, WebDriver webDriver) {
        removeEvilBanner(webDriver);
        LOGGER.info(ANSI_PURPLE + "Hover over element: " + ANSI_RESET + element
                .toString().substring(element.toString().lastIndexOf("-> ") + 1));
        new Actions(webDriver).moveToElement(element).perform();
    }

    public static void removeEvilBanner(WebDriver webDriver) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        String element = "return $('.flocktory-widget-overlay').each(function() { "
                + "return $(this).css('z-index') == '2000000000'; }).get(0)";
        try {
            Object evilBanner = js.executeScript(element + ";");

            if (evilBanner != null) {
                // удалить div с баннером со страницы
                js.executeScript(element + ".remove();");
            }
        } catch (Exception ignored) { // нам не нужно это исключение
        }
    }
}
