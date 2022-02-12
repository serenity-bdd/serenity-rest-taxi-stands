package net.serenitybdd.demos.taxiranks.features;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/discover_places",
        glue = "net.serenitybdd.demos.taxiranks")
public class DiscoverPlaces {
}
