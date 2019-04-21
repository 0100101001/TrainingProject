package pages.component;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import io.qameta.atlas.webdriver.extension.Param;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Fail;
import org.openqa.selenium.NoSuchElementException;

import static constants.Colors.ANSI_PURPLE;
import static constants.Colors.ANSI_RESET;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;
import static utility.ActionsOnElements.moveToElement;
import static utility.WebDriverLogger.LOGGER;

public interface Header extends WebPage {

    @Name("Ссылка на страницу авторизации 'Войти'")
    @FindBy(".//div[@class='header-main-area']//a[@href='/login']")
    AtlasWebElement linkToLoginPage();

    @Name("Навигационное меню")
    @FindBy(".//nav[@class='header-nav']")
    AtlasWebElement navMenu();

    @Name("Раздел навигационного меню - {{ sectionName }}")
    @FindBy(".//li[contains(@class, 'header-nav-item') and contains(string(), '{{ sectionName }}')]")
    AtlasWebElement navigationMenuSection(@Param("sectionName") String sectionName);

    @Name("Подраздел навигационного меню - {{ subsectionName }}")
    @FindBy(".//strong[@class = 'header-nav-drop-down-title' and contains(string(), '{{ subsectionName }}')]")
    AtlasWebElement subsection(@Param("subsectionName") String subsectionName);

    @Name("Пункт подраздела навигационного меню - {{ itemSubMenuName }}")
    @FindBy(".//li[@class = 'header-nav-drop-down-list-item' and contains(string(), '{{ itemSubsectionName }}')]")
    AtlasWebElement itemSubsection(@Param("itemSubsectionName") String itemSubsectionName);

    default void hoverOverNavMenuSection(String sectionName) {
        moveToElement(navigationMenuSection(sectionName), getWrappedDriver());
        Assertions.assertThat(navigationMenuSection(sectionName).getAttribute("class"))
                .as("Навигационное меню не раскрыто!").contains("active");
    }

    default void checkNavMenuIsDisplayed() {
        try {
            assertThat("Навигационное меню не отображается", navMenu(), displayed());
        } catch (NoSuchElementException e) {
            LOGGER.info(ANSI_PURPLE + "Element not found: " + ANSI_RESET + e);
            Assertions.assertThat((char[]) Fail.fail(""));
        }
    }
}
