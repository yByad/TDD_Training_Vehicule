package sii.maroc.presentation;

import java.util.List;

public abstract class Report {
    protected List<Parameter> parameters;

    public Report(final List<Parameter> parameters) {
	this.parameters = parameters;
    }

    abstract String report();
}
