package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product extends BasePage{

    @FindBy (xpath = "//*[@id=\"submit.add-to-cart\"]//*[@class=\"a-button-inner\"]")
    public WebElement addToCartBtn;

    @FindBy (css = "[id=attach-sidesheet-view-cart-button]")
    public WebElement basketButtonSide;

    @FindBy (xpath = "\"//*[@class=\"a-icon a-accordion-radio a-icon-radio-inactive\"]\"")
    public WebElement oneTimePurchase;

    @FindBy (id = "attachSiNoCoverage")
    public WebElement noCoverage;

    @FindBy (css = "[id=\"attach-close_sideSheet-link\"]")
    public WebElement noCoverageCloseBtn;


}
