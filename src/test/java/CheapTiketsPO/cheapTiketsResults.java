package CheapTiketsPO;

import cheapTiketsTest.resultsStrToInt;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class cheapTiketsResults {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.ID,using = "inpHotelNameMirror")
    private WebElement searchByProperty;

    @FindBy(how = How.ID,using = "hotelNameGoBtn")
    private WebElement byPropertyGoBtn;

    @FindBy(how = How.CLASS_NAME, using = "section-header-main")
    private WebElement hotelResultsTitle;

    @FindBy(how = How.CSS,using = "div.flex-area-primary ul.hotel-info li.hotelTitle h4.hotelName")
    private WebElement checkCity;

    public cheapTiketsResults(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(this.driver,this);
    }

    public void SearchByProperty(String SearchProperty){

        this.searchByProperty.click();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.searchByProperty.sendKeys(SearchProperty);
        this.byPropertyGoBtn.click();

    }


    public boolean checkResultsHotels(){
        resultsStrToInt checkResult;
        String ResultsHotel;
        int nmbResult = 0;
        boolean valReturn;
        ResultsHotel = hotelResultsTitle.getText();
        checkResult = new resultsStrToInt();
        nmbResult = checkResult.stringToInt(ResultsHotel);
        System.out.println("Resultado String: "+ResultsHotel+ "Results int: "+nmbResult);
        if(nmbResult >= 1){valReturn = true;}else{valReturn = false;}
        return valReturn;
    }

    public boolean checkValidResults(String Destination){
        Boolean result;
        String City = this.checkCity.getText();
        System.out.println("Se valida por Resultado texto: "+City);
        result = City.toLowerCase().contains(Destination.toLowerCase());
        return result;
    }

}
