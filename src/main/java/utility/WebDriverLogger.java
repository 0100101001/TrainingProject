package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static base.ApplicationManager.webDriver;
import static constants.Colors.ANSI_PURPLE;
import static constants.Colors.ANSI_RESET;

public class WebDriverLogger extends AbstractWebDriverEventListener {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(WebDriverLogger.class);

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.info(ANSI_PURPLE + "Navigated to " + ANSI_RESET + "'" + url + "'");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        removeEvilBanner();

        LOGGER.info(ANSI_PURPLE + "Сlick an element - " + ANSI_RESET
                + elementDescription(element));
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        LOGGER.info(ANSI_PURPLE + "Сlick done !" + ANSI_RESET);
    }

    private String elementDescription(WebElement element) {
        String description = ANSI_PURPLE + "tag:" + ANSI_RESET + element.getTagName();
        if (element.getAttribute(ANSI_PURPLE + "id" + ANSI_RESET) != null) {
            description += ANSI_PURPLE + " id: " + ANSI_RESET + element.getAttribute("id");
        } else if (element.getAttribute(ANSI_PURPLE + "name" + ANSI_RESET) != null) {
            description += ANSI_PURPLE + " name: " + ANSI_RESET + element.getAttribute("name");
        }

        description += " ('" + element.getText() + "')";

        return description;
    }

    private void removeEvilBanner() {
        JavascriptExecutor js = webDriver;
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