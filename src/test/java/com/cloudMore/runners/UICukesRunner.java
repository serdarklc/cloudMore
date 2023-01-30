package com.cloudMore.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
		plugin = {"html:target/cucumber-report.html",
				  "json:target/cucumber.json",
				  "rerun:target/rerun.txt"
		},
		features = "src/test/resources/features/ui",
		glue = "com/cloudMore/step_definitions/ui",
		dryRun = false,
		publish = true,
		tags = "@UI"
)

public class UICukesRunner {

}
