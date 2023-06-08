package hu.masterfield;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {
    private static int seq = 1;
    private static final String fileNamePrefix = "target/screenshots/screen_";

    public static void takeSnapShot(WebDriver webdriver) {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileNamePrefix + seq + ".png");
        System.out.println("Taking screenshot " + fileNamePrefix + seq + ".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        seq++;
    }
}
