package base;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/main/java/config/project.properties", "file:src/main/java/config/credentials.properties"})

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

    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();

    @Key("user.login.invalid")
    String userLoginInvalid();

    @Key("user.password.invalid")
    String userPasswordInvalid();

}
