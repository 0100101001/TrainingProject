package pages.myAccountPage;

import base.TestBase;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class StepsOnTheMyAccountPage extends TestBase {

    @Step("Проверить, что авторизация успешна")
    public void checkSuccessfulLogin() {
        MyAccountPage myAccountPage = atlas.create(webDriver, MyAccountPage.class);

        /* Проверить, что авторизация успешна*/
        Assert.assertTrue(myAccountPage.loginCheck(), "Авторизация не произведена");
    }
}
