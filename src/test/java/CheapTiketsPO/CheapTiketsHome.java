package CheapTiketsPO;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class CheapTiketsHome extends BasePage {

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
        super(driver);
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
        super.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Select dropAge =  new Select(childrenAge);
        dropAge.selectByValue(Age);
    }

    public void clickSearchButton(){
        searchButton.click();
        super.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void clickCheckIn(){
        super.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        this.checkInDate.sendKeys("0");
    }

    public void clickCheckOut(){
        super.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        this.checkOutDate.sendKeys("0");
    }


}
