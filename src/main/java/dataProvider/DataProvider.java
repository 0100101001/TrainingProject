package dataProvider;

import testData.users.LoginAndPassword;

public class DataProvider {

  @org.testng.annotations.DataProvider(name="login")
  public static Object[][] getTypeOfLogin() {
    LoginAndPassword loginAndPassword = new LoginAndPassword();

    return new Object[][] { {loginAndPassword.getLogin(), loginAndPassword.getPassword()},
            {loginAndPassword.getInvalidLogin(), loginAndPassword.getInvalidPassword() }
    };

  }
}
