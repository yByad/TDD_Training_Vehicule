package sii.maroc.presentation;

import java.util.List;

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
