package FirstCucumberPageObjectModel;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs extends Utils {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    AppleMacBookProPage appleMacBookProPage = new AppleMacBookProPage();
    ProductEmailAFriendPage productEmailAFriendPage = new ProductEmailAFriendPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    OnePageCheckOutPage onePageCheckOutPage = new OnePageCheckOutPage();
    CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();
    BooksPage booksPage = new BooksPage();
    CheckOutAsUserPage checkOutAsUserPage = new CheckOutAsUserPage();
    BasePage basePage = new BooksPage();

    @Given("^user is on homepage$")
    public void userIsOnHomepage() {
        homePage.verifyUserIsOnHomePage();
    }

    @And("^user clicks on register button$")
    public void userClicksOnRegisterButton() {
        homePage.clickOnRegisterButton();
    }

    @When("^user enters registration details and click on register$")
    public void userEntersRegistrationDetailsAndClickOnRegister() {
        registrationPage.verifyUserIsOnRegistrationPage();
        registrationPage.userEnterRegistrationDetails();
    }

    @Then("^user should be able to register successfully and see success message\\.$")
    public void userShouldBeAbleToRegisterSuccessfullyAndSeeSuccessMessage() {
        registrationResultPage.verifyUserIsOnRegistrationSuccessPage();
        registrationResultPage.verifySuccessMessage();
        registrationResultPage.userClickOnContinueButton();
    }

    @Given("^user is registered$")
    public void userIsRegistered() {
        homePage.clickOnRegisterButton();
        registrationPage.verifyUserIsOnRegistrationPage();
        registrationPage.userEnterRegistrationDetails();
        registrationResultPage.verifyUserIsOnRegistrationSuccessPage();
        registrationResultPage.verifySuccessMessage();
        registrationResultPage.userClickOnContinueButton();
    }

    @When("^user chooses product to refer a friend$")
    public void userChoosesProductToReferAFriend() {
        homePage.verifyUserIsOnHomePage();
        homePage.userChooseProductToReferAFriend();
        appleMacBookProPage.verifyUserIsOnAppleMacBookPage();
    }

    @And("^user fills referral details$")
    public void userFillsReferralDetails() {
        appleMacBookProPage.referProductToFriendAsARegisteredUser();
    }

    @Then("^user should see message of successful referral$")
    public void userShouldSeeMessageOfSuccessfulReferral() {
        productEmailAFriendPage.verifyUserIsOnProductEmailAFriendPage();
        productEmailAFriendPage.verifyProductRefferalSuccessMessage();
    }

    @Then("^user should see failure referral message$")
    public void userShouldSeeFailureReferralMessage() {
        productEmailAFriendPage.verifyUserIsOnProductEmailAFriendPage();
        productEmailAFriendPage.verifyProductRefferalFailureMessage();
    }


    @And("^user fills referral details as a guest$")
    public void userFillsReferralDetailsAsAGuest() {
        appleMacBookProPage.referProductToFriendAsaGuest();
    }

    @When("^user chooses a product to to add into Shopping Cart$")
    public void userChoosesAProductToToAddIntoShoppingCart() {
        homePage.clickOnBooksButton();
        booksPage.userSelectBookToEnterInCart();
        shoppingCartPage.verifyUserIsOnShoppingCartPage();
        shoppingCartPage.verifyBookIsInShoppingCart();

    }

    @And("^user enters details of Shipping Estimate$")
    public void userEntersDetailsOfShippingEstimate() {
        shoppingCartPage.userEnterEstimateShipping();
    }

    @And("^user checkout the product$")
    public void userCheckoutTheProduct() {
        shoppingCartPage.userCheckoutProduct();
    }

    @And("^user enters details for checkout$")
    public void userEntersDetailsForCheckout() {
        onePageCheckOutPage.registeredUserEnterDetailsForCheckOut();
    }

    @Then("^user should see message of successful purchase$")
    public void userShouldSeeMessageOfSuccessfulPurchase() {
        checkOutCompletePage.verifyCheckoutSuccessMessage();
    }

    @And("^user again checkout the product as a guest$")
    public void userAgainCheckoutTheProductAsAGuest() {
        checkOutAsUserPage.verifyGuestWelComeMessage();
        checkOutAsUserPage.guestClickOnCheckoutAsGuest();
        onePageCheckOutPage.verifyUserIsOnOnePageCheckoutPage();
    }

    @And("^user enters details for guest checkout$")
    public void userEntersDetailsForGuestCheckout() {
        onePageCheckOutPage.guestUserEnterDetails();
    }

    @When("^user chooses a \"([^\"]*)\"$")
    public void userChoosesA(String category) {
        homePage.userClickOnCategory(category);
    }

    @Then("^user should navigate to \"([^\"]*)\" successfully$")
    public void userShouldNavigateToSuccessfully(String related_category_page) {
        assertURL(related_category_page);

    }
}
