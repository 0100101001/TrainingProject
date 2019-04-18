package pages.myAccountPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import org.testng.Assert;
import pages.loginPage.LoginPage;

public interface MyAccountPage extends WebPage, LoginPage {

    @Name("Аватар пользователя")
    @FindBy("//div[@class= 'header-main-area']//span[@class='my-account-personal-photo-placeholder']")
    AtlasWebElement userAvatar();

    default void loginCheck() {
        Assert.assertTrue(userAvatar().isDisplayed(), "Аватар пользователя не отображается");
        Assert.assertFalse(getWrappedDriver().getCurrentUrl().contains("login"),
                "Открыта страница авторизации" + getWrappedDriver().getCurrentUrl());
    }
}
