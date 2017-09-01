package net.serenitybdd.demos.apis;

import net.serenitybdd.core.exceptions.TestCompromisedException;

public class IncorrectApiCredentials extends TestCompromisedException {

    public IncorrectApiCredentials() {
        super("Your authentication credentials were missing or incorrect.\n" +
                "To access the TFL feeds you must have a valid application ID and key. \n" +
                "You can sign up for an authentication key at https://api-portal.tfl.gov.uk. \n" +
                "Then fill in the values in the tfl.sample.properties file and rename this file to tfl.properties");
    }
}
