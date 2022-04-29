package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Basket extends BasePage{

    @FindBy(id = "nav-cart")
    public WebElement basketBtn;

    @FindBy(xpath = "//*[@class=\"a-truncate-cut\"]")
    public List<WebElement> basketItems;

    @FindBy(xpath = "//*[@class=\"sc-list-item-content\"]//*[@class=\"a-price-whole\"]")
    public List<WebElement> basketItemsCostWhole;

    @FindBy(xpath = "//*[@class=\"sc-list-item-content\"]//*[@class=\"a-price-fraction\"]")
    public List<WebElement> basketItemsCostFraction;

    @FindBy(xpath = "//*[@data-action=\"a-dropdown-button\"]")
    public WebElement quantityBtn;


}
