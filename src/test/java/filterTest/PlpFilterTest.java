package filterTest;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.PageObject;

import java.awt.event.ItemEvent;

public class PlpFilterTest extends TestBase {


    @Test(description = "Проверка работы фильтра по категории и бренду")
    public void filterByCategoryAndBrandTest() throws InterruptedException {

        // Перейти на сайт
        onSite().openSite();

        // Проверить, что навигационное меню отображается
        onSite().onHeader.checkNavMenuIsDisplayed();

        // Навести на раздел "Телевизоры" навигационного меню
        onSite().onHeader.hoverOverNavMenuSection("Телевизоры");
//        Thread.sleep(3000);
        // Нажать на пункт "Все телевизоры" подраздела "Телевизоры"
        onSite().onHeader.hoverAndClickOverASubsectionItemInTheNavMenu("Все телевизоры");

        // Проверить, что открыта страница со списком телевизоров
        onSite().onPlp.checkThatTheProductListPageIsOpen("Телевизоры");

        // В фасете "Категории" выбрать фильтр "4К"
        onSite().onProductFilter.toSetTheFilterInFaset("Категории", "4K");

        // Проверить совпадает ли количество товаров в фильтре "4К" фасета "Категории" и заголовке
        onSite().onProductFilter.isTheNumberOfItemsInTheFilterAndTheHeaderTheSame("Категории", "4K");

        // В фасете "Бренд" выбрать фильтр "Sony"
        onSite().onProductFilter.toSetTheFilterInFaset("Бренд", "Sony");

        // Проверить совпадает ли количество товаров в фильтре "Sony" фасета "Бренд" и заголовке
        onSite().onProductFilter.isTheNumberOfItemsInTheFilterAndTheHeaderTheSame("Бренд", "Sony");

        // В фасете "Бренд" снять выбор с фильтра "Sony"
        onSite().onProductFilter.removeTheFilterInFaset("Бренд", "Sony");

        // Проверить совпадает ли количество товаров в фильтре "4К" фасета "Категории" и заголовке
        onSite().onProductFilter.isTheNumberOfItemsInTheFilterAndTheHeaderTheSame("Категории", "4K");
    }

    private PageObject onSite() {
        return atlas.create(webDriver, PageObject.class);
    }
}
