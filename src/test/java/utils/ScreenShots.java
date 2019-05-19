package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class ScreenShots {

    public  ScreenShots(WebDriver driver, String ScreenShotName){
        Calendar calendario = Calendar.getInstance();
        TakesScreenshot pic = (TakesScreenshot)driver;
        File Captura = pic.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(Captura, new File("./ScreenShot/"+ScreenShotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
