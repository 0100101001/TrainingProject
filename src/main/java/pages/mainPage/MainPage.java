package pages.mainPage;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.loginPage.LoginPage;
import pages.popupMsgAndBanner.PopupMsgAndBanner;
import utility.Waits;

public class MainPage extends TestBase {

  /**
   * Ссылка на страницу авторизации
   */
  @FindBy(xpath = ".//div[@class='header-main-area']//a[@href='/login']")
  public WebElement linkToLoginPage;

  /**
   * Строка поиска (поле ввода)
   */
  @FindBy(id = "frm-search-text")
  public WebElement inputSearch;

  public MainPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver,this);
  }

  /**
   * Переход с главной странице по ссылке "Войти" на страницу авторизации
   */
  public void goToLoginPage() {
    Waits waits = new Waits();
    LoginPage loginPage = new LoginPage(webDriver);
    waits.waitVisibilityOrClickableElement(linkToLoginPage, 15, webDriver);
    linkToLoginPage.click();
    waits.waitVisibilityOrClickableElement(loginPage.inputLogin, 20, webDriver);
  }
}
