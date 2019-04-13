package pages.component;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Description;

public interface Header extends WebPage {

    @Description("Ссылка на страницу авторизации 'Войти'")
    @FindBy(".//div[@class='header-main-area']//a[@href='/login']")
    AtlasWebElement linkToLoginPage();

    @Description("Навигационное меню")
    @FindBy(".//nav[@class='header-nav']")
    AtlasWebElement navMenu();

    /**
     * Раздел навигационного меню
     * @param sectionName - название раздела: {Акции, Телевизоры, Ноутбуки и компьютеры, смартфоны и гаджеты,
     *                    Фото и видео, Техника для дома, Красота и здоровье, Авто электроника, Игры и софт,
     *                    Аксессуары, Apple}
     */
    @Description("Раздел навигационного меню - {{ sectionName }}")
    @FindBy(".//li[contains(@class, 'header-nav-item') and contains(string(), '{{ sectionName }}')]")
    AtlasWebElement navigationMenuSection(@Param("sectionName") String sectionName);

    @Description("Подраздел навигационного меню - {{ subsectionName }}")
    @FindBy(".//strong[@class = 'header-nav-drop-down-title' and contains(string(), '{{ subsectionName }}')]")
    AtlasWebElement subsection(@Param("subsectionName") String subsectionName);

    @Description("Пункт подраздела навигационного меню - {{ itemSubMenuName }}")
    @FindBy(".//li[@class = 'header-nav-drop-down-list-item' and contains(string(), '{{ itemSubsectionName }}')]")
    AtlasWebElement itemSubsection(@Param("itemSubsectionName") String itemSubsectionName);

    default void hoverOverNavMenuSection(String sectionName) {
        new Actions(getWrappedDriver()).moveToElement(navigationMenuSection(sectionName)).perform();
        Assert.assertTrue(navigationMenuSection(sectionName).getAttribute("class").contains("active"));
    }

    default void hoverAndClickOverASubsectionItemInTheNavMenu(String itemSubsectionName) {
        new Actions(getWrappedDriver()).moveToElement(itemSubsection(itemSubsectionName)).click().perform();
    }

    default void checkNavMenuIsDisplayed() {
        Assert.assertTrue(navMenu().isDisplayed(), "Навигационное меню не отображается");
    }
}
