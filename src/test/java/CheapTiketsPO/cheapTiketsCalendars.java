package CheapTiketsPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class cheapTiketsCalendars {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.CLASS_NAME, using = "datepicker-cal-dates")
    private List<WebElement> calendars;

    public cheapTiketsCalendars(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(this.driver,this);
    }

    public void setCalendarDay(int day){
        WebElement dayOfTrip = calendars.get(0);
        WebElement daySelected = dayOfTrip.findElement(By.cssSelector("button[data-day='"+ day+"']"));
        daySelected.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

}
