package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

  /**
   * Поле ввода Телефона/Email
   */
  @FindBy(id = "frm-email")
  WebElement inputLogin;

  public LoginPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    waitForPageLoad(webDriver);
    PageFactory.initElements(webDriver, this);
  }
}
