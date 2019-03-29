package pages.loginPage;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.myAccountPage.MyAccountPage;
import utility.Waits;

public class LoginPage extends TestBase {

  /**
   * Поле ввода Телефона/Email
   */
  @FindBy(id = "frm-email")
  public WebElement inputLogin;

  /**
   * Поле ввода пароля
   */
  @FindBy(id = "frm-password")
  public WebElement inputPassword;

  /**
   * Кнопка "Продолжить" в форме авторизации
   */
  @FindBy(name = "loginEmailPhone")
  public WebElement buttonSubmit;

  /**
   * Сообщение о том, что логин или пароль неверны
   */
  @FindBy(xpath = "//form[@id='login-form']//div[contains(@class, 'login-notification-error')]")
  public WebElement messageNotificationError;

  public LoginPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  /**
   * Авторизация (заполнение логина, пароля и нажатие на кнопку завершения авторизации)
   * @param login - логин пользователя
   * @param password - пароль
   * @return - вернет true, усли авторизация прошла(отображается аватар пользователя, иначе вернет false
   */
  public boolean login(String login, String password) {
    Waits waits = new Waits();
    MyAccountPage myAccountPage = new MyAccountPage(webDriver);
    waits.waitVisibilityOrClickableElement(inputLogin, 10, webDriver);

    inputLogin.click();
    inputLogin.clear();
    inputLogin.sendKeys(login);

    inputPassword.click();
    inputPassword.clear();
    inputPassword.sendKeys(password);

    buttonSubmit.click();
    waits.waitForPageLoad(webDriver);

    return waits.waitVisibilityOrClickableElement(myAccountPage.userAvatar, 5, webDriver);
  }

  /**
   * Проверка отображения сообщения о том, что логин или пароль неверны
   * @return - результат
   */
  public boolean checkNotificationError() {
    Waits waits = new Waits();
    waits.waitForPageLoad(webDriver);
    return waits.waitVisibilityOrClickableElement(messageNotificationError, 3, webDriver);
  }
}
