package com.swedbank;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Copyright (c) 2020.
 * cucumber runner class
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */
@CucumberOptions(
        features = "src/test/java/features",
        plugin = {"pretty", "html:target/cucumber"},
        glue = {"com.swedbank.teststeps"},
        strict = true
)
@RunWith(Cucumber.class)
public class RunTests {
}
