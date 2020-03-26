package com.swedbank.pageobjects.loancalculator;

import com.codeborne.selenide.SelenideElement;

/**
 * Copyright (c) 2020.
 * Class container of page elements
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */

public abstract class CalculatorContainer implements Calculator {
    public final SelenideElement coApplicantCheckbox = calculatorRootElement.$("label[for='borrowersCheck']");
    public final SelenideElement haveDependantsCheckbox = calculatorRootElement.$("label[for='dependantsCheck']");
    public final SelenideElement haveObligations = calculatorRootElement.$("label[for='obligationsCheck']");
    public final SelenideElement monthlyIncomeInput = calculatorRootElement.$("#income");
    public final SelenideElement amountSlider = calculatorRootElement.$("#slider1");
    public final SelenideElement sliderAmountBtn = amountSlider.$("button[class='ui-slider__handle']");
    public final SelenideElement termSlider = calculatorRootElement.$("#slider2");
    public final SelenideElement termSliderBtn = termSlider.$("button[class='ui-slider__handle']");
    public final SelenideElement monthlyPaymentResult = calculatorRootElement.$("#month-payment");
    public final SelenideElement maxLoanAmountResult = calculatorRootElement.$("#slider-financed");
}
