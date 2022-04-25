package test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://github.com/dungltk96");

        // DEBUG PURPOSE ONLY
        Thread.sleep(3000);

        // Quit session
        driver.quit();
    }
}

