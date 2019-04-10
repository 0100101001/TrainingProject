package utility;

import constants.Colors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static base.ApplicationManager.webDriver;

public class WebDriverLogger extends AbstractWebDriverEventListener {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(WebDriverLogger.class);

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.info(Colors.ANSI_PURPLE + "Navigated to " + Colors.ANSI_RESET + "'" + url + "'");
    }

    //    @Override
//    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//        LOGGER.info(Colors.ANSI_PURPLE +"Locator - " + Colors.ANSI_RESET + by);
//    }
//
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
//        LOGGER.info(by + Colors.ANSI_PURPLE +" - found" + Colors.ANSI_RESET);
//        closeEvilBanner();
    }

//    @Override
//    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//        LOGGER.info(Colors.ANSI_PURPLE + "WebDriver changed value for element - " + Colors.ANSI_RESET
//                + elementDescription(element));
//    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        closeEvilBanner();

        LOGGER.info(Colors.ANSI_PURPLE + "Сlick an element - " + Colors.ANSI_RESET
                + elementDescription(element));
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        LOGGER.info(Colors.ANSI_PURPLE + "Сlick done !" + Colors.ANSI_RESET);
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

    private void closeEvilBanner() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        String element = "return $('.flocktory-widget-overlay').each(function() { "
                + "return $(this).css('z-index') == '2000000000'; }).get(0)";

        String scriptUnhide = "arguments[0].setAttribute('style','z-index:10 !important;');";

        try {

            Object evilBanner = js.executeScript(element + ";");

            if (evilBanner != null) {

                // удалить div с баннером со страницы
//                js.executeScript(element + ".remove();");

                // изменить порядок расположения по оси Z
                js.executeScript("return $('.flocktory-widget-overlay').each(function() { "
                        + "return $(this).css('z-index') == '2000000000'; })" +
                        ".get(0).setAttribute('style','z-index:-10 !important;')");
            }
        } catch (Exception ignored) { // нам не нужно это исключение
        }
    }
}