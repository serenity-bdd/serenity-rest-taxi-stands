package net.serenitybdd.demos.taxiranks.glue;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import net.serenitybdd.demos.apis.TFLPlaces;
import net.serenitybdd.demos.apis.TFLResponse;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.XML;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;

public class ListPlaceTypesSteps {

    private ContentType contentType;

    @When("^(?:.*) retrieves? all the available place types in (.*)$")
    public void retrieveAllTheAvailablePlaceTypesInFormat(ContentType contentType) throws Throwable {
        this.contentType = contentType;

        given().accept(contentType)
                .params("grant_type","authorization_code")
                .params("redirect_uri","redirect.url.com")
                .when().get(TFLPlaces.placeTypes());

        TFLResponse.withContent(then().extract().asString()).shouldBeValid();

    }

    @Then("^(?:.*) should see at least the following place types:$")
    public void shouldSeeAtLeastTheFollowingPlaceTypes(List<String> expectedPlaceTypes) throws Throwable {
        String placeData = then()
                            .statusCode(200)
                            .extract().asString();

        List<String> actualPlaceTypes = FETCH_PLACE_TYPES.get(contentType).apply(placeData);

        assertThat(actualPlaceTypes).containsAll(expectedPlaceTypes);
    }


    private final Map<ContentType, Function<String, List<String>>> FETCH_PLACE_TYPES;

    {
        FETCH_PLACE_TYPES = ImmutableMap.of(
                XML, (placeData) -> XmlPath.from(placeData).getList("ArrayOfstring.string"),
                JSON, (placeData) -> JsonPath.from(placeData).getList(".")
        );
    }
}
