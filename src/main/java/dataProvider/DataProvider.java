package dataProvider;

import enums.LoginAndPassword;

public class DataProvider {

  @org.testng.annotations.DataProvider(name="login")
  public static Object[][] getTypeOfLogin() {
    return new Object[][] { {LoginAndPassword.autotestUser.name(), LoginAndPassword.autotestUser.value},
            {LoginAndPassword.autotestuserFail.name(), LoginAndPassword.autotestuserFail.value }
    };

  }
}
