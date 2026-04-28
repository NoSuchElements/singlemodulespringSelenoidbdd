package com.nosuchelements.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.pages.GooglePage;
import com.nosuchelements.pages.SauceDemoPage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Web Test Step Definitions
 */
public class WebStepDefinitions {

    @Autowired
    private GooglePage googlePage;

    @Autowired
    private SauceDemoPage sauceDemoPage;

    // Google Steps
    @Given("I open Google homepage")
    public void iOpenGoogleHomepage() throws Exception {
    	System.out.println("openening google");
        googlePage.open();
    }

    @Given("Print Hello For Test")
    public void hello() throws Exception {
    	System.out.println("Hellooooooooo");
        googlePage.open();
        
    }
    
    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        googlePage.searchFor(searchTerm);
    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        assertTrue(googlePage.areResultsDisplayed(), "Search results are not displayed");
    }

    @Then("page title should contain {string}")
    public void pageTitleShouldContain(String expectedText) {
        assertTrue(googlePage.titleContains(expectedText), 
            "Page title does not contain: " + expectedText);
    }

    // SauceDemo Steps
    @Given("I open SauceDemo login page")
    public void iOpenSauceDemoLoginPage() {
        sauceDemoPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        sauceDemoPage.login(username, password);
    }

    @Then("inventory page should be displayed")
    public void inventoryPageShouldBeDisplayed() {
        assertTrue(sauceDemoPage.isInventoryPageDisplayed(), 
            "Inventory page is not displayed");
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        assertTrue(sauceDemoPage.isErrorMessageDisplayed(), 
            "Error message is not displayed");
    }

    @Then("error message should contain {string}")
    public void errorMessageShouldContain(String expectedText) {
        String actualMessage = sauceDemoPage.getErrorMessageText();
        assertTrue(actualMessage.contains(expectedText), 
            "Error message does not contain expected text");
    }

    @Then("{int} products should be displayed")
    public void productsShouldBeDisplayed(int expectedCount) {
        int actualCount = sauceDemoPage.getInventoryItemsCount();
        assertEquals(expectedCount, actualCount, 
            "Product count does not match");
    }

    @When("I add first item to cart")
    public void iAddFirstItemToCart() {
        sauceDemoPage.addFirstItemToCart();
    }

    @Then("cart badge should show {string}")
    public void cartBadgeShouldShow(String expectedCount) {
        String actualCount = sauceDemoPage.getCartBadgeCount();
        assertEquals(expectedCount, actualCount, 
            "Cart badge count does not match");
    }
}
