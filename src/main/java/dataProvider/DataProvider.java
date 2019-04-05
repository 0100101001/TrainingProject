package dataProvider;

import testData.users.LoginAndPassword;

import java.io.IOException;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "login")
    public static Object[][] getTypeOfLogin() throws IOException {
        LoginAndPassword loginAndPassword = new LoginAndPassword();

        return new Object[][]{{loginAndPassword.login, loginAndPassword.password},
                {loginAndPassword.invalidLogin, loginAndPassword.invalidPassword}
        };

    }
}
