package utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = "screenshots/" + fileName + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}

