package FirstCucumberPageObjectModel;

import org.openqa.selenium.By;

public class CheckOutAsUserPage extends Utils {
    LoadProps loadProps = new LoadProps();
    private By _checkoutAsGuestButton = By.xpath("//input[@class='button-1 checkout-as-guest-button']");

    public void verifyUserIsOnCheckOutAsUserPage() {
        waitForpartOfURL(500, "checkoutasguest");
        assertURL(props.getProperty("checkoutasguesturl"));
    }

    public void verifyGuestWelComeMessage() {
        try {
            waitForElementClickable(By.xpath("//*[text()='Welcome, Please Sign In!']"), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertMessage(props.getProperty("checkoutasguestwelcomemessage"), By.xpath("//*[text()='Welcome, Please Sign In!']"));
    }

    public void guestClickOnCheckoutAsGuest() {
        clickElement(_checkoutAsGuestButton);
    }
}
