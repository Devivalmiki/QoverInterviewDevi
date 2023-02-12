package resources.quotepage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import resources.globalresources.GlobalStatic;
import testutils.Screenshots.QoverAppScreenShots;

public class QuotePage {

    boolean error;
    public QuotePage() {
        PageFactory.initElements(GlobalStatic.driver, this);
    }

    @FindBy(xpath = "//div[@class='sc-ig5rfh-0 hbkNnP']")
    WebElement qovermetitle;
    @FindBy(xpath = "//div[@class='sc-1s726yt-0 eYbXbS markdown']/span[text()='Your quote for']")
    WebElement yourquotefor;
    // @FindBy(id = "bike.quote.type")
    @FindBy(xpath = "//select[@id='bike.quote.type']")
    WebElement typeofbike;
    @FindBy(xpath = "//input[@name='risk.originalValue']")
    WebElement insuredvalue;
    @FindBy(xpath = "//select[@id='bike.quote.antiTheftMeasure']")
    WebElement bike;
    @FindBy(xpath = "//button[@class='sc-1yccttm-0 jNvFvF justify']")
    WebElement seepricesbutton;

    //possibility of dynamic xpath here

    @FindBy(xpath = "//div[1]/div/div[3]/button/span[@class='sc-tvfxnk-4 IRoSq bold']")
    WebElement theftassistanceplan;
    @FindBy(xpath = "//div[2]/div/div[3]/button/span[@class='sc-tvfxnk-4 IRoSq bold']")
    WebElement omniumplan;

    //Xpaths of error messages on quote page

    @FindBy(xpath = "//span[@class='sc-tvfxnk-4 IRoSq']")
    WebElement insuredvalueerrormessage;


    public void validateQuotepage() {
        qovermetitle.isDisplayed();
        yourquotefor.isDisplayed();
        System.out.println(" I am on the right page");
    }

    public void createQuote(int rownum) {

        String typeofbikedropdownval = GlobalStatic.testData.getCellData("Quote", 0, rownum);
        QoverAppScreenShots.takeSelfie("QuotePage");
        Select typeofbikedropdown = new Select(typeofbike);
        typeofbikedropdown.selectByVisibleText(typeofbikedropdownval);

        String insuredvaluedata = GlobalStatic.testData.getCellData("Quote", 1, rownum);
        insuredvalue.sendKeys(insuredvaluedata);

        Select bikedropdown = new Select(bike);
        String bikedropdownval = GlobalStatic.testData.getCellData("Quote", 2, rownum);
        bikedropdown.selectByVisibleText(bikedropdownval);
        seepricesbutton.click();
    }

    public boolean validaterrormessage() {
        try {
        error = insuredvalueerrormessage.isDisplayed();
        } catch (NoSuchElementException e) {
            error = false;
        }

        return error;
    }

    public void planforquote(int rownum) {
            String chooseplanval = GlobalStatic.testData.getCellData("Quote", 3, rownum);
            Float planValue = (Float.valueOf(chooseplanval)).floatValue();
            System.out.println("planValue:" + planValue);
            if (planValue == 1) {
                System.out.println("The plan choose is Theft+Assistance");
                theftassistanceplan.click();
            } else if (planValue == 2) {
                System.out.println("The plan choose is Omnium");
                omniumplan.click();
            }
        }
    }

