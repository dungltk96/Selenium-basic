package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            // Checkbox form interaction
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));

            if (!checkboxElem.isSelected()){
                checkboxElem.click();
            }

            // Input form interaction
            WebElement inputFormElem = driver.findElement(inputFormSel);
            By inputEleSel = By.tagName("input");
            WebElement inputElem = inputFormElem.findElement(inputEleSel);
            WebElement inputButtonElem = inputFormElem.findElement(By.tagName("button"));

            if (!inputElem.isEnabled()){
                inputButtonElem.click();
            }

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            // invisibilityOf: Chờ loading khi nào không còn xuất hiện nữa thì mới sendKeys
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
//            wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loading")));
            inputElem.sendKeys("=========TOBE CONTINUE========");

            // DEBUG PURPOSE ONLY
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
