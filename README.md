# Serenity BDD Rest sample

This is a simple project to demo how to use Serenity BDD, Cucumber and RestAssured to test microservices. It uses Maven and Java 8.

It runs against the Transport for London public API (https://api.tfl.gov.uk). To run these tests locally, you will need to sign up on this site, where you will be given an APP ID and an APP key. Create a file called `tfl.properties` in the project root directory, or copy the existing `tfl.sample.properties` file, and add your credentials.

To run the tests, just run `mvn verify`. Your reports will be in the `target/site/serenity` directory.
