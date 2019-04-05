package pages;

import base.ApplicationManager;
import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.myAccountPage.MyAccountPage;
import pages.popupMsgAndBanner.PopupMsgAndBanner;

import java.io.IOException;

import static base.ApplicationManager.url;
import static base.ApplicationManager.webDriver;

public interface PageObject extends WebSite {

    @Page
    MainPage onMainPage();

    @Page
    LoginPage onLoginPage();

    @Page
    MyAccountPage onMyAccountPage();

    @Page
    PopupMsgAndBanner onPopupMsgAndBanner();

    default void openSite() {
        webDriver.get(url);
    }
}
