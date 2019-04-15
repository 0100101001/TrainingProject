package pages;

import io.qameta.atlas.webdriver.WebSite;
import pages.component.Header;
import pages.component.ProductFilter;
import pages.loginPage.LoginPage;
import pages.myAccountPage.MyAccountPage;
import pages.plp.Plp;

import static base.ApplicationManager.atlas;
import static base.ApplicationManager.webDriver;

public interface PageObject extends WebSite {

    LoginPage onLoginPage = atlas.create(webDriver, LoginPage.class);
    MyAccountPage onMyAccountPage = atlas.create(webDriver, MyAccountPage.class);
    Header onHeader = atlas.create(webDriver, Header.class);
    Plp onPlp = atlas.create(webDriver, Plp.class);
    ProductFilter onProductFilter = atlas.create(webDriver, ProductFilter.class);
}
