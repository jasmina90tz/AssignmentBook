package com.ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty","html:target/reports/report.html/",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
//
//        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},


        features = "src/test/resources/features/",
        glue = "com/ui/steps",
        tags = "@test",
        dryRun = false


)
public class CukesRunner{





}

