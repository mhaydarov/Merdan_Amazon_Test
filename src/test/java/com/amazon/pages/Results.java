package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Results extends BasePage{

    @FindBy(xpath = "//*[@cel_widget_id = \"UPPER-RESULT_INFO_BAR-0\"]")
    public WebElement resultsInfoBar;

    @FindBy(xpath = "//*[@data-index=\"3\"]//*[@class=\"s-image\"]")
    public WebElement productItem;



}
