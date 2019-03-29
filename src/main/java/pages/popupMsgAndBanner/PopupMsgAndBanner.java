package pages.popupMsgAndBanner;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.Waits;

public class PopupMsgAndBanner extends TestBase {

  /**
   * Всплывающее уведомление (баннер)
   */
  @FindBy(xpath = "//div[@class='Push']")
  public WebElement pushNotification;

  /**
   * Кнопка "Закрыть" (крестик) во всплывающем уведомлении
   */
  @FindBy(xpath = "//div[@class='close']")
  public WebElement closeNotification;


  public PopupMsgAndBanner(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  /**
   * Закрытие всплывающего уведомления (баннера)
   */
  public void CloseNotification() {
    Waits waits = new Waits();
    WebDriverWait wait = new WebDriverWait(webDriver, 15);
//    if (waitVisibilityOfPopupErrorLocated(10)) {
//      closeNotification.click();
//    }
    String pattern = "//div[@class='Push-controls']";
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pattern)));
    webDriver.findElement(By.xpath("//div[@class='close']")).click();
  }

  /**
   * Ожидание появления уведомления (баннера) на странице.
   * @param time - время ожидания сек.
   * @return - если элемент появился, то вернет true, иначе false.
   */
  public boolean waitVisibilityOfPopupErrorLocated(int time) {
    WebDriverWait wait = new WebDriverWait(webDriver, time);
    String pattern = "//div[@class='Push']";
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pattern)));
      return true;
    }catch (TimeoutException e) {
      return false;
    }
}



}
