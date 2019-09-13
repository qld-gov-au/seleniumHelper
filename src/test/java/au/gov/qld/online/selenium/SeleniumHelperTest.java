package au.gov.qld.online.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumHelperTest {

    private WebDriverHolder holder;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        SeleniumHelper.close(holder);
    }

    @Test
    public void shouldStartFirefoxBrowser() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        holder = SeleniumHelper.getWebDriver(DriverTypes.FIREFOX);
        holder.getWebDriver().navigate().to("https://www.google.com");
        SeleniumHelper.performScreenPrint(holder, testName);
    }

    @Test
    public void shouldStartFirefoxBrowserMultiTest() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        holder = SeleniumHelper.getWebDriver(DriverTypes.FIREFOX);
        WebDriverHolder holder2 = SeleniumHelper.getWebDriver(DriverTypes.FIREFOX);
        holder.getWebDriver().navigate().to("https://www.google.com");
        SeleniumHelper.performScreenPrint(holder2, testName);
        holder2.getWebDriver().navigate().to("https://www.qld.gov.au");
        SeleniumHelper.performScreenPrint(holder, testName);
        SeleniumHelper.performScreenPrint(holder2, testName);
        SeleniumHelper.close(holder);
        SeleniumHelper.close(holder2);

        WebDriverHolder holder3 = SeleniumHelper.getWebDriver(DriverTypes.FIREFOX);
        holder3.getWebDriver().navigate().to("https://www.whirlpool.net.au");
        SeleniumHelper.performScreenPrint(holder3, testName);
        SeleniumHelper.close(holder);
        int afterStart = SeleniumHelper.openDrivers();
    }

    @Test
    public void shouldStartFirefoxChromeBrowserMultiMixTest() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        holder = SeleniumHelper.getWebDriver(DriverTypes.FIREFOX);
        WebDriverHolder holder2 = SeleniumHelper.getWebDriver(DriverTypes.CHROME);
        holder.getWebDriver().navigate().to("https://www.google.com");
        SeleniumHelper.performScreenPrint(holder2, testName);
        holder2.getWebDriver().navigate().to("https://www.qld.gov.au");
        SeleniumHelper.performScreenPrint(holder, testName);
        SeleniumHelper.performScreenPrint(holder2, testName);
        SeleniumHelper.close(holder);
        SeleniumHelper.close(holder2);

        WebDriverHolder holder3 = SeleniumHelper.getWebDriver(DriverTypes.FIREFOX);
        holder3.getWebDriver().navigate().to("https://www.whirlpool.net.au");
        SeleniumHelper.performScreenPrint(holder3, testName);
        SeleniumHelper.close(holder);
    }

    @Test
    public void shouldStartEdgeBrowser() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        try {
            holder = SeleniumHelper.getWebDriver(DriverTypes.EDGE);
            holder.getWebDriver().navigate().to("https://www.google.com");
            SeleniumHelper.performScreenPrint(holder, testName);
        } catch (RuntimeException e) {
            //expected when not on windows
            assertThat(e.getMessage()).isEqualTo("Have to be on windows to run Edge");
            assertThat(e).isInstanceOf(IllegalStateException.class);
        }
    }

    @Test
    public void shouldStartSafariBrowser() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        try {
            holder = SeleniumHelper.getWebDriver(DriverTypes.SAFARI);
            holder.getWebDriver().navigate().to("https://www.google.com");
            SeleniumHelper.performScreenPrint(holder, testName);
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo("Have to be on Mac to run Safari");
            assertThat(e).isInstanceOf(IllegalStateException.class);
        }
    }

    @Test
    public void shouldStartChromeBrowser() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        holder = SeleniumHelper.getWebDriver(DriverTypes.CHROME);
        holder.getWebDriver().navigate().to("https://www.google.com");
        SeleniumHelper.performScreenPrint(holder, testName);
        SeleniumHelper.close(holder);
    }

    @Test
    public void shouldStartChromeBrowserWithTwoInaRow() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        holder = SeleniumHelper.getWebDriver(DriverTypes.CHROME);
        holder.getWebDriver().navigate().to("https://www.google.com");
        WebDriverHolder holder2 = SeleniumHelper.getWebDriver(DriverTypes.CHROME);
        holder2.getWebDriver().navigate().to("https://www.qld.gov.au");
        SeleniumHelper.performScreenPrint(holder, testName);
        SeleniumHelper.performScreenPrint(holder2, testName);
        SeleniumHelper.close(holder);
        SeleniumHelper.close(holder2);

        WebDriverHolder holder3 = SeleniumHelper.getWebDriver(DriverTypes.CHROME);
        SeleniumHelper.performScreenPrint(holder3, testName);
        holder3.getWebDriver().navigate().to("https://www.whirlpool.net.au");
        SeleniumHelper.performScreenPrint(holder3, testName);
        SeleniumHelper.close(holder);
    }

    @Test
    public void shouldStartHtmlUnitBrowser() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        holder = SeleniumHelper.getWebDriver(DriverTypes.HtmlUnitDriver);
        holder.getWebDriver().navigate().to("https://www.google.com");
        SeleniumHelper.performScreenPrint(holder, testName);
        SeleniumHelper.close(holder);
    }

    @Test
    public void shouldStartHtmlUnitWithJsBrowser() {
        String testName = new Object(){}.getClass().getEnclosingMethod().getName();
        SeleniumHelper.setDoScreenPrints(true);
        holder = SeleniumHelper.getWebDriver(DriverTypes.HtmlUnitDriverWithJS);
        holder.getWebDriver().navigate().to("https://www.google.com");
        SeleniumHelper.performScreenPrint(holder, testName);
    }
}
