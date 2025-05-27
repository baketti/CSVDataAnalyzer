package it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidCSVStructureException;
import java.util.List;

/**
 * The {@code CSVStructureValidator} interface defines a contract for validating
 * the structure (i.e., headers) of a CSV file before parsing its content.
 *
 * <p>
 * Implementations of this interface are responsible for ensuring that the
 * expected
 * column names are present in the header. If validation fails, an
 * {@link InvalidCSVStructureException} is thrown.
 * </p>
 */
public interface CSVStructureValidator {

    /**
     * Validates the provided CSV header against required structure rules.
     *
     * @param header a list of strings representing the CSV header fields
     * @throws InvalidCSVStructureException if the header does not meet the expected
     *                                      format
     */
    void validate(List<String> header) throws InvalidCSVStructureException;
}
