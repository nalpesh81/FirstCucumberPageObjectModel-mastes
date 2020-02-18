package FirstCucumberPageObjectModel;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductEmailAFriendPage extends Utils {
    LoadProps loadProps = new LoadProps();
    private By _actualfailureMsg = By.xpath("//*[text()='Only registered customers can use email a friend feature']");
    private By _actualsuccessMsg = By.xpath("//div[@class='result']  ");

    public void verifyUserIsOnProductEmailAFriendPage() {
        assertURL(props.getProperty("productemailafriendpage"));
    }

    public void verifyProductRefferalFailureMessage() {
        String actualrefermsg = getTextFromElement(_actualfailureMsg);
        Assert.assertEquals(actualrefermsg, "Only registered customers can use email a friend feature");
    }

    public void verifyProductRefferalSuccessMessage() {
        String actualrefermsg = getTextFromElement(_actualsuccessMsg);
        Assert.assertEquals(actualrefermsg, "Your message has been sent.");
    }
}
