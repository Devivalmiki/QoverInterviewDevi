package basepackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.globalresources.GlobalStatic;
import resources.quotepage.QuotePage;
import testutils.ExcelUtilis.ExcelTestDataUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    /**
     Below constructor will take care of loading Properties files & load testData excel
     It will get execute when child class object got created as well
     */
    public  Base() {
        try {
            FileInputStream propfile = new FileInputStream("src/main/java/configpackage/Config.properties");
            GlobalStatic.prop = new Properties();
            GlobalStatic.prop.load(propfile);
            GlobalStatic.testData = new ExcelTestDataUtility("src/main/java/testdata/QoverData.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QuotePage launchBrowserAndOpenUrl() throws InterruptedException, IOException
    {
        String browserName = System.getProperty("Browser");
        if(browserName != null){
            assignWebDriver(browserName);
        }  else  {
            assignWebDriver(GlobalStatic.prop.getProperty("browser"));
        }
        String applicationURL = System.getProperty("URL");
        if(applicationURL != null){
            GlobalStatic.driver.get(applicationURL);
        }  else  {
            GlobalStatic.driver.get(GlobalStatic.prop.getProperty("url"));
        }
        GlobalStatic.driver.manage().window().maximize();
        GlobalStatic.driver.manage().timeouts().implicitlyWait(GlobalStatic.implicitWaitTimeInSeconds, TimeUnit.SECONDS);
        GlobalStatic.wait = new WebDriverWait(GlobalStatic.driver, GlobalStatic.implicitWaitTimeInSeconds);
        // ApplicationScreenshots.takeSelfie("Qover_Application");
        return  new QuotePage();
    }

    private void assignWebDriver(String nameOfTheBrowser){
        switch (nameOfTheBrowser) {
            case "chrome":
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Hybrid/Drivers/Chrome/chromedriver.exe");
                GlobalStatic.driver = new ChromeDriver();
                break;
            case "ff":
            case "Firefox":
            case "FF":
            case "Mozilla Firefox":
                System.setProperty("webdriver.gecko.driver", "C:/Hybrid/Drivers/Firefox/geckodriver.exe");

                GlobalStatic.driver = new FirefoxDriver();
                break;
            case "Safari":
            case "SAFARI":
                System.setProperty("webdriver.safari.driver", "");
                GlobalStatic.driver = new SafariDriver();
                break;
            case "Edge":
            case "edge":
            case "Microsoft Edge":
                System.setProperty("webdriver.edge.driver", "");
                GlobalStatic.driver = new EdgeDriver();
                break;
        }

    }

}
