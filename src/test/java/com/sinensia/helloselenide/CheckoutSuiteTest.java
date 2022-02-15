package com.sinensia.helloselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class CheckoutSuiteTest {
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeAll
    public static void setUpAll() {
        //Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        //capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void setUp() {
        open("/");
    }

    @Test
    public void confirmationOrder() {
        cartPage.addCola();
        CheckoutPage checkoutPage = cartPage.checkout();
        //cartPage.checkoutButton();
        checkoutPage.textCheckoutPage.shouldBe(text("Order review"));
        checkoutPage.ageInput.shouldBe(disabled);
        checkoutPage.btnOrderConfirm.click();
    }

    @Test
    public void underCheckTest() {

    }

    @Test
    public void adultCheckTest() {

    }

    @Test
    public void ageTest() {
        cartPage.addBeer();
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.ageInput.shouldBe(hidden);//appear, visible
    }
}
