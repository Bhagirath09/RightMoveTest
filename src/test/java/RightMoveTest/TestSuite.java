package RightMoveTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSuite extends BaseTest {

    static ExtentReports report = new ExtentReports("target/Reports/TestNG-Extent-report.html");
    static ExtentTest logger;
    String methodName;

@Test (priority = 0)
    public void toVerifyUserShouldBeAbleToFindPropertyForSaleUsingSearchLocationAndFilters(){

        SoftAssert softAssertObj = new SoftAssert();
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger = report.startTest(methodName);

        //insert location of choice i.e. harrow
        homePage.inputSearchLocation();
        logger.log(LogStatus.INFO, "Entered Harrow as location");

        //choose first location from dropdown
        homePage.chooseFirstLocationiFromDropDown();

        //click on sale button
        homePage.clickSale();
        logger.log(LogStatus.INFO, "Clicked on Sale button");
        String actualOnPropertySeach = driver.findElement(By.xpath("//div[@id=\"pageheader\"]/h1")).getText();

        //Assert that loaded page is for Property for sale in harrow
        Assert.assertTrue(actualOnPropertySeach.contains("for sale") &&
                         (actualOnPropertySeach.contains("Harrow")));
        logger.log(LogStatus.PASS, "Loaded page is for Property for Sale in Harrow is verified");

        //select radius i.e. Within 3 miles
        propertySearch.selectSearchRadius();
        logger.log(LogStatus.INFO, "Selected Within 3 miles radius");

        //select minimum amount i.e. 425,000
        propertySearch.selectMinimumPrice(propertySearch.minPriceForSale);
        logger.log(LogStatus.INFO, "Selected minimum price 425,000");

        //select maximum amount i.e. 550,000
        propertySearch.selectMaximumPrice(propertySearch.maxPriceForSale);
        logger.log(LogStatus.INFO, "Selected maximum price 550,000");

        //select minimum bedrooms i.e. 2
        propertySearch.selectMinimumBedrooms();
        logger.log(LogStatus.INFO, "Selected minimum 2 bedrooms");

        //select maximum bedrooms i.e. 4
        propertySearch.selectMaximumBedrooms();
        logger.log(LogStatus.INFO, "Selected maximum 4 bedrooms");

        //select type of property i.e. houses
        propertySearch.selectPropertyType();
        logger.log(LogStatus.INFO, "Selected House type property");

        //select within last 14 days
        propertySearch.selectMaximumDaysSinceAddedToSite();
        logger.log(LogStatus.INFO, "Selected property to be seen added to site within last 14 days");

        //click on Find properties button
        captureScreenShot(driver, "target/ScreenShots/clickFindPropertiesForSale.png");
        propertySearch.clickFindProperties();
        logger.log(LogStatus.INFO, "clicked on Find properties");

        //Asserting to match drop down filter values
        String actual = driver.findElement(By.className("searchTitle-heading")).getText();

        softAssertObj.assertTrue(actual.contains("within 3 miles"), "property radius is not within 3 miles");//radius
        logger.log(LogStatus.PASS, "Result within 3 miles radius verified");
        softAssertObj.assertTrue(actual.contains("425,000"), "min price is not 425,000" );//min price
        logger.log(LogStatus.PASS, "Result of minimum price verified");
        softAssertObj.assertTrue(actual.contains("550,000"), "max price is not 550,000");//max price
        logger.log(LogStatus.PASS, "Result of maximum price verified");
        softAssertObj.assertTrue(actual.contains("2 – 4 bed"), "min bed is not 2 - 4");//min & max bed
        logger.log(LogStatus.PASS, "Resutl of minimum and minimum Bedrooms verified");
        softAssertObj.assertTrue(actual.contains("Houses"), "property type is not houses");//property type
        logger.log(LogStatus.PASS, "Result of type of property House is verified");
        softAssertObj.assertTrue(actual.contains("last 14 days"), "property added to site in last 14 days is not showing ");// added to site
        logger.log(LogStatus.PASS, "Result of property aaded in last 14 days verified");

        //select Newest Listed from sort dropdown menu
        commonPage.selectFromSortDropDown(commonPage.sortNewestListed);
        logger.log(LogStatus.INFO, "Selected NewestListed option from Sort Dropdown menu");

        //select first listed Non-Featured property
        commonPage.selectFirstNonFeaturedProperty();
        logger.log(LogStatus.INFO, "clicked on first Non-Featured property");

        //Asserting property is Newest i.e. added today
        String todayDate = getTodayDate();
        commonPage.getAddedToRightMoveDateForSale();//get date of property added to rightmove

        Assert.assertEquals(commonPage.addedToSiteForSaleDate, todayDate, "property is not new. Not added today");
        logger.log(LogStatus.PASS, "Property is newly added to site is verified");

    softAssertObj.assertAll();

    }

    @Test (priority = 1)
    public void toVerifyUserShouldBeAbleToFindPropertyForRentUsingSearchLocationAndFilters(){

        SoftAssert softAssertObj = new SoftAssert();
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        logger = report.startTest(methodName);

        //insert location of choice i.e. harrow
        homePage.inputSearchLocation();
        logger.log(LogStatus.PASS, "Entered Harrow as location");

        //choose first location from dropdown
        homePage.chooseFirstLocationiFromDropDown();

        //click on rent button
        homePage.clickRent();
        logger.log(LogStatus.PASS, "Clicked on Rent button");
        String actualOnPropertySeach = driver.findElement(By.xpath("//div[@id=\"pageheader\"]/h1")).getText();

        //Assert that loaded page is for Property for rent in harrow
        Assert.assertTrue((actualOnPropertySeach.contains("to rent")) &&
                              (actualOnPropertySeach.contains("Harrow")));

        logger.log(LogStatus.PASS, "Loaded page is for Property for Rent in Harrow is verified");

        //select radius i.e. Within 3 miles
        propertySearch.selectSearchRadius();
        logger.log(LogStatus.PASS, "Selected Within 3 miles radius");

        //select minimum amount i.e. 1200
        propertySearch.selectMinimumPrice(propertySearch.minPriceForRent);
        logger.log(LogStatus.PASS, "Selected minimum price 1200");

        //select maximum amount i.e. 1500
        propertySearch.selectMaximumPrice(propertySearch.maxPriceForRent);
        logger.log(LogStatus.PASS, "Selected maximum price 1500");

        //select minimum bedrooms i.e. 2
        propertySearch.selectMinimumBedrooms();
        logger.log(LogStatus.PASS, "Selected minimum 2 bedrooms");

        //select maximum bedrooms i.e. 4
        propertySearch.selectMaximumBedrooms();
        logger.log(LogStatus.PASS, "Selected maximum 4 bedrooms");

        //select type of property i.e. houses
        propertySearch.selectPropertyType();
        logger.log(LogStatus.PASS, "Selected House type property");

        //select within last 14 days
        propertySearch.selectMaximumDaysSinceAddedToSite();
        logger.log(LogStatus.PASS, "Selected property to be seen added to site within last 14 days");

        //click on Find properties button
        captureScreenShot(driver, "target/ScreenShots/clickFindPropertiesForRent.png");
        propertySearch.clickFindProperties();
        logger.log(LogStatus.PASS, "clicked on Find properties");

        //Asserting to match drop down filter values
        String actual = driver.findElement(By.className("searchTitle-heading")).getText();

        softAssertObj.assertTrue(actual.contains("within 3 miles"), "property radius is not within 3 miles");//radius
        logger.log(LogStatus.PASS, "Result within 3 miles radius verified");
        softAssertObj.assertTrue(actual.contains("1,200"), "min price is not 1,200" );//min price
        logger.log(LogStatus.PASS, "Result of minimum price verified");
        softAssertObj.assertTrue(actual.contains("1,500"), "max price is not 1,500");//max price
        logger.log(LogStatus.PASS, "Result of maximum price verified");
        softAssertObj.assertTrue(actual.contains("2 – 4 bed"), "min bed is not 2 - 4");//min & max bed
        logger.log(LogStatus.PASS, "Resutl of minimum and minimum Bedrooms verified");
        softAssertObj.assertTrue(actual.contains("Houses"), "property type is not houses");//property type
        logger.log(LogStatus.PASS, "Result of type of property House is verified");
        softAssertObj.assertTrue(actual.contains("last 14 days"), "property added to site in last 14 days is not showing ");// added to site
        logger.log(LogStatus.PASS, "Result of property aaded in last 14 days verified");

        //select Newest Listed from sort dropdown menu
        commonPage.selectFromSortDropDown(commonPage.sortNewestListed);
        logger.log(LogStatus.PASS, "Selected NewestListed option from Sort Dropdown menu");

        //select first listed Non-Featured property
        commonPage.selectFirstNonFeaturedProperty();
        logger.log(LogStatus.PASS, "clicked on first Non-Featured property");

        //Asserting property is Newest i.e. added today
        //in method getAddedToRightMoveDateForRent() we are getting text of date added to rightmove.
        // then based on today date we are getting two another date (past date by 1 day i.e if today is 15th, we are getting 14, 13)
        //then we are asserting those date with rightmove's date

        commonPage.getAddedToRightMoveDateForRent();
//        System.out.println(commonPage.actualAddedToSiteForRentDateBoolean);
        Assert.assertTrue(commonPage.actualAddedToSiteForRentDateBoolean, "property is not new. Not added in last three days");
        logger.log(LogStatus.PASS, "Property is newly added to site is verified");

        softAssertObj.assertAll();
    }

}
