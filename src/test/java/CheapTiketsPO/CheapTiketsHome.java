package CheapTiketsPO;

import cheapTiketsTest.resultsStrToInt;
import com.sun.corba.se.impl.transport.ByteBufferPoolImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheapTiketsHome {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.ID,using = "primary-header-hotel")
    private WebElement hotelLink;

    @FindBy(how = How.ID,using = "hotel-destination-hlp")
    private WebElement goingToDestination;

    @FindBy(how = How.ID,using = "hotel-checkin-hlp")
    private WebElement checkInDate;

    @FindBy(how = How.ID,using = "hotel-checkout-hlp")
    private WebElement checkOutDate;

    @FindBy(how = How.ID,using = "hotel-1-adults-hlp")
    private WebElement adultsLbl;

    @FindBy(how = How.ID,using = "hotel-1-children-hlp")
    private WebElement childrenLbl;

    @FindBy(how = How.ID,using = "hotel-1-age-select-1-hlp")
    private WebElement childrenAge;

    @FindBy(how = How.CLASS_NAME,using = "gcw-submit")
    private WebElement searchButton;



    public CheapTiketsHome(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(this.driver,this);
    }

    public void hotelLinkClick(){
        this.hotelLink.click();
    }

    public void goingToDestination(String Destination){
        this.goingToDestination.clear();
        this.goingToDestination.sendKeys(Destination);
    }

    public void checkInDate(String DateIn){
        this.checkInDate.clear();
        this.checkInDate.sendKeys(DateIn);
    }

    public void checkOutDate(String DateOut){
        this.checkOutDate.sendKeys(DateOut);
    }

    public void AdultBox(String Adults){
        this.adultsLbl.sendKeys(Adults);
    }

    public void ChildrenBoxAndAge(String Children,String Age){
        Select dropChildren =  new Select(childrenLbl);
        dropChildren.selectByValue(Children);
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Select dropAge =  new Select(childrenAge);
        dropAge.selectByValue(Age);
    }

    public void clickSearchButton(){
        searchButton.click();
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void clickCheckIn(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        this.checkInDate.sendKeys("0");
    }

    public void clickCheckOut(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        this.checkOutDate.sendKeys("0");
    }


}
