package enums;

public enum DriverPaths {
    chrome("src/main/resources/drivers/chromedriver.exe"),
    firefox("src/main/resources/drivers/geckodriver.exe");

    public String value;

    DriverPaths(String value) {
        this.value = value;
    }
}
