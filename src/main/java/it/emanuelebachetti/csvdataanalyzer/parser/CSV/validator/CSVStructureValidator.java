package it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidCSVStructureException;
import java.util.List;

public interface CSVStructureValidator {

    boolean supports(List<String> header);

    void validate(List<String> header) throws InvalidCSVStructureException;
}