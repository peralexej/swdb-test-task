package com.swedbank.pageobjects.loancalculator;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Copyright (c) 2020.
 * Class for operation with elements (page view)
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */

public class CalculatorView extends CalculatorContainer {
    public static final long MAX_WAIT_TIME = 7000; //7 seconds

    @Override
    public boolean isPageDisplayed() {
        SelenideElement promoKidImage = $x("//img[contains(@src, 'loan_kid')]");
        boolean isImageDisplayed = Selenide.executeJavaScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                promoKidImage);
        return $("h1").getText().equalsIgnoreCase("Mortgage loan") && isImageDisplayed;
    }

    public SelenideElement getDependantsCountBtn(int count) {
        if (count < 1 || count > 2) throw new RuntimeException("incorrect count value " + count);
        return calculatorRootElement.$("label[for='dependants" + count + "']");
    }

    public void scrollToCalculator() {
        calculatorRootElement.scrollTo();
        calculatorRootElement.waitUntil(appears, MAX_WAIT_TIME);
    }

    public SelenideElement getSlider(String sliderType) {
        if (sliderType.equals("term")) {
            return termSlider;
        }
        return amountSlider;
    }

    public void acceptCookies() {
        SelenideElement accept = $(".ui-cookieprompt__accept");
        accept.waitUntil(appears, MAX_WAIT_TIME).click();
        accept.waitUntil(disappears, MAX_WAIT_TIME);
    }
}
