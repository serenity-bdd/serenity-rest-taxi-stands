package net.serenitybdd.demos.taxiranks.glue;

import net.thucydides.core.annotations.Step;

public class StepLibrary {

    @Step("Check status code is '{1}'")
    public void checkStatusCode(final int statusCode) {
        checkStatusCode();
    }

    public void checkStatusCode() {}
}
