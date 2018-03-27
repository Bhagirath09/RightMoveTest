package PageObjects;

import RightMoveTest.LoadProp;
import RightMoveTest.Utils;
import org.openqa.selenium.By;

public class HomePage extends Utils {

private By _searchLocation = By.id("searchLocation");
private By _firstLocationDropDown = By.xpath("//ul[@id=\"typeaheadList\"]/li/a");
private By _sale = By.id("buy");
private By _rent = By.id("rent");

protected LoadProp loadProp = new LoadProp();

public String searchLocation = loadProp.getProperty("searchLocation");

public void inputSearchLocation(){
    myEnterText(_searchLocation, searchLocation );
}

public void chooseFirstLocationiFromDropDown(){

myClick(_firstLocationDropDown);
}

public void clickSale(){
    myClick(_sale);
}

public void clickRent(){
    myClick(_rent);
}

}
