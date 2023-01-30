package com.cloudMore.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features/api",
        glue = "com/cloudMore/step_definitions/api",
        dryRun = false,
        publish = true,
        tags = "@API"
)

public class APICukesRunner {

}
