package RightMoveTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {

    //open Firefox or Chrome or Internet Exlorer browser
    public void openBrowser(String browser){

        if(browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            //chromedriver-2.35 version
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver-2.35.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            //IEdriver-3.4 version
            System.setProperty("webdriver.ie.driver", "C:\\Soft\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else
        {
            System.out.println("Invalid browser name typed");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
