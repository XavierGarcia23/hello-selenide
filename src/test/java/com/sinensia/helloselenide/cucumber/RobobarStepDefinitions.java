package com.sinensia.helloselenide.cucumber;

import com.sinensia.helloselenide.CartPage;
import com.sinensia.helloselenide.CheckoutPage;
import com.sinensia.helloselenide.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderPage orderPage;

    @Given("user opens robobar website")
    public void userOpensRobobarWebsite() {
        open("http://localhost:3000");
        cartPage = new CartPage();
    }

    @When("user adds a cola")
    public void userAddACola() {
        cartPage.addCola();
    }

    @When("user adds a beer")
    public void userAddsABeer() {
        cartPage.addBeer();
    }

    @When("user adds a wine")
    public void userAddsAWine() {
        cartPage.addWine();
    }

    @Then("total should be €{double}")
    public void totalShouldBe(Double total) {
        cartPage.getTotal().shouldBe(exactText(String.format("€%.2f", total)));
    }

    @Then("total should be {string}")
    public void totalShouldBe(String total) {
        cartPage.getTotal().shouldBe(exactText(total));
    }

    @When("user press submit button")
    public void userPressSubmitButton() {
        cartPage.checkout();
        checkoutPage = new CheckoutPage();
    }

    @When("user enter her age is {int}")
    public void userEnterHerAgeIs(int arg0) {
        checkoutPage.setAge("17");
    }

    @When("user press order button")
    public void userPressOrderButton() {
        checkoutPage.order();
        orderPage = new OrderPage();
    }

    @Then("alert is active")
    public void alertIsActive() {
        orderPage.getAlertDiv().shouldNotBe(hidden);
    }
}
