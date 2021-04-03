package base;

import com.codeborne.selenide.Configuration;
import org.junit.Before;

public class TestBase {

    static {
        Configuration.baseUrl = "http://localhost:80/selenide-playground-master/";
        //Configuration.timeout = 1000;         // time out orig. 4s
        //Configuration.pollingInterval = 100;  //sledovanie zmeny na stranke
        Configuration.clickViaJs = true;
        //Configuration.reportsFolder = "src/test/resources/reportaze";
        //Configuration.reportsUrl = "src/test/resources/reportaze";
        Configuration.headless = true;     //bez Browsera
        Configuration.startMaximized = true;
        //Configuration.holdBrowserOPen = true;
        //Configuration.browser = Browsers.FIREFOX;
        //Configuration.remote = "????????????????";
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\temp\\Driver\\chromedriver.exe");
        // driver = new ChromeDriver();
       // WebDriverRunner.setWebDriver(driver);
    }

}
