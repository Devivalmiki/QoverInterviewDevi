package testutils.ListnersUtilis;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.globalresources.GlobalStatic;

import java.io.File;
import java.io.IOException;

public class ListnersUtility implements ITestListener{

        @Override
        public void onTestStart(ITestResult iTestResult) {
            GlobalStatic.testCase_NAME = iTestResult.getName();
        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {
            System.out.println("=============================================");
            System.out.println("CONGRATULATIONS YOUR TEST GOT PASSED");
            System.out.println();
            System.out.println("TEST_CASE_NAME: "+iTestResult.getName());
            System.out.println();
            System.out.println("=============================================");

        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {

            String outputDirectory = "C:/QoverProj/Appliction_Screenshots/"+GlobalStatic.testCase_ID+"/failedTestScreenshot.jpg";
            try {
                File f = ((TakesScreenshot) GlobalStatic.driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(f, new File(outputDirectory));
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("=============================================");
            System.out.println("SORRY!!! YOUR TEST GOT FAILED, PLEASE GO AND ANALYZE IT");
            System.out.println();
            System.out.println("TEST_CASE_NAME: "+iTestResult.getName());
            System.out.println();
            System.out.println("FAILURE SCREENSHOT PATH: "+outputDirectory);
            System.out.println("=============================================");

        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {
            System.out.println("=============================================");
            System.out.println("HEY!!! YOUR TEST GOT SKIPPED, PLEASE GO AND ANALYZE IT");
            System.out.println();
            System.out.println("TEST_CASE_NAME: "+iTestResult.getName());
            System.out.println();
            System.out.println("=============================================");

        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        }

        @Override
        public void onStart(ITestContext iTestContext) {

        }

        @Override
        public void onFinish(ITestContext iTestContext) {

        }
    }


