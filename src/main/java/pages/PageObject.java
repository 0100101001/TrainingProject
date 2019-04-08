package pages;

import io.qameta.atlas.webdriver.WebSite;
import pages.component.Header;
import pages.component.ProductFilter;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.myAccountPage.MyAccountPage;
import pages.plp.Plp;
import pages.popupMsgAndBanner.PopupMsgAndBanner;

import static base.ApplicationManager.atlas;
import static base.ApplicationManager.webDriver;

public interface PageObject extends WebSite {

//    @Page
//    MainPage onMainPage();
//
//    @Page
//    LoginPage onLoginPage();
//
//    @Page
//    MyAccountPage onMyAccountPage();
//
//    @Page
//    PopupMsgAndBanner onPopupMsgAndBanner();

    LoginPage onLoginPage = atlas.create(webDriver, LoginPage.class);
    MainPage onMainPage = atlas.create(webDriver, MainPage.class);
    MyAccountPage onMyAccountPage = atlas.create(webDriver, MyAccountPage.class);
    PopupMsgAndBanner onPopupMsgAndBanner = atlas.create(webDriver, PopupMsgAndBanner.class);
    Header onHeader = atlas.create(webDriver, Header.class);
    Plp onPlp = atlas.create(webDriver, Plp.class);
    ProductFilter onProductFilter = atlas.create(webDriver, ProductFilter.class);

}
