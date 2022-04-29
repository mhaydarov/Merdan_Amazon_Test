package com.amazon.step_definitions;

import com.amazon.pages.HomePage;
import com.amazon.pages.Login;
import com.amazon.pages.Results;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.amazon.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class ProductSearch {

    Login login = new Login();

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

        Utils.waitFor(2);
    }

    @When("user types {string} though the top search field")
    public void user_types_though_the_top_search_field(String searchItem) {

        HomePage homePage = new HomePage();
        homePage.searchInput.sendKeys(searchItem);
        homePage.searchInput.sendKeys(Keys.ENTER);

        Utils.waitFor(2);

    }
    @Then("user sees the results page for {string}")
    public void user_sees_the_results_page_for(String searchItem) {

        Results results = new Results();
        Assert.assertTrue(results.resultsInfoBar.getText().contains(searchItem));

        Utils.waitFor(2);


    }

}
