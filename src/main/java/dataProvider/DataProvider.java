package dataProvider;

import enums.LoginAndPassword;

public class DataProvider {

  @org.testng.annotations.DataProvider(name="login")
  public static Object[][] getTypeOfLogin() {
    return new Object[][] { {LoginAndPassword.autotestUserLogin.value, LoginAndPassword.getAutotestUserPassword.value},
            {LoginAndPassword.autotestuserFail.name(), LoginAndPassword.autotestuserFail.value }
    };

  }
}
