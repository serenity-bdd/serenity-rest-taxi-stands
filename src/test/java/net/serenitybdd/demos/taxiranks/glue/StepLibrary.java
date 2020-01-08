package net.serenitybdd.demos.taxiranks.glue;

import com.gargoylesoftware.htmlunit.javascript.host.fetch.Response;
import net.thucydides.core.annotations.Step;

public class StepLibrary {

    @Step("Check status code is '{1}'")
    public void checkStatusCode(final int statusCode) {
        checkStatusCode();
    }

    public void checkStatusCode() {}
}
