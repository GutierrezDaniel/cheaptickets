package CheapTiketsPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.concurrent.TimeUnit;

public class cheapTiketsResults extends BasePage {

    @FindBy(how = How.ID,using = "inpHotelNameMirror")
    private WebElement searchByProperty;

    @FindBy(how = How.ID,using = "hotelNameGoBtn")
    private WebElement byPropertyGoBtn;

    @FindBy(how = How.CLASS_NAME, using = "section-header-main")
    private WebElement hotelResultsTitle;

    @FindBy(how = How.ID,using = "aria-option-0")
    private WebElement sugestHotel;

    @FindBy(how = How.CSS,using = "div.flex-area-primary ul.hotel-info li.hotelTitle h4.hotelName")
    private WebElement checkCity;

    public cheapTiketsResults(WebDriver driver){
        super(driver);
    }

    public void SearchByProperty(String SearchProperty){

        this.searchByProperty.click();
        super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.searchByProperty.sendKeys(SearchProperty);
        this.byPropertyGoBtn.click();

    }

    public void SearchByPropertyShort(String SearchProperty){
        this.searchByProperty.click();
        super.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.searchByProperty.sendKeys(SearchProperty);
        this.sugestHotel.click();
        this.byPropertyGoBtn.click();
    }


    public WebElement getHotelResultsTitle() {
        return hotelResultsTitle;
    }

    public WebElement getCheckCity() {
        return checkCity;
    }
}
