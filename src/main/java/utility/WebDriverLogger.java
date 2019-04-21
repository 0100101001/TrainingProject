package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static base.ApplicationManager.webDriver;
import static constants.Colors.*;
import static utility.ActionsOnElements.removeEvilBanner;

public class WebDriverLogger extends AbstractWebDriverEventListener {

    public static final Logger LOGGER = LoggerFactory
            .getLogger(WebDriverLogger.class);

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.info(ANSI_PURPLE + "Navigated to: " + ANSI_RESET + "'" + url + "'");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        removeEvilBanner(webDriver);

        LOGGER.info(ANSI_PURPLE + "Сlick an element: " + ANSI_RESET
                + element.toString().substring(element.toString().lastIndexOf("-> ") + 1));
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        LOGGER.info(ANSI_GREEN + "Сlick done !" + ANSI_RESET);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        removeEvilBanner(webDriver);

        LOGGER.info(ANSI_PURPLE + "Enter the text '" + Arrays.toString(keysToSend) + "' in the element: " + ANSI_RESET
                + element.toString().substring(element.toString().lastIndexOf("-> ") + 1));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        LOGGER.info(ANSI_GREEN + "The text entered!");
    }
}