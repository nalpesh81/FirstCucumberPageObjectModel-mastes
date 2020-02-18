package FirstCucumberPageObjectModel;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utils {
    LoadProps loadProps = new LoadProps();
    private By _ckeckBoxTick = By.xpath("//input[@id='termsofservice']");
    private By _countryDropDown = By.xpath("//select[@class='country-input']");
    private By _zipOrPostCode = By.xpath("//input[@id='ZipPostalCode']");
    private By _estimateButton = By.xpath("//input[@id='estimate-shipping-button']");
    private By _checkoutButton = By.xpath("//button[@id='checkout']");

    public void verifyUserIsOnShoppingCartPage() {
        driver.navigate().refresh();
        waitForpartOfURL(10, "cart");
        assertURL(props.getProperty("shoppingcartpageurl"));
    }

    public void verifyBookIsInShoppingCart() {
        // This code check whether first book is on shopping cart page
        String expectedBook = getTextFromElement(By.xpath("//div[@class='table-wrapper']"));
        Assert.assertTrue(expectedBook.contains("First Prize Pies"));
    }

    public void userEnterEstimateShipping() {
        dropDownSelectionByVisibleText(_countryDropDown, "United Kingdom");
        enterText(_zipOrPostCode, "HA0 2LX");
        clickElement(_estimateButton);
    }

    public void userCheckoutProduct() {
        clickElement(_ckeckBoxTick);
        clickElement(_checkoutButton);
    }
}
