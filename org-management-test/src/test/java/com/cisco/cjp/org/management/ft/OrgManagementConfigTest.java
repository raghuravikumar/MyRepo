package com.cisco.cjp.org.management.ft;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", tags="@one,@two", plugin = { "pretty",
		"html:target/ft-reports", "json:target/cucumber.json" })
public class OrgManagementConfigTest {
}
