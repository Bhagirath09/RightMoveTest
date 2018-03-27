package RightMoveTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {

    public static void myClick(By by) {
        driver.findElement(by).click();
    }

    public static void myEnterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //clear text method
    public static void clearText(By by){
        driver.findElement(by).clear();
    }

    //Select by Index
    public static void mySelectByIndex(By by, int index) {
        Select s = new Select (driver.findElement(by));
        s.selectByIndex(index);
    }

    //Select by Value
    public static void mySelectByValue(By by, String value) {
        Select s = new Select (driver.findElement(by));
        s.selectByValue(value);
    }

    //Select by VisibleText
    public static Select mySelectByVisibleText(By by, String text) {
        Select s = new Select (driver.findElement(by));
        s.selectByVisibleText(text);
        return s;
    }

    //Get text method
    public static String getText(By by){
        String text = driver.findElement(by).getText();
        return text;
    }

    public static void waitUntilClickableAndClickCommand(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    public static void waitUntilVisibleAndClickCommand(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }


    //scroll page up or down (up is minus i.e. -250)
    public static void scrollPage(int x, int y){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy("+x+","+y+")", "");
    }

//    static boolean comp_Dates(String date) {
//        try {
//            SimpleDateFormat fmt = new SimpleDateFormat("dd MMMM yyyy");
//
//            Date todayDate = getTodayDate();
//
//            if (ActualDate.compareTo(todayDate) >= 0 && ActualDate.compareTo(todayDate) <= 0) {
//                return true;
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return false;
//    }

    public static String getTodayDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy"); //dd/MM/yyyy

            //get current date time with Date()
            Date date = new Date();

            // Now format the date
            String date1= dateFormat.format(date);

            return date1;
        }

        public static boolean compareDates(Date actualDate, Date testDate){
            try{
            if (actualDate.compareTo(testDate) == 0 || actualDate.compareTo(testDate) <= 2) {
                return true;
            }
            } catch (Exception e) {}
              return false;

        }


    public static void captureScreenShot(WebDriver driver, String imagePath){
        // Take screenshot and store as a file format
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile method
            FileUtils.copyFile(src, new File(imagePath));
        } catch (IOException e)

        {
            System.out.println(e.getMessage());
        }
    }


    public static void tearDown(ITestResult result)
    {
        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
                // Create refernce of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                // Copy files to specific location here it will save all screenshot in our project home directory and
                // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("./target/ScreenShots/"+result.getName()+".png"));

                System.out.println("Screenshot taken");
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }

    }

}
