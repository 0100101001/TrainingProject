package filterTest;

import base.WebTestRunner;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Fail;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.PageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class PlpFilterTest extends WebTestRunner {

    @Test(description = "Проверка работы фильтра по категории и бренду")
    public void filterByCategoryAndBrandTest() {

        // Перейти на сайт
        goToWebsite();

        // Проверить, что навигационное меню отображается
        try {
            assertThat("Навигационное меню не отображается", onSite().onHeader.navMenu(), displayed());
        } catch (NoSuchElementException e) {
            Assertions.assertThat((char[]) Fail.fail("Елемент не найден: " + e));
        }

        // Навести на раздел "Телевизоры" навигационного меню
        onSite().onHeader.hoverOverNavMenuSection("Телевизоры");

        // Нажать на пункт "Все телевизоры" подраздела "Телевизоры"
        onSite().onHeader.itemSubsection("Все телевизоры").click();

        // Проверить, что открыта страница телевизоров
        onSite().onPlp.checkThatTheExpectedPageIsOpen("Телевизоры");

        // В фасете "Категории" выбрать фильтр "4К"
        onSite().onProductFilter.toSetTheFilterInFaset("Категории", "4K");

        // Проверить совпадает ли количество товаров в фильтре "4К" фасета "Категории" и заголовке
        onSite().onProductFilter.isTheNumberOfItemsInTheFilterAndTheHeaderTheSame("Категории", "4K");

        // В фасете "Бренд" выбрать фильтр "Sony"
        onSite().onProductFilter.toSetTheFilterInFaset("Бренд", "Sony");

        // Проверить совпадает ли количество товаров в фильтре "Sony" фасета "Бренд" и заголовке
        onSite().onProductFilter.isTheNumberOfItemsInTheFilterAndTheHeaderTheSame("Бренд", "Sony");

        // В фасете "Бренд" снять выбор с фильтра "Sony"
        onSite().onProductFilter.removeTheFilterInFacets("Бренд", "Sony");

        // Проверить совпадает ли количество товаров в фильтре "4К" фасета "Категории" и заголовке
        onSite().onProductFilter.isTheNumberOfItemsInTheFilterAndTheHeaderTheSame("Категории", "4K");
    }

    private PageObject onSite() {
        return atlas.create(webDriver, PageObject.class);
    }
}
