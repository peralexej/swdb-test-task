package com.swedbank.teststeps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLog;
import com.swedbank.conf.ConfigProperties;
import com.swedbank.model.CalcResult;
import com.swedbank.pageobjects.loancalculator.CalculatorView;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Copyright (c) 2020.
 * Test steps
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */

public class LoanCalculatorTestSteps extends CalculatorView {
    private static final ConfigProperties CONFIG_PROPERTIES = ConfigProperties.getInstance();

    @Given("Open browser with selected env")
    public void openBrowser() {
        System.setProperty("-Dorg.slf4j.simpleLogger.defaultLogLevel", "debug");
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/results";
        Configuration.browser = CONFIG_PROPERTIES.getDriverType();
        Configuration.baseUrl = CONFIG_PROPERTIES.getDefaultEnvAddress();
        Configuration.downloadsFolder = "target/downloads";
        open();
    }

    @And("Go to uri: {string}")
    public void goToUri(String uri) {
        open(uri);
        assertTrue(isPageDisplayed());
    }

    @Then("Accept cookies and terms")
    public void acceptCookiesAndTerms() {
        acceptCookies();
    }

    @When("set total monthly income = {int}")
    public void setTotalMonthlyIncome(int value) {
        monthlyIncomeInput.setValue(String.valueOf(value))
                .pressEnter();
    }

    @And("click on ‹I have children \\(dependants) in family› btn")
    public void clickOnIHaveChildrenDependantsInFamilyBtn() {
        haveDependantsCheckbox.waitUntil(appears, MAX_WAIT_TIME).click();
    }

    @And("choose {int} dependants btn")
    public void chooseDependantsBtn(int count) {
        getDependantsCountBtn(count).waitUntil(appears, MAX_WAIT_TIME).click();
    }


    @And("set {string} amount slider = {int}")
    public void setAmountSlider(String sliderType, int value) {
        Selenide.executeJavaScript(
                "arguments[0].value = " +
                        value + ";" +
                        "arguments[0].updateValue()",
                getSlider(sliderType)
        );
    }

    @Then("calculation result equal to:")
    public void calculationResultEqualTo(DataTable dataTable) {
        CalcResult result = CalcResult.convert(dataTable);
        assertEquals(result.monthlyPayment, monthlyPaymentResult.getText());
    }

}


//You might want to use selenium native d'n'd to set slider value
//it's possible by using this code, but js version is more reliable
//
//        //cleanup slider position
//actions().dragAndDropBy(termSliderBtn, -200, 0).perform();
//do {
//    Selenide.sleep(50);
//    actions().dragAndDropBy(termSliderBtn, 10, 0).perform();
//} while (!termSlider.$("div[class='ui-slider__value']").getText().equalsIgnoreCase("11 years"));
