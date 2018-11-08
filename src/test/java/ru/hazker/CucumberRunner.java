package ru.hazker;


import cucumber.api.CucumberOptions;


@CucumberOptions(
        features = "src/test/features",
        glue = "ru.hazker.resources.features",
        strict = true


)

public class CucumberRunner{

}
