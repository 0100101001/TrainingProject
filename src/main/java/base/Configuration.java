package base;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:config/project.properties", "file:config/credentials.properties"})

public interface Configuration extends Config {

    @DefaultValue("www.mvideo.ru")
    @Key("site.domain")
    public String siteDomain();

    @DefaultValue("https://www.mvideo.ru")
    @Key("site.url")
    public String siteUrl();

    @DefaultValue("Chrome")
    @Key("browser")
    public String browser();

    @Key("user.login")
    public String userLogin();

    @Key("user.password")
    public String userPassword();

    @Key("user.login.invalid")
    public String userLoginInvalid();

    @Key("user.password.invalid")
    public String userPasswordInvalid();


}
