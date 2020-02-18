package FirstCucumberPageObjectModel;

import org.openqa.selenium.By;

public class BooksPage extends Utils {
    LoadProps loadProps = new LoadProps();
    private By _firstPrizePiesBook = By.linkText("First Prize Pies");
    private By _firstPrizePiesBookAddToCart = By.xpath("//input[@id='add-to-cart-button-38']");
    private By _shoppingCartButton = By.xpath("//span[@class='cart-label' and text()='Shopping cart']");
    private By _greenBarNotificationCloseButton = By.xpath("//span[@class='close']");

    public void verifyUserIsOnBooksPage() {
        assertURL(props.getProperty("bookspageurl"));
    }

    public void userSelectBookToEnterInCart() {
        clickElement(_firstPrizePiesBook);
        clickElement(_firstPrizePiesBookAddToCart);
        try {
            waitForElementClickable(_greenBarNotificationCloseButton, 10);
            clickElement(_greenBarNotificationCloseButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        waitForElementInvisible(By.xpath("//*[@class=\"content\"]"), 10);
        waitForElementVisible(_shoppingCartButton, 10);
        clickElement(_shoppingCartButton);
    }
}
