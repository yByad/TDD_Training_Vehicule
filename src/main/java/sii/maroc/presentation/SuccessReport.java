package sii.maroc.presentation;

import java.util.List;

public class SuccessReport implements Report {

    private List<Parameter> parameters;

    public SuccessReport(List<Parameter> parameters) {
	this.parameters = parameters;
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
