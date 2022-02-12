package net.serenitybdd.demos.taxiranks.features;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreatingDataCentersTest {

    private RequestSpecification query() {
        RestAssured.baseURI = "https://api.ionos.com";
        return given()
                .log().all()
                .header("Authorization", "Basic cWEtYXNzZXNzbWVudCsxQGNsb3VkLmlvbm9zLmNvbTpKaGhVam1fTmpidDY1Wm5o")
                .header("Content-type", "application/json");

    }

    @Test
    public void creatingSeveralDataServers() {
        // WHEN WE
        createADataCenter();

        // THEN
        serversShouldBeUpAndRunning();

    }

    @Test
    public void updateADataServer() {
        // GIVEN WE HAVE
        createADataCenter();

        // WHEN
        updateServerDetails();

        // THEN
        serverDetailsShouldBeUpdated();

    }

    private void serverDetailsShouldBeUpdated() {
    }

    private void updateServerDetails() {
        /*
        3. Update the servers by changing the number of cores and the amount of RAM.
           **Limit:** only one server to use 2 cores, maximum 2GB of RAM per server
         */
    }

    private void createADataCenter() {
        /*
         *     Create a data center:
         *    * This data center should consist of two servers (e.g. ‘frontend’ and ‘backend’).
         *      - **Limit:** only one core and 1GB of RAM per server
         *    * Both servers are connected via a private LAN.
         *    * One server (e.g. ‘frontend’) is connected to a public LAN.
         *      - **Limit:** use one CRIP only
         *    * Both servers contain one storage each. Please use an ssh key when creating the storages.
         *      - **Limit:** maximum storage size of 25GB
         */
    }

    private void serversShouldBeUpAndRunning() {
        // Check whether the servers are up and running by logging in.
    }

    @After
    public void deleteTheDataCenter() {
        //...
    }
}
