package loginTests;

import loginTests.steps.StepsLoginTest;
import org.testng.annotations.Test;

public class LoginTest extends StepsLoginTest {

  StepsLoginTest stepsLoginTest = new StepsLoginTest();

  //TODO дописать тест/написать второй тест на негативную проверку(параметризовать)
  @Test(description = "Авторизация")
  public void LoginTests() {
    /* Перейдем на страницу авторизации */
    stepsLoginTest.goToLoginPage();
  }
}
