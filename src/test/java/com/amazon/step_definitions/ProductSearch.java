package com.amazon.step_definitions;

import com.amazon.pages.*;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.amazon.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSearch {

    Login login = new Login();
    Results results = new Results();
    Basket basket = new Basket();
    Product product = new Product();

    String itemText;

    Map<String,Double> basketMap = new HashMap<>();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        login.loginNavLink.click();

    }


    @When("user login with valid credentials")
    public void user_login_with_valid_credentials() {

        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        login.usernameInput.sendKeys(username);
        login.continueButton.click();

        login.passwordInput.sendKeys(password);
        login.submitButton.click();

        Utils.waitFor(1);
    }

    @When("user types {string} though the top search field")
    public void user_types_though_the_top_search_field(String searchItem) {

        HomePage homePage = new HomePage();
        homePage.searchInput.sendKeys(searchItem);
        homePage.searchInput.sendKeys(Keys.ENTER);

        Utils.waitFor(1);

    }
    @Then("user sees the results page for {string}")
    public void user_sees_the_results_page_for(String searchItem) {

        Assert.assertTrue(results.resultsInfoBar.getText().contains(searchItem));

        Utils.waitFor(1);


    }


    @When("user clicks on product number {int} from the list and adds it to basket")
    public void user_clicks_on_product_number_from_the_list_and_adds_it_to_basket(int item) {

        WebElement productItem = Driver.get().findElement(By.xpath("//*[@data-component-type=\"s-search-result\"]["+item+"]//span[contains(@class, \"a-text-normal\")]"));

        itemText = productItem.getText();
        System.out.println("Selected item: " + itemText);
        System.out.println("------------------------------------------------");

        productItem.click();
        Utils.waitFor(2);

        product.addToCartBtn.click();
        Utils.waitFor(2);

        try {
            product.oneTimePurchase.click();
        } catch (NoSuchElementException e) {}

        Utils.waitFor(2);

        try {
            product.noCoverage.click();
            product.noCoverageCloseBtn.click();
        } catch (NoSuchElementException e) {}

        Utils.waitFor(2);
        //product.basketButtonSide.click();
        basket.basketBtn.click();

        Utils.waitFor(2);


    }

    @Then("user sees basket containing the product")
    public void user_sees_basket_containing_the_product() {

        int count=1;

        List<WebElement> basketItems = basket.basketItems;

        List<WebElement> basketItemsCostsWhole = basket.basketItemsCostWhole;

        List<WebElement> basketItemsCostsFraction = basket.basketItemsCostFraction;

        List<String> basketItemsList = new ArrayList<>();
        List<String> basketItemsCostsFull = new ArrayList<>();

        System.out.println("Basket Items:");

        Utils.waitFor(2);

//        for(int i=0; i<basketItems.size(); i++){
//            basketItemsList.add(basketItems.get(i).getText());
//            basketItemsCostsFull.add(basketItemsCostsWhole.get(i).getText()+"."+basketItemsCostsFraction.get(i).getText());
//            System.out.println("Item "+count+" - "+basketItemsList.get(i)+" = £"+basketItemsCostsFull.get(i));
//            count++;
//        }

        for (int i = 0; i < basketItems.size(); i++) {
            basketMap.put(basketItems.get(i).getText(), Double.valueOf(basketItemsCostsWhole.get(i).getText().replace(",","") +"."+ basketItemsCostsFraction.get(i).getText()));
        }




        Boolean itemListed=false;

        if(basketMap.containsKey(itemText)){
            itemListed = true;
        }

//        for (WebElement el: basketItems) {
//            if(el.getText().equals(itemText)){
//                itemListed = true;
//                break;
//            }
//        }

//        Assert.assertTrue(itemListed);
        Assert.assertTrue(basketMap.containsKey(itemText));


//        for (int i = 0; i < basketItems.size(); i++) {
//            basketMap.put(basketItemsList.get(i), Double.valueOf(basketItemsCostsFull.get(i).replace(",","")));
//        }

        Utils.waitFor(2);

    }



    @When("user increases product quantity by {int} the subtotal changes accordingly")
    public void user_increases_product_quantity_by_the_subtotal_changes_accordingly(int quantity) {

        basketMap.toString();
        System.out.println("basketMap.get(itemText) = " + basketMap.get(itemText));
        basket.quantityBtn.click();

//        WebElement quantityNumber = Driver.get().findElement(By.cssSelector("[id=quantity_3]"));
//        quantityNumber.click();



    }

}
