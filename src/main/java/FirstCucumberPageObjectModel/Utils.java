package FirstCucumberPageObjectModel;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    LoadProps props = new LoadProps();

    //This code will generate date stamp.
    public static String dateStamp() {
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyhhmmss");
        return format.format(new Date());
    }

    // (4)this method is for web driver to wait until the clickable element is present explicit wait
    public static void waitForElementClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // (5)this method is for web driver to wait until the  element is visible
    public static void waitForElementVisible(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // this method is for web driver to wait until the web element disappear
    public static void waitForElementInvisible(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    // this method is for web driver to wait until part of url visible
    public static void waitForpartOfURL(long time, String urltext) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.urlContains(urltext));
    }

    // this method is to get the screenshot
    public void takeScreenshot(String filename) {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Call getScreenshot As method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile = new File("src\\test\\Resources\\Screenshots" + filename + dateStamp() + ".png");

        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //to quite the driver
    public void quiteDriver() {
        driver.quit();
    }

    //select from dropdown by visible text
    public void dropDownSelectionByVisibleText(By by, String text) {
        Select drpDate = new Select(driver.findElement(by));
        drpDate.selectByVisibleText(text);
    }

    //this method is to click on element
    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    //this method is to enter the text at element
    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //this method is to get text as a return from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // this method is to verify user is on required URL.
    public void assertURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    // this method is to verify user is on required page by contains text in URL
    public void assertURLText(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    public void assertMessage(String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    //this method is to check whether the alert is present or not
    public boolean isAlertPresent() {
        boolean present = false;
        try {
            // driver checks the presence of alert
            Alert alert = driver.switchTo().alert();
            //if alert present then set the flag
            present = true;
            // if alert is present then consume the alert
            alert.accept();
        } catch (NoAlertPresentException exc) {
            // print out alert not present
            exc.printStackTrace();
        }
        return present;
    }

}
