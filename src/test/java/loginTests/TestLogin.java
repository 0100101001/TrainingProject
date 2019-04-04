package loginTests;

import base.TestBase;
import dataProvider.DataProvider;
import org.testng.annotations.Test;
import pages.loginPage.StepsOnTheLoginPage;
import pages.mainPage.StepsOnTheMainPage;
import pages.myAccountPage.StepsOnTheMyAccountPage;
import testData.users.LoginAndPassword;

import java.io.IOException;

public class TestLogin extends TestBase {
    protected StepsOnTheMainPage stepsOnTheMainPage = new StepsOnTheMainPage();
    protected StepsOnTheLoginPage stepsOnTheLoginPage = new StepsOnTheLoginPage();
    protected StepsOnTheMyAccountPage stepsOnTheMyAccountPage = new StepsOnTheMyAccountPage();

    @Test(description = "Авторизация", dataProvider = "login", dataProviderClass = DataProvider.class)
    public void loginTests(String login, String password) throws IOException {
        LoginAndPassword loginAndPassword = new LoginAndPassword();

        /* Перейдем на страницу авторизации */
        stepsOnTheMainPage.goToLoginPage();

        /* Авторизуемся пользователем*/
        if (login.equals(loginAndPassword.getInvalidLogin())) {
            /* Авторизуемся пользователем (некорректные данные)*/
            stepsOnTheLoginPage.loginIncorrectData(login, password);

            /* Проверить, что авторизация не удалась */
            stepsOnTheLoginPage.checkErrorlLogin();
        } else {
            /* Авторизуемся пользователем (корректные данные)*/
            stepsOnTheLoginPage.login(login, password);

            /* Проверить, что авторизация успешна */
            stepsOnTheMyAccountPage.checkSuccessfulLogin();
        }
    }
}
