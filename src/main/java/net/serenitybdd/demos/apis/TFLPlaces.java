package net.serenitybdd.demos.apis;

import net.serenitybdd.demos.model.locations.Place;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;


public class TFLPlaces {

    private static final String BASE_URL = "https://api.tfl.gov.uk";

    private static final String APP_ID = APICredentials.fromLocalEnvironment().getAppId();
    private static final String APP_KEY = APICredentials.fromLocalEnvironment().getAppKey();
    private static final String API_PARAMS = "app_id=%s&app_key=%s";

    private static final String FIND_PLACE_BY_PROXIMITY = BASE_URL + "/Place?type=%s&" + API_PARAMS;
    private static final String FIND_PLACE_TYPES = BASE_URL + "/Place/Meta/PlaceTypes?" + API_PARAMS;


    public static URL find(Place placeType) throws MalformedURLException {

        return new URL(format(FIND_PLACE_BY_PROXIMITY, placeType, APP_ID, APP_KEY));

    }

    public static URL placeTypes() throws MalformedURLException {

        return new URL(format(FIND_PLACE_TYPES, APP_ID, APP_KEY));

    }

}
