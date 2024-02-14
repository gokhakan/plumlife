package com.plumlife.stepDefinitions;

import com.plumlife.pages.HomePage;
import com.plumlife.pages.SearchResultsPage;
import com.plumlife.utilities.ConfigurationReader;
import com.plumlife.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Steps {
    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();


    Logger logger = Logger.getLogger(Steps.class.getName());
    List<WebElement> itemNames;
    List<WebElement> prices;

    @Given("user is on home page")
    public void user_is_on_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        logger.info("INFO: User is logging in");
    }

    @When("user searches properties in {string}")
    public void user_searches_properties_in(String location) throws InterruptedException {
        homePage.acceptAllCokies.click();
        homePage.searchField.sendKeys(location);
        Thread.sleep(2000);
        homePage.search.click();
        Thread.sleep(2000);

    }

    @Then("user gets properties in {string}")
    public void user_gets_properties_in(String location) {
        js.executeScript("window.scrollBy(0, 400)");

        Assert.assertTrue(searchResultsPage.listing.getText().contains(location));
    }

    @When("user searches properties in {string} with {string} bedrooms")
    public void user_searches_properties_in_with_bedrooms(String location, String numberOfRooms) throws InterruptedException {
        homePage.acceptAllCokies.click();
        Thread.sleep(2000);

        homePage.clickAddDetails();
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0, 400)");
homePage.numberOfBedrooms.click();
        homePage.selectNumberOfBedrooms(numberOfRooms);
        Thread.sleep(2000);

        homePage.searchField.sendKeys(location);
        Thread.sleep(2000);
        homePage.search.click();
        Thread.sleep(2000);


    }

    @Then("user gets properties in {string} with {string} bedrooms")
    public void user_gets_properties_in_with_bedrooms(String location, String numberOfRooms) throws InterruptedException {
        js.executeScript("window.scrollBy(0, 400)");
        Thread.sleep(2000);

        Assert.assertTrue(searchResultsPage.propertyLocation.getAttribute("value").contains(location));
        Assert.assertTrue(searchResultsPage.NumberOfBedrooms.getAttribute("value").contains(numberOfRooms));
    }
}



