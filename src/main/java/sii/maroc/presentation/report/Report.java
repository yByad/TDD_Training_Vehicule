package sii.maroc.presentation.report;

import java.util.List;

import sii.maroc.presentation.report.parameters.Parameter;

public abstract class Report {
    protected List<Parameter> parameters;

    public Report(final List<Parameter> parameters) {
	this.parameters = parameters;
    }

    public abstract String report();
}
