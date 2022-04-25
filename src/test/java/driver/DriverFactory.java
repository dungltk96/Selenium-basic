package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String currentProjectLocation = System.getProperty("user.dir");
        String macOSChromePath = "/src/test/resources/drivers/chromedriver";
        String windowsChromePath = "\\src\\test\\resources\\drivers\\chromedriver.exe";
        String relativeChromeDriverLocation = OS.isFamilyMac() ? macOSChromePath : windowsChromePath;

        String chromeDriverPath = currentProjectLocation + relativeChromeDriverLocation;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));

        return driver;
    }
}
