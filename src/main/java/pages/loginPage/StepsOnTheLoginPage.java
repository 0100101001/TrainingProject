package pages.loginPage;

import base.TestBase;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class StepsOnTheLoginPage extends TestBase {

    @Step("Авторизоваться пользователем {login}")
    public void login(String login, String password) {
        LoginPage loginPage = atlas.create(webDriver, LoginPage.class);

        /* Заполнить форму авторизации, нажать кнопку завершения авторизации */
        loginPage.login(login, password);

        /* Проверить, что авторизация успешна*/
        Assert.assertTrue(loginPage.loginCheck(), "Авторизация не произведена");
    }

    @Step("Авторизация пользователем {login} (некорректные данные)")
    public void loginIncorrectData(String login, String password) {
        LoginPage loginPage = atlas.create(webDriver, LoginPage.class);

        /* Заполнить форму авторизации, нажать кнопку завершения авторизации */
        loginPage.login(login, password);

        /* Проверить, что авторизация не удалась, пользователь остался на странице авторизации */
        Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"),
                "Пользователь не остался на странице авторизации");

        /* Проверить, что сообщение об ошибке отображается */
        Assert.assertTrue(loginPage.checkNotificationError(), "Сообщение об ошибке не отображается!");
    }
}
