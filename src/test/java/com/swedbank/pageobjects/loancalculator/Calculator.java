package com.swedbank.pageobjects.loancalculator;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
/**
 * Copyright (c) 2020.
 * Calculator interface
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */
public interface Calculator {
    SelenideElement calculatorRootElement = $("ui-calculator[id='homeloan-calculator']");
    boolean isPageDisplayed();
}
