package it.unibo.oop.lab.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SimpleController implements Controller {

    private final List<String> stringHistory = new LinkedList<>();
    private String stringToPrint;

    @Override
    public final void setNextString(final String in) {
        this.stringToPrint = Objects.requireNonNull(in, "This method does not accept null values");
    }

    @Override
    public final String getNextString() {
        return this.stringToPrint;
    }

    @Override
    public final List<String> getHistoryStrings() {
        return this.stringHistory;
    }

    @Override
    public final void printActualString() {
        if (this.stringToPrint == null) {
            throw new IllegalStateException("There is no String Set");
        }
    }

}
