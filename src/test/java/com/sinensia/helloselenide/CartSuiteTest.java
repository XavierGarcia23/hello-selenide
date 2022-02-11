package com.sinensia.helloselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Enabled;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartSuiteTest {
    CartPage cartPage = new CartPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://10.250.10.1:3000/");
    }

    @Test
    public void colaTest1() {
        cartPage.addCola();
        cartPage.getTotal().shouldBe(text("€1.25"));
    }

    @Test
    public void colaTest2() {
        cartPage.addCola();
        cartPage.addCola();
        cartPage.getTotal().shouldBe(text("€2.50"));
    }

    @Test
    public void beerTest1() {
        cartPage.addBeer();
        cartPage.getTotal().shouldBe(text("€2.00"));
    }

    @Test
    public void beerTest2() {
        cartPage.addBeer();
        cartPage.addBeer();
        cartPage.getTotal().shouldBe(text("€4.00"));
    }

    @Test
    public void wineTest1() {
        cartPage.addWine();
        cartPage.getTotal().shouldBe(text("€3.00"));
    }

    @Test
    public void wineTest2() {
        cartPage.addWine();
        cartPage.addWine();
        cartPage.getTotal().shouldBe(text("€6.00"));
    }

    @Test
    public void allProducts1() {
        cartPage.addCola();
        cartPage.addBeer();
        cartPage.addWine();
        cartPage.getTotal().shouldBe(text("€6.25"));
    }

    @Test
    public void goCheckoutTest() {
        cartPage.getCheckoutButton().shouldBe(disabled);
        cartPage.addCola();
        cartPage.addBeer();
        cartPage.addWine();
        cartPage.getCheckoutButton().shouldBe(enabled);
        cartPage.checkout();
    }
}
