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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheapTiketsHome {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH,using = "//*[@id=\"primary-header-hotel\"]")
    private WebElement hotelLink;

    @FindBy(how = How.XPATH,using = "//*[@id=\"hotel-destination-hlp\"]")
    private WebElement goingToDestination;

    @FindBy(how = How.XPATH,using = "//*[@id=\"hotel-checkin-hlp\"]")
    private WebElement checkInDate;

    @FindBy(how = How.XPATH,using = "//*[@id=\"hotel-checkout-hlp\"]")
    private WebElement checkOutDate;

    @FindBy(how = How.XPATH,using = "//*[@id=\"hotel-1-adults-hlp\"]")
    private WebElement adultsLbl;

    @FindBy(how = How.XPATH,using = "//*[@id=\"hotel-1-children-hlp\"]")
    private WebElement childrenLbl;

    @FindBy(how = How.XPATH,using = "//*[@id=\"hotel-1-age-select-1-hlp\"]")
    private WebElement childrenAge;

    @FindBy(how = How.XPATH,using = "//*[@id=\"gcw-hotel-form-hlp\"]/div[8]/label/button")
    private WebElement searchButton;


    /*  WebElements De Pagina de resultados     */

    @FindBy(how = How.ID,using = "inpHotelNameMirror")
    private WebElement searchByProperty;

    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div/div/header/section[1]/div/input")
    private WebElement popEnterProperty;

    @FindBy(how = How.ID,using = "hotelNameGoBtn")
    private WebElement byPropertyGoBtn;

    @FindBy(how = How.CLASS_NAME, using = "section-header-main")
    private WebElement hotelResultsTitle;

    @FindBy(how = How.CSS,using = "div.flex-area-primary ul.hotel-info li.hotelTitle h4.hotelName")
    private WebElement checkCity;


    public CheapTiketsHome(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
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
        //this.checkOutDate.clear();
        this.checkOutDate.sendKeys(DateOut);
    }

    public void AdultBox(String Adults){
        this.adultsLbl.sendKeys(Adults);
    }

    public void ChildrenBoxAndAge(String Children,String Age){
        Select dropChildren =  new Select(childrenLbl);
        dropChildren.selectByValue(Children);
        //this.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hotel-1-age-select-1-hp-hotel")));
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Select dropAge =  new Select(childrenAge);
        dropAge.selectByValue(Age);
    }

    public void clickSearchButton(){
        searchButton.click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/main/div/div")));
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    // metodo de la pagina de resultados
    public void SearchByProperty(String SearchProperty){

        /* Realiza un Scroll en busca del elemento /
            WebElement ScrProperty = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/main/div/div/div[1]/section/div[2]/form/fieldset[1]/div/div/div[6]/div/label"));
            Actions actions = new Actions(driver);
            actions.moveToElement(ScrProperty);
            actions.perform();
        WebElement Scroll = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/header/section/div"));
        for(int i = 0; i < 10; i++){
            Scroll.sendKeys(Keys.PAGE_DOWN);
        }*/
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
        result = City.toLowerCase().contains(Destination.toLowerCase());
        return result;
    }








}
