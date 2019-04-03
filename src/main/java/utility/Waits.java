package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {


    /**
     * Ожидание появления элемента на странице и ожидание видимости.
     *
     * @param element - элемент.
     * @param time    - время ожидания сек.
     * @return - если элемент появился и видимый, то вернет true, иначе false.
     */
    public boolean waitVisibilityOrClickableElement(WebElement element, int time, WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, time);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            new Actions(webDriver).moveToElement(element).perform();
//      ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Ожидание загрузки страницы
     *
     * @param webDriver - экземпляр драйвера
     */
    public void waitForPageLoad(WebDriver webDriver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("interactive");
            }
        };
    }
}
