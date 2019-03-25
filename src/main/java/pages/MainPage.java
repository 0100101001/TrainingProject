package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {

  /**
   * Ссылка на страницу авторизации
   */
  @FindBy(xpath = ".//div[@class='header-main-area']//a[@href='/login']")
  WebElement linkToLoginPage;

  /**
   * Строка поиска (поле ввода)
   */
  @FindBy(id = "frm-search-text")
  WebElement inputSearch;

  public MainPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    waitForPageLoad(webDriver);
    PageFactory.initElements(webDriver,this);
  }

  /**
   * Переход с главной странице по ссылке "Войти" на страницу авторизации
   */
  public void goToLoginPage() {
    LoginPage loginPage = new LoginPage(webDriver);
    waitVisibilityOrClickableElement(linkToLoginPage, 15);
    linkToLoginPage.click();
    waitVisibilityOrClickableElement(loginPage.inputLogin, 20);
  }
}
