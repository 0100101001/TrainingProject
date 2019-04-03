package pages.mainPage;

import base.TestBase;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class StepsOnTheMainPage extends TestBase {

    @Step("Перейти на страницу авторизации пользователя")
    public void goToLoginPage() {
        MainPage mainPage = atlas.create(webDriver, MainPage.class);

        /* Перейти по ссылке "Войти" на страницу авторизации*/
        mainPage.goToLoginPage();

        /* Проверить, что открыта страница авторизации*/
        Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"),
                "Переход на страницу авторизации не осуществлен");
    }

}
