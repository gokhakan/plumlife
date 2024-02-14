package com.plumlife.pages;

import com.plumlife.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id = "property-location")
    public WebElement searchField;

    @FindBy (xpath = "//*[@id=\"property-search-form\"]/div/button")
    public WebElement search;

    @FindBy (id = "wt-cli-accept-all-btn")
    public WebElement acceptAllCokies;

    @FindBy(id = "property-found-num")
    public WebElement listing;

}
