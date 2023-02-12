package resources.globalresources;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testutils.ExcelUtilis.ExcelTestDataUtility;

public class GlobalStatic {
    public static Properties prop;
    public static WebDriver driver;
    public static int  implicitWaitTimeInSeconds = 10;
    public static WebDriverWait wait;
    public static ExcelTestDataUtility testData;
    public static String  testCase_ID;
    public static String  testCase_NAME;

    public static void assignTestCaseID(String  id){
        testCase_ID = id;
    }

}
