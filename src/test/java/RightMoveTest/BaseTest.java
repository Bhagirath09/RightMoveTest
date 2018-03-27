package RightMoveTest;

import PageObjects.CommonPage;
import PageObjects.HomePage;
import PageObjects.PropertySearch;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static RightMoveTest.TestSuite.logger;
import static RightMoveTest.TestSuite.report;

import java.io.File;

public class BaseTest extends Utils {

    protected HomePage homePage = new HomePage();
    protected PropertySearch propertySearch = new PropertySearch();
    protected BrowserSelector browserSelector = new BrowserSelector();
    protected LoadProp loadProp = new LoadProp();
    protected CommonPage commonPage = new CommonPage();

    static String imagePath;

    @BeforeMethod
    public void openBrowserAndEnterURL(){

        //open browser
        browserSelector.openBrowser(loadProp.getProperty("browser"));

        //Enter URL navigate to homepage
        driver.get(loadProp.getProperty("url"));
    }

@AfterMethod
    public static void tearDown(ITestResult result)
    {
        logger.log(LogStatus.INFO,  "Executing tearDown Method");

        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {

            logger.log(LogStatus.FAIL,  "Test case failed");

            try
            {
                // Create reference of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                imagePath = "target/ScreenShots/"+result.getName()+".png";

                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File(imagePath));

                System.out.println("Screenshot taken");

            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());

            }
            logger.log(LogStatus.FAIL,  logger.addScreenCapture(imagePath));
            report.endTest(logger);
            report.flush();
        }

        // close browser
        driver.quit();
        logger.log(LogStatus.INFO,  "Browser closed");
        report.endTest(logger);
        report.flush();
    }
}
