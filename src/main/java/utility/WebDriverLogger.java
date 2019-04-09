package utility;

import constants.Colors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverLogger extends AbstractWebDriverEventListener {
    Colors colors = new Colors();

    private static final Logger LOGGER = LoggerFactory
            .getLogger(WebDriverLogger.class);

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.info(Colors.ANSI_PURPLE + "WebDriver navigated to " + Colors.ANSI_RESET + "'" + url + "'");
    }

//    @Override
//    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//        LOGGER.info(Colors.ANSI_PURPLE +"Locator - " + Colors.ANSI_RESET + by);
//    }
//
//    @Override
//    public void afterFindBy(By by, WebElement element, WebDriver driver) {
//        LOGGER.info(by + Colors.ANSI_PURPLE +" - found" + Colors.ANSI_RESET);
//    }

//    @Override
//    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//        LOGGER.info(Colors.ANSI_PURPLE + "WebDriver changed value for element - " + Colors.ANSI_RESET
//                + elementDescription(element));
//    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOGGER.info(Colors.ANSI_PURPLE + "Сlick an element - " + Colors.ANSI_RESET
                + elementDescription(element));
    }

//    @Override
//    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//        LOGGER.info(Colors.ANSI_PURPLE + "WebDriver will change value for element - " + Colors.ANSI_RESET
//                + elementDescription(element));
//    }

//    @Override
//    public void onException(Throwable throwable, WebDriver driver) {
//        LOGGER.info(Colors.ANSI_PURPLE + "An exception occurred - " + Colors.ANSI_RESET + throwable);
//    }

    private String elementDescription(WebElement element) {
        String description = Colors.ANSI_PURPLE + "tag:" + Colors.ANSI_RESET + element.getTagName();
        if (element.getAttribute(Colors.ANSI_PURPLE + "id" + Colors.ANSI_RESET) != null) {
            description += Colors.ANSI_PURPLE + " id: " + Colors.ANSI_RESET + element.getAttribute("id");
        } else if (element.getAttribute(Colors.ANSI_PURPLE + "name" + Colors.ANSI_RESET) != null) {
            description += Colors.ANSI_PURPLE + " name: " + Colors.ANSI_RESET + element.getAttribute("name");
        }

        description += " ('" + element.getText() + "')";

        return description;
    }

}
