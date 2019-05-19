package CheapTiketsPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class cheapTiketsCalendars extends BasePage{


    @FindBy(how = How.CLASS_NAME, using = "datepicker-cal-dates")
    private List<WebElement> calendars;

    public cheapTiketsCalendars(WebDriver driver){
        super(driver);
    }

    public void setCalendarDay(int day){
        WebElement dayOfTrip = calendars.get(0);
        WebElement daySelected = dayOfTrip.findElement(By.cssSelector("button[data-day='"+ day+"']"));
        daySelected.click();
        super.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

}
