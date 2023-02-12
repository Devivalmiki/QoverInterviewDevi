package Qover.org.Tests;

import basepackage.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.globalresources.GlobalStatic;
import resources.quotepage.QuotePage;

import java.io.IOException;

@Listeners({testutils.ListnersUtilis.ListnersUtility.class, testutils.ExtendReports.ExtendReports.class})
public class QuotePageTests extends Base {
        QuotePage qp;

        @BeforeMethod(alwaysRun = true)
        public void testSetup() throws IOException, InterruptedException {
            launchBrowserAndOpenUrl();
            qp=new QuotePage();
        }

        @Test(priority = 1)
        //THis Test CAse is used to delete the records from Overview Page
        public void testingUrl(){
            GlobalStatic.assignTestCaseID("TC1");
            System.out.println(" I am in first testcase " +GlobalStatic.testCase_ID);
        }

        @Test(priority = 2)
            public void validateQovertitle(){
            GlobalStatic.assignTestCaseID("TC2");
            qp.validateQuotepage();
        }

        @Test(priority = 3,groups = {"Positive cases for Insured Value textbox"})
        public void createQuotetest1() throws InterruptedException {
            GlobalStatic.assignTestCaseID("TC3");
            qp.createQuote(2);
            validateResult(qp.validaterrormessage(),false);
            qp.planforquote(2);
            Thread.sleep(1000);
        }

        @Test(priority = 4,groups = {"Positive cases for Insured Value textbox"})
        public void createQuotetest2(){
        GlobalStatic.assignTestCaseID("TC4");
        qp.createQuote(3);
        validateResult(qp.validaterrormessage(),false);
        qp.planforquote(3);

    }

        @Test(priority = 5,groups = {"Positive cases for Insured Value textbox"})
        public void createQuotetest3(){
        GlobalStatic.assignTestCaseID("TC5");
        qp.createQuote(4);
        validateResult(qp.validaterrormessage(),false);
        qp.planforquote(4);

    }

        @Test(priority = 6,groups = {"Positive cases for Insured Value textbox"})
        public void createQuotetest4(){
        GlobalStatic.assignTestCaseID("TC6");
        qp.createQuote(5);
        validateResult(qp.validaterrormessage(),false);
        qp.planforquote(5);

    }

        @Test(priority = 7,groups = {"Positive cases for Insured Value textbox"})
        public void createQuotetest5(){
        GlobalStatic.assignTestCaseID("TC7");
        qp.createQuote(6);
        validateResult(qp.validaterrormessage(),false);
        qp.planforquote(6);
        }

        @Test(priority = 8,groups = {"Positive cases for Insured Value textbox"})
        public void createQuotetest6(){
        GlobalStatic.assignTestCaseID("TC8");
        qp.createQuote(7);
        validateResult(qp.validaterrormessage(),false);
        qp.planforquote(7);

        }

        @Test(priority = 9,groups = {"Negative cases for Insured Value textbox"})
        public void createQuotetest7() {
        GlobalStatic.assignTestCaseID("TC3");
        qp.createQuote(8);
        validateResult(qp.validaterrormessage(),true);
        }

        @Test(priority = 10,groups = {"Negative cases for Insured Value textbox"})
        public void createQuotetest8() {
        GlobalStatic.assignTestCaseID("TC3");
        qp.createQuote(9);
        validateResult(qp.validaterrormessage(),true);
    }

        @AfterMethod(alwaysRun = true)
        public void tearDown() {
            GlobalStatic.driver.quit();
        }


    private void validateResult(boolean hasError, boolean shouldHaveError){
            if (hasError==true&shouldHaveError==false)
              Assert.fail("There should not be any error as data is valid");
        if (hasError==false&shouldHaveError==true)
        Assert.fail("There should be error as data in invalid");

    }
}
