package sii.maroc.presentation;

import java.util.List;

public class FailReport implements Report {

    private List<Parameter> parameters;

    public FailReport(List<Parameter> parameters) {
	this.parameters = parameters;
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
