package sii.maroc.presentation.report;

import java.util.List;

import sii.maroc.presentation.report.parameters.Parameter;

public class FailReport extends Report {

    public FailReport(List<Parameter> parameters) {
	super(parameters);
    }

    @Override
    public String report() {
	String report = "DOORS KO, BLOCKED \n";
	for (Parameter parameter : parameters) {
	    report += parameter.getMessage();
	}
	return report;
    }

}
