package net.serenitybdd.demos.taxiranks.glue;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

public class SettingTheStage {

    @Before
    public void recruitTheActors() {
        OnStage.setTheStage(new Cast());
    }
}
