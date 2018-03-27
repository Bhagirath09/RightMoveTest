package PageObjects;

import RightMoveTest.LoadProp;
import RightMoveTest.Utils;
import org.openqa.selenium.By;

public class PropertySearch extends Utils {

    protected LoadProp loadProp = new LoadProp();

    private By _radiusValue = By.name("radius");
    private By _minPrice = By.name("minPrice");
    private By _maxPrice = By.name("maxPrice");
    private By _minBed = By.name("minBedrooms");
    private By _maxBed = By.name("maxBedrooms");
    private By _propertyType = By.id("displayPropertyType");
    private By _addedToSite = By.id("maxDaysSinceAdded");
    private By _findPropertyButton = By.id("submit");

    public String radiusValue = loadProp.getProperty("radius");
    public String minPriceForSale = loadProp.getProperty("saleMinPrice");
    public String maxPriceForSale = loadProp.getProperty("saleMaxPrice");
    public String minPriceForRent = loadProp.getProperty("rentMinPrice");
    public String maxPriceForRent = loadProp.getProperty("rentMaxPrice");
    public String minBedrooms = loadProp.getProperty("minBedrooms");
    public String maxBedrooms = loadProp.getProperty("maxBedrooms");
    public String propertyType = loadProp.getProperty("propertyType");
    public String addedToSite = loadProp.getProperty("addedToSite");


    public void selectSearchRadius(){
       mySelectByVisibleText(_radiusValue, radiusValue);
    }

    public void selectMinimumPrice(String minPrice){
        mySelectByValue(_minPrice, minPrice);
    }

    public void selectMaximumPrice(String maxPrice){
        mySelectByValue(_maxPrice, maxPrice);
    }

    public void selectMinimumBedrooms(){
        mySelectByValue(_minBed, minBedrooms);
    }

    public void selectMaximumBedrooms(){
        mySelectByValue(_maxBed, maxBedrooms);
    }

    public void selectPropertyType(){
        mySelectByValue(_propertyType, propertyType);
    }

    public void selectMaximumDaysSinceAddedToSite(){
        mySelectByValue(_addedToSite, addedToSite);
    }

    public void clickFindProperties(){
        //scroll page up
        scrollPage(0, -250);

        waitUntilClickableAndClickCommand(_findPropertyButton);
    }
}
