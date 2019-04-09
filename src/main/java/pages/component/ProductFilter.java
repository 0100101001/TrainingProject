package pages.component;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.plp.Plp;
import ru.yandex.qatools.allure.annotations.Description;
import utility.ActionsOnElements;

import java.util.Arrays;

public interface ProductFilter extends AtlasWebElement, Plp {

    @Description("Фильтр {{ nameFaset }}")
    @FindBy(".//form[contains(@class, 'c-plp-facets')]" +
            "//span[@data-toggle='collapse' and contains(string(), '{{ nameFaset }}')]")
    AtlasWebElement faset(@Param("nameFaset") String nameFaset);

    @Description("Фильтр {{ nameFilter }} фасета {{ nameFaset }}")
    @FindBy(".//span[@data-toggle='collapse' and contains(string(), '{{ nameFaset }}')]" +
            "//ancestor::div[@data-facet='form']//child::li[contains(string(), '{{ nameFilter }}')]//label//span")
    AtlasWebElement filter(@Param("nameFaset") String nameFaset, @Param("nameFilter") String nameFilter);

    @Description("Статус фильтра {{ nameFilter }} в фасете {{ nameFaset }}")
    @FindBy(".//span[@data-toggle='collapse' and contains(string(), '{{ nameFaset }}')]" +
            "//ancestor::div[@data-facet='form']//child::li[contains(string(), '{{ nameFilter }}')]//input")
    AtlasWebElement statusFilter(@Param("nameFaset") String nameFaset, @Param("nameFilter") String nameFilter);

//    @Description("")
//    @FindBy(".//div[@data-sel='plp-facet_block-category']")
//    ElementsCollection<WebElement>filterCategory();

//    default void getElementFilter(String nameItemFilter) {
//        filterCategory().filter(WebElement::isDisplayed).filter(item -> item.getText()
//                .contains(nameItemFilter)).get(0).click();
//    }

    /**
     * Выбрать фильтр nameFilter в фасете nameFaset
     *
     * @param nameFaset  - название фасета
     * @param nameFilter - название фильтра
     */
    default void toSetTheFilterInFaset(String nameFaset, String nameFilter) throws InterruptedException {
        ActionsOnElements actions = new ActionsOnElements();
        actions.scrollToElement(faset(nameFaset), getWrappedDriver());

        if (faset(nameFaset).getAttribute("class").contains("collapsed")) {
            faset(nameFaset).click();
        }
//        getWrappedDriver().navigate().refresh();
        if (!gettingFilterStatus(nameFaset, nameFilter)) {
            filter(nameFaset, nameFilter).click();
            waitForTheFilter();
        }
    }

    /**
     * Снять выбор фильтра в фасете
     *
     * @param nameFaset  - название фасета
     * @param nameFilter - название фильтра
     */
    default void removeTheFilterInFaset(String nameFaset, String nameFilter) {
        ActionsOnElements actions = new ActionsOnElements();
        actions.scrollToElement(faset(nameFaset), getWrappedDriver());

        if (faset(nameFaset).getAttribute("class").contains("collapsed")) {
            faset(nameFaset).click();
        }
//        getWrappedDriver().navigate().refresh();
        if (gettingFilterStatus(nameFaset, nameFilter)) {
            filter(nameFaset, nameFilter).click();
            waitForTheFilter();
        }
    }

    /**
     * Дождаться применения фильтра
     */
    default void waitForTheFilter() {
        new WebDriverWait(getWrappedDriver(), 10)
                .until(ExpectedConditions.not(ExpectedConditions.urlToBe(getWrappedDriver().getCurrentUrl())));
    }

    /**
     * Проверка, совпадает ли количество товаров в фильтре и заголовке
     *
     * @param nameFaset  - название фасета
     * @param nameFilter - название фильтра
     */
    default void isTheNumberOfItemsInTheFilterAndTheHeaderTheSame(String nameFaset, String nameFilter) {
        String inFilter = plpHeadingTitle().getText().replaceAll(Arrays.toString(plpHeadingTitle()
                .getText().split("\\b[0-9]+\\b")), "");

        String inTitle = filter(nameFaset, nameFilter).getText();

        Assert.assertTrue(plpHeadingTitle().getText().contains(filter(nameFaset, nameFilter).getText()),
                "Количество товаров в фильтре и заголовке не совпадает: ");
    }

    /**
     * Проверка статуса фильтра (выбран или нет)
     *
     * @param nameFaset  - название фасета
     * @param nameFilter - название фильтра
     * @return - выбран?
     */
    default boolean gettingFilterStatus(String nameFaset, String nameFilter) {
        String status = statusFilter(nameFaset, nameFilter).getAttribute("data-client-prev-action");
        return status.contains("uncheck");
    }
}
