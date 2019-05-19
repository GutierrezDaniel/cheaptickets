package cheapTiketsTest;

import CheapTiketsPO.CheapTiketsHome;
import CheapTiketsPO.cheapTiketsCalendars;
import CheapTiketsPO.cheapTiketsResults;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ScreenShots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class cheapTiketsTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private CheapTiketsHome CheapTikets;
    private cheapTiketsResults CheapTktRes;
    private cheapTiketsCalendars Calendars;

    /* -----------------------------------------------  */
    private String URL = "https://www.cheaptickets.com";
    private String Destination = "Miami Beach";
    private String CheckInDate = "05/22/2019";
    private String CheckOutDate = "05/23/2019";
    private String Adults = "4";
    private String Children = "1";
    private String ChildrenAge = "7";
    private String HotelName = "Faena Hotel Miami Beach";
    private String ScreenShot = "CheckAssert1";
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
        this.CheapTikets = new CheapTiketsHome(this.driver);
        this.CheapTktRes = new cheapTiketsResults(this.driver);
        this.Calendars = new cheapTiketsCalendars(this.driver);

        CheapTikets.hotelLinkClick();
        CheapTikets.goingToDestination(Destination);
        //CheapTikets.checkInDate(CheckInDate); -------- Sin Bonus
        CheapTikets.clickCheckIn();
        Calendars.setCalendarDay(21);
        CheapTikets.clickCheckOut();
        Calendars.setCalendarDay(22);
        //CheapTikets.checkOutDate(CheckOutDate); -------- Sin Bonus
        CheapTikets.AdultBox(Adults);
        CheapTikets.ChildrenBoxAndAge(Children,ChildrenAge);
        CheapTikets.clickSearchButton();
        CheapTktRes.SearchByProperty(HotelName);

        Assert.assertTrue(checkResultsHotels());
        Assert.assertTrue(checkValidResults(this.Destination));
        ScreenShots ScreenShot = new ScreenShots(this.driver,this.ScreenShot);

    }

    @AfterTest
    public void closeBrowser(){
        this.driver.close();
    }

    public boolean checkResultsHotels(){
        resultsStrToInt checkResult;
        String ResultsHotel;
        int nmbResult = 0;
        boolean valReturn;
        ResultsHotel = CheapTktRes.getHotelResultsTitle().getText();
        checkResult = new resultsStrToInt();
        nmbResult = checkResult.stringToInt(ResultsHotel);
        System.out.println("Resultado String: "+ResultsHotel+ "Results int: "+nmbResult);
        if(nmbResult >= 1){valReturn = true;}else{valReturn = false;}
        return valReturn;
    }

    public boolean checkValidResults(String Destination){
        Boolean result;
        String City = CheapTktRes.getCheckCity().getText();
        System.out.println("Se valida por Resultado texto: "+City);
        result = City.toLowerCase().contains(Destination.toLowerCase());
        return result;
    }

}
