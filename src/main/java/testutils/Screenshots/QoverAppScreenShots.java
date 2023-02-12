package testutils.Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resources.globalresources.GlobalStatic;

import java.io.File;
import java.io.IOException;

public class QoverAppScreenShots {
        public static void takeSelfie(String nameOfTheScreenshot) {
            try {
                File f = ((TakesScreenshot) GlobalStatic.driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(f, new File("C:/QoverProj/Application_Screenshots/"+GlobalStatic.testCase_ID+"/"+nameOfTheScreenshot+".png"));
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
