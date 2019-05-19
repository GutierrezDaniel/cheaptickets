package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {

    public  ScreenShots(WebDriver driver, String ScreenShotName){
        TakesScreenshot pic = (TakesScreenshot)driver;
        File Captura = pic.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(Captura, new File("./ScreenShot/"+ScreenShotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
