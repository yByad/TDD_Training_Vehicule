package sii.maroc.presentation.report;

import java.util.List;

import sii.maroc.presentation.report.parameters.Parameter;

public class SuccessReport extends Report {

    public SuccessReport(List<Parameter> parameters) {
	super(parameters);
    }

    @Override
    public String report() {
	String report = "DOORS OK, MOVING. ";
	for (Parameter parameter : parameters) {
	    report += parameter.getMessage();
	}
	return report;
    }

}
