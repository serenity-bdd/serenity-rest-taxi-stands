package net.serenitybdd.demos.taxiranks.glue.transformers;

import cucumber.api.Transformer;
import net.serenitybdd.demos.model.locations.TubeStation;
import net.serenitybdd.demos.model.locations.UnknownTubeStationException;

import java.util.Arrays;

public class TubeStationConverter extends Transformer<TubeStation> {
    @Override
    public TubeStation transform(String tubeStationName) {
        return Arrays.stream(TubeStation.values())
                .filter(station -> station.name.equalsIgnoreCase(tubeStationName))
                .findFirst()
                .orElseThrow(() -> new UnknownTubeStationException(tubeStationName));
    }
}
