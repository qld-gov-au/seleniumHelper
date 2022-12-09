package au.gov.qld.online.selenium;

import org.openqa.selenium.WebDriver;

public class WebDriverHolder {

    private WebDriver webDriver;
    private DriverTypes driverType;
    private int numberUsed = 0;
    private String downloadDirectory;

    public WebDriverHolder(WebDriver webDriver, DriverTypes driverType, String downloadDirectory) {
        this.webDriver = webDriver;
        this.driverType = driverType;
        this.downloadDirectory = downloadDirectory;
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

    public String getDownloadDirectory() {
        return downloadDirectory;
    }
}
