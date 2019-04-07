package pages.plp;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.component.ProductFilter;
import ru.yandex.qatools.allure.annotations.Description;

import static org.hamcrest.Matchers.*;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;
import static ru.yandex.qatools.matchers.webdriver.TextMatcher.text;

public interface Plp extends WebPage {

    @Description("Заголовок страницы со списком товаров")
    @FindBy(".//div[contains(@class, 'c-plp-heading__title')]")
    AtlasWebElement plpHeadingTitle();

    @Description("Количество товаров в списке")
    @FindBy(".//span[@class='c-plp-heading__count']")
    AtlasWebElement numberOfItemsInTheList();


    /**
     * Проверить, что открыта нужная страница со списком товаров
     * @param titleName - заголовок списка товаров
     */
    default void checkThatTheProductListPageIsOpen(String titleName) {
        Assert.assertTrue(plpHeadingTitle().getText().contains(titleName));
//        System.out.println("Текст элемента - " +plpHeadingTitle().getText());
    }

}
