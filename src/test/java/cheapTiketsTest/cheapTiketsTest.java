package cheapTiketsTest;

import CheapTiketsPO.CheapTiketsHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class cheapTiketsTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private CheapTiketsHome CheapTikets;

    /* -----------------------------------------------  */
    private String URL = "https://www.cheaptickets.com";
    private String Destination = "Miami Beach";
    private String CheckInDate = "05/22/2019";
    private String CheckOutDate = "05/23/2019";
    private String Adults = "4";
    private String Children = "1";
    private String ChildrenAge = "7";
    private String HotelName = "Faena Hotel Miami Beach";
    /* -----------------------------------------------  */


    @BeforeTest
    public void openBrowser(){
        this.driver = new FirefoxDriver();
        this.wait = new WebDriverWait(this.driver,10);
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void cheapTiketsTest(){
        this.CheapTikets = PageFactory.initElements(this.driver,CheapTiketsHome.class);
        CheapTikets.hotelLinkClick();
        CheapTikets.goingToDestination(Destination);
        CheapTikets.checkInDate(CheckInDate);
        CheapTikets.checkOutDate(CheckOutDate);
        CheapTikets.AdultBox(Adults);
        CheapTikets.ChildrenBoxAndAge(Children,ChildrenAge);
        CheapTikets.clickSearchButton();
        CheapTikets.SearchByProperty(HotelName);

        Assert.assertTrue(CheapTikets.checkResultsHotels());
        Assert.assertTrue(CheapTikets.checkValidResults(this.Destination));


    }

    @AfterTest
    public void closeBrowser(){
        this.driver.close();
    }
}
