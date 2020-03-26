package com.swedbank.model;


import io.cucumber.datatable.DataTable;
import java.util.Map;

/**
 * Copyright (c) 2020.
 * Results object
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */

public class CalcResult {
    public String monthlyPayment = null;

    public String maxLoanAmount = null;

    public CalcResult(String monthlyPayment, String maxLoanAmount) {
        this.monthlyPayment = monthlyPayment;
        this.maxLoanAmount = maxLoanAmount;
    }

    public static CalcResult convert(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        return new CalcResult(map.get("monthlyPayment"), map.get("maxLoanAmount"));
    }
}
