package com.plumlife.stepDefinitions;

import com.plumlife.pages.HomePage;
import com.plumlife.pages.SearchResultsPage;
import com.plumlife.utilities.BrowserUtils;
import com.plumlife.utilities.ConfigurationReader;
import com.plumlife.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertTrue;

public class Steps {
    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();

    @Given("user is on home page")
    public void user_is_on_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user searches properties in {string}")
    public void user_searches_properties_in(String location)  {
        homePage.acceptAllCokies.click();
        homePage.searchField.sendKeys(location);
        BrowserUtils.waitFor(2);
        homePage.search.click();
        BrowserUtils.waitFor(2);
    }

    @Then("user gets properties in {string}")
    public void user_gets_properties_in(String location) {
        js.executeScript("window.scrollBy(0, 400)");
        assertTrue(searchResultsPage.listing.getText().contains(location));
    }

    @When("user searches properties in {string} with {string} bedrooms")
    public void user_searches_properties_in_with_bedrooms(String location, String numberOfRooms)  {
        homePage.acceptAllCokies.click();
        BrowserUtils.waitFor(2);
        homePage.clickAddDetails();
        BrowserUtils.waitFor(2);
        js.executeScript("window.scrollBy(0, 400)");
        homePage.numberOfBedrooms.click();
        homePage.selectNumberOfBedrooms(numberOfRooms);
        BrowserUtils.waitFor(2);
        homePage.searchField.sendKeys(location);
        BrowserUtils.waitFor(2);
        homePage.search.click();
        BrowserUtils.waitFor(2);
    }

    @Then("user gets properties in {string} with {string} bedrooms")
    public void user_gets_properties_in_with_bedrooms(String location, String numberOfRooms)  {
        js.executeScript("window.scrollBy(0, 400)");
        BrowserUtils.waitFor(2);
        assertTrue(searchResultsPage.propertyLocation.getAttribute("value").contains(location));
        assertTrue(searchResultsPage.NumberOfBedrooms.getAttribute("value").contains(numberOfRooms));
    }
}



