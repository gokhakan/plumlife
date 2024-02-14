package com.plumlife.pages;

import com.plumlife.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "detailed-filters-btn")
    public WebElement addDetails;

    @FindBy(id = "no-of-bedrooms")
    public WebElement numberOfBedrooms;

    public void clickAddDetails(){
        addDetails.click();
    }

    public void selectNumberOfBedrooms(String numberOfBedrooms){
        WebElement dropdownElement = Driver.get().findElement(By.id("no-of-bedrooms"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(Integer.parseInt(numberOfBedrooms));
    }

}
