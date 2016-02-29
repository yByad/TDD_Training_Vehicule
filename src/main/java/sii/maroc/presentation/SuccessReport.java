package sii.maroc.presentation;

import java.util.List;

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
