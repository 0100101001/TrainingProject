package loginTests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.StepsOnTheMainPage;

public class TestLogin extends TestBase {
  protected StepsOnTheMainPage stepsOnTheMainPage = new StepsOnTheMainPage();

  @Test(description = "Авторизация")
  public void LoginTests() throws InterruptedException {

    /* Перейдем на страницу авторизации */
    stepsOnTheMainPage.goToLoginPage();

  }
}
