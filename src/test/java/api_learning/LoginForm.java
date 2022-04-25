package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginForm {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define locators
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            // Find element
            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            // Interact with element
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            // On the next page
            printTitleAndUrl(driver);
            Thread.sleep(2000);

            // Find the h4 tag
//            By welcomeTextSel = By.cssSelector("h4");
            By welcomeTextSel = By.tagName("h4");
            WebElement welcomeTextEle = driver.findElement(welcomeTextSel);
            System.out.println("---> " + welcomeTextEle.getText());

            // Go back to the login page
            driver.navigate().back();
            printTitleAndUrl(driver);

            // Multiple matching element
            List<WebElement> loginInputFieldElements = driver.findElements(By.tagName("input"));
            if (loginInputFieldElements.isEmpty()){
                throw new RuntimeException("[ERR] There is no login from input fields!");
            }else {
                for (WebElement loginInputFieldElement : loginInputFieldElements) {
                    // Verification
                }
            }

            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;

            usernameElem = loginInputFieldElements.get(USERNAME_INDEX);
            usernameElem.clear();
            usernameElem.sendKeys("usernameFail");
            loginInputFieldElements.get(PASSWORD_INDEX).sendKeys("passFail");

            Thread.sleep(2000);
            loginBtnElem = driver.findElement(loginBtnSel);
            loginBtnElem.click();

            // Find the footer Powered by linkText
//            By poweredByLinkText = By.linkText("Elemental Selenium");
            By poweredByLinkText = By.partialLinkText("Elemental");
            WebElement poweredByLinkTextElem = driver.findElement(poweredByLinkText);
            System.out.println("PoweredBy LinK text: " + poweredByLinkTextElem.getText());

            // Get flat error msg
//            By loginMsgSel = By.className(".error");
            By loginMsgSel = By.cssSelector(".error");
            WebElement loginMsgElem = driver.findElement(loginMsgSel);
            String loginMsgBackgroundColor = loginMsgElem.getCssValue("background-color");
            System.out.println("Login msg background color: " + loginMsgBackgroundColor);

            System.out.println(loginMsgElem.getAttribute("class"));

            // Debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close driver session
            driver.quit();
        }
    }

    private static void printTitleAndUrl(WebDriver driver) {
        System.out.println("---> " + driver.getTitle());
        System.out.println("---> " + driver.getCurrentUrl());
    }
}
