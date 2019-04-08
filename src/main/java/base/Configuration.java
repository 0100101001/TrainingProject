package base;

import org.aeonbits.owner.Config;

import java.io.PrintStream;

//@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:config/project.properties", "file:config/credentials.properties"})

public interface Configuration extends Config {

    @DefaultValue("www.mvideo.ru")
    @Key("site.domain")
    String siteDomain();

    @DefaultValue("https://www.mvideo.ru")
    @Key("site.url")
    String siteUrl();

    @DefaultValue("Chrome")
    @Key("browser")
    String browser();

    @DefaultValue("YourLogin")
    @Key("user.login")
    String userLogin();

    @DefaultValue("YourPassword")
    @Key("user.password")
    String userPassword();

    @DefaultValue("autotestuserFail")
    @Key("user.login.invalid")
    String userLoginInvalid();

    @DefaultValue("12345678")
    @Key("user.password.invalid")
    String userPasswordInvalid();

    void list(PrintStream out);
}
