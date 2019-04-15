package pages.myAccountPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.testng.Assert;
import pages.loginPage.LoginPage;
import ru.yandex.qatools.allure.annotations.Description;

public interface MyAccountPage extends WebPage, LoginPage {

    @Description("Аватар пользователя")
    @FindBy("//div[@class= 'header-main-area']//span[@class='my-account-personal-photo-placeholder']")
    AtlasWebElement userAvatar();

    default void loginCheck() {
        Assert.assertTrue(userAvatar().isDisplayed(), "Аватар пользователя не отображается");
        Assert.assertFalse(getWrappedDriver().getCurrentUrl().contains("login"),
                "Открыта страница авторизации" + getWrappedDriver().getCurrentUrl());
    }
}
