package PageObjects;

import RightMoveTest.LoadProp;
import RightMoveTest.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

public class CommonPage extends Utils {

    protected LoadProp loadProp = new LoadProp();
    DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy"); //dd/MM/yyyy

    private By _sortDropDown = By.id("sortType");
    private By _firstNonFeaturedProperty = By.xpath("//div[@id=\"l-searchResults\"]/div[2]/div/div/div[4]/div/div[2]/a");
    private By _addedToSiteForSaleDate = By.id("firstListedDateValue");
    private By _addedToSiteForRentDate = By.xpath("//div[@id=\"lettingInformation\"]/table/tbody/tr/td[2]");

    public String sortNewestListed = loadProp.getProperty("sortDropDown");
    public String addedToSiteForSaleDate, actualAddedToSiteForRentDate;
    public boolean actualAddedToSiteForRentDateBoolean = false;


    public void selectFromSortDropDown(String sort) {
        mySelectByVisibleText(_sortDropDown, sort);
    }

    public void selectFirstNonFeaturedProperty() {
        //scroll page up
        scrollPage(0, 250);
        waitUntilClickableAndClickCommand(_firstNonFeaturedProperty);
    }

    public void getAddedToRightMoveDateForSale() {

        addedToSiteForSaleDate = getText(_addedToSiteForSaleDate);
    }



    public void getAddedToRightMoveDateForRent() {

        //getting correct locator i.e. actual date when property added to RightMove site
        List<WebElement> elements = driver.findElements(_addedToSiteForRentDate);

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().contains("ago")) {
                actualAddedToSiteForRentDate = elements.get(i).getText().replaceAll("\\(.*?\\) ?", "");
            }
        }

        List<String> list = new ArrayList<String>();
        System.out.println("Actual added date "+actualAddedToSiteForRentDate);
        list.add(actualAddedToSiteForRentDate); //15 February 2018

        String todayDate = getTodayDate();
        System.out.println("today date "+todayDate);//16 February 2018

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(todayDate));
            c.add(Calendar.DATE, -1);  // number of days to minus
            String yesterdayDate = dateFormat.format(c.getTime());
            c.add(Calendar.DATE, -1);
            String dayb4YesterdayDate = dateFormat.format(c.getTime());
            System.out.println("yesterday Date " + yesterdayDate);
            System.out.println("day befor yesterday date " + dayb4YesterdayDate);
            list.add(yesterdayDate); //15 February 2018
            list.add(dayb4YesterdayDate); //14 February 2018
        }
        catch (Exception e){};


        for (int i =0; i<list.size(); i++){
            System.out.println("===== "+list.get(i));
            if (list.get(i).contains(todayDate)){
                actualAddedToSiteForRentDateBoolean = true;
                break;
            }
        }

    }
}










