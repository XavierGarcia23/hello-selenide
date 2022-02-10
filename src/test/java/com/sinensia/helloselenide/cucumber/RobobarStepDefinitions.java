package com.sinensia.helloselenide.cucumber;

import com.sinensia.helloselenide.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    CartPage cartPage;

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
}
