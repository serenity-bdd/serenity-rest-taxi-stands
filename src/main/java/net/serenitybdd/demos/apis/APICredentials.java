package net.serenitybdd.demos.apis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * To run these tests, you will need to sign up at https://api.tfl.gov.uk and
 * to have a file called tfl.properties in the root directory of your project with the
 * tfl.app_id and tfl.app_key containing the API ID and Key respectively
 */
public class APICredentials {

    private final String DEFAULT_CREDENTIALS_FILE = "tfl.properties";
    private static final String NOT_REGISTERED_MESSAGE = "To use this API register at https://api.tfl.gov.uk and create a file called tfl.properties in the root directory of your project, containing the properties tfl.app_id and tfl.app_key";

    private final String appId;
    private final String appKey;

    public static APICredentials fromLocalEnvironment() {
        return new APICredentials();
    }

    public APICredentials() {
        try {
            Properties credentialsProperties = new Properties();
            credentialsProperties.load(new FileInputStream(DEFAULT_CREDENTIALS_FILE));
            appId = credentialsProperties.getProperty("app_id");
            appKey = credentialsProperties.getProperty("app_key");
        } catch (IOException e) {
            throw new NotRegisteredException(NOT_REGISTERED_MESSAGE);
        }

        if (isBlank(appKey) || isBlank(appId)) {
            throw new NotRegisteredException(NOT_REGISTERED_MESSAGE);
        }
    }

    public String getAppKey() {
        return appKey;
    }

    public String getAppId() {
        return appId;
    }
}
