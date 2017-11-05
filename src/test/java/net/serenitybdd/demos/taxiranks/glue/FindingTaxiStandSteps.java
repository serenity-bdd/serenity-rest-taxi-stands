package net.serenitybdd.demos.taxiranks.glue;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.demos.apis.TFLPlaces;
import net.serenitybdd.demos.apis.TFLResponse;
import net.serenitybdd.demos.model.locations.Place;
import net.serenitybdd.demos.model.locations.TaxiStand;
import net.serenitybdd.demos.model.locations.TubeStation;
import net.serenitybdd.demos.taxiranks.glue.transformers.TubeStationConverter;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FindingTaxiStandSteps {

    private TubeStation currentLocation;

    private String jsonResponse;

    @Given("(?:.*) is (?:at|planning a getaway from) (.*)")
    public void userIsCurrentlyAt(@Transform(TubeStationConverter.class) TubeStation tubeStation) {
        this.currentLocation = tubeStation;
    }

    // Specifying parameters
    @When("^s?he looks for the closest taxi rank within (\\d+) meters$")
    public void lookForTheClosestTaxiRankWithin(int maximumDistance) throws Throwable {
        with().params(
                "lat", currentLocation.latitude,
                "lon", currentLocation.longitude,
                "radius", maximumDistance)
                .get(TFLPlaces.find(Place.TaxiRank));

        jsonResponse = then().extract().asString();
        TFLResponse.withContent(jsonResponse).shouldBeValid();
    }


    @Then("^all of the taxi ranks should be no more than (\\d+) meters away$")
    public void allOfTheTaxiRanksShouldBeNoMoreThanMetersAway(Float maxDistance) throws Throwable {
        List<Float> distances = JsonPath.from(jsonResponse).getList("places.distance");

        assertThat(distances, everyItem(lessThan(maxDistance)));

    }

    // Checking return status and specific field values
    @Then("^the first taxi rank should be:$")
    public void heShouldFindRankStand(List<TaxiStand> closestStands) throws Throwable {
        TaxiStand closestStand = closestStands.get(0);

        then().statusCode(200)
                .body("places[0].commonName", equalTo(closestStand.commonName))
                .body("places[0].distance", equalTo(closestStand.distance));
    }

    // Fetching a list of values
    @Then("^no taxi racks should be returned$")
    public void noTaxiRacksShouldBeReturned() throws Throwable {
        List<String> taxiRacks = JsonPath.from(jsonResponse).getList("places.id");

        assertThat(taxiRacks.size(), equalTo(0));
    }

    @Then("^(\\d+) taxi ranks should be found$")
    public void txiRanksShouldBeFound(int taxiRanksFound) throws Throwable {
        List<String> taxiRacks = JsonPath.from(jsonResponse).getList("places.id");

        assertThat(taxiRacks.size(), equalTo(taxiRanksFound));
    }

    @Then("^s?he should find the taxi ranks with the following details$")
    public void shouldFindTheTaxiRanksWithTheFollowingDetails(List<Map<String, String>> taxiRanks) throws Throwable {

        List<Map> places = JsonPath.from(jsonResponse).getList("places", Map.class);

        taxiRanks.forEach(
                (Map<String, String> taxiRank) -> checkThatATaxiRankLike(taxiRank).existsIn(places)
        );
    }

    private TaxiRankPropertyChecker checkThatATaxiRankLike(Map<String, String> taxiRank) {
        return new TaxiRankPropertyChecker(taxiRank);
    }

    @Given("^Bill has joined the Frequent Flyer programme$")
    public void billHasJoinedTheFrequentFlyerProgramme() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^he took a flight from London to Mumbai (\\d+) days earlier worth (\\d+) points$")
    public void heTookAFlightFromLondonToMumbaiDaysEarlierWorthPoints(int arg0, int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Bill submits the boarding pass for this flight to reclaim the points$")
    public void billSubmitsTheBoardingPassForThisFlightToReclaimThePoints() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^his Frequent Flyer account should be credited with (\\d+) points$")
    public void hisFrequentFlyerAccountShouldBeCreditedWithPoints(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
