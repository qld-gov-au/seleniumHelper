package au.gov.qld.online.selenium;

import org.openqa.selenium.WebDriver;

public class WebDriverHolder {

    private WebDriver webDriver;
    private DriverTypes driverType;
    private int numberUsed = 0;

    public WebDriverHolder(WebDriver webDriver, DriverTypes driverType) {
        this.webDriver = webDriver;
        this.driverType = driverType;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public DriverTypes getDriverType() {
        return driverType;
    }

    public String getBrowserName() {
        return driverType.name();
    }

    public int incrementUsed() {
        return ++numberUsed;
    }
}
