package pages.myAccountPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Description;

public interface MyAccountPage extends WebPage {

    /**
     * Аватар пользователя
     */
    @Description("Аватар пользователя")
    @FindBy("//div[@class= 'header-main-area']//span[@class='my-account-personal-photo-placeholder']")
    AtlasWebElement userAvatar();

    /**
     * Проверка успешной авторизации
     */
    default void loginCheck() {
        Assert.assertTrue(userAvatar().isDisplayed(), "Аватар пользователя не отображается");
    }
}
