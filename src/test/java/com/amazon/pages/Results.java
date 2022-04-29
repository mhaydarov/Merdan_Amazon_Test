package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Results extends BasePage{

    @FindBy(xpath = "//*[@cel_widget_id = \"UPPER-RESULT_INFO_BAR-0\"]")
    public WebElement resultsInfoBar;

}
