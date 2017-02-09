package net.serenitybdd.demos.taxiranks.glue;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class TaxiRankPropertyChecker {
    private final Map<String, String> expectedTaxiRank;

    private static final List<String> ADDITIONAL_PROPERTIES = ImmutableList.of(
            "NumberOfSpaces",
            "OperationDays",
            "OperationTime"
    );

    public TaxiRankPropertyChecker(Map<String, String> expectedTaxiRank) {
        this.expectedTaxiRank = expectedTaxiRank;
    }

    public void existsIn(List<Map> places) {

        for (Map place : places) {
            if (expectedTaxiRankMatches(place)) {
                return;
            }
        }
        throw new AssertionError("No taxi rank matching " + expectedTaxiRank + " found in " + places);
    }

    private boolean expectedTaxiRankMatches(final Map place) {

        if (!place.get("commonName").equals(expectedTaxiRank.get("commonName"))) {
            return false;
        }

        List<HashMap> allActualProperties = (List<HashMap>) place.get("additionalProperties");

        for (HashMap actualProperties : allActualProperties) {
            for (String property : ADDITIONAL_PROPERTIES) {
                if (additionalPropertyDoesNotMatch(actualProperties, property)) return false;
            }
        }

        return true;
    }

    private boolean additionalPropertyDoesNotMatch(HashMap actualProperties, String property) {
        if (isNotBlank(expectedTaxiRank.get(property)) && (actualProperties.get("key").equals(property))) {
            if (!actualProperties.get("value").equals(expectedTaxiRank.get(property))) {
                return true;
            }
        }
        return false;
    }

}
