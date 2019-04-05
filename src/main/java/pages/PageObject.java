package pages;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;
import org.openqa.selenium.WebDriver;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.myAccountPage.MyAccountPage;

public interface PageObject extends WebSite {

    @Page
    MainPage onMainPage();

    @Page
    LoginPage onLoginPage();

    @Page
    MyAccountPage onMyAccountPage();
}
