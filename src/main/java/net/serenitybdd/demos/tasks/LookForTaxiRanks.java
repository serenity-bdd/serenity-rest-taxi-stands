package net.serenitybdd.demos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LookForTaxiRanks implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    private final int maximumDistance;

    public LookForTaxiRanks(int maximumDistance) {
        this.maximumDistance = maximumDistance;
    }

    public static Performable withinADistanceOf(int maximumDistance) {
        return instrumented(LookForTaxiRanks.class, maximumDistance);
    }
}
