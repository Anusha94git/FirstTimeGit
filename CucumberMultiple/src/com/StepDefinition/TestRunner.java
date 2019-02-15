package com.StepDefinition;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="OrangeHrm",glue= {"com.OrangeHRM_LoginMultiple"})

public class TestRunner {

}
