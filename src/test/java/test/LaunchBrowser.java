package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        String currentProjectLocation = System.getProperty("user.dir");
        String relativeChromeDriverLocation = "\\src\\test\\resources\\drivers\\chromedriver.exe";
        String chromeDriverPath = currentProjectLocation + relativeChromeDriverLocation;
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/dungltk96");

        Thread.sleep(3000);
        driver.quit();
    }
}

