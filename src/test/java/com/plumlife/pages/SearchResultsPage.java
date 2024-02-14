package com.plumlife.pages;

import com.plumlife.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends HomePage {
    public SearchResultsPage(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "/html/body/section[2]/div[2]/div[1]/div/div/div/div[1]/p")
    public WebElement listing;

    @FindBy(id = "property-location")
    public WebElement propertyLocation;

    @FindBy(id = "no-of-bedrooms")
    public WebElement NumberOfBedrooms;
}
