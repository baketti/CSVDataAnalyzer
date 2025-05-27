package it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidCSVStructureException;

import java.util.List;

/**
 * {@code TransactionCSVValidator} is a concrete implementation of the
 * {@link CSVStructureValidator} interface. It validates that a CSV file
 * contains the required headers for processing transaction data.
 *
 * <p>
 * The required headers include: {@code transaction_id}, {@code timestamp},
 * {@code user_id}, {@code amount}, {@code currency}, and {@code status}.
 * </p>
 *
 * <p>
 * If any required header is missing, an {@link InvalidCSVStructureException}
 * is thrown to prevent further parsing.
 * </p>
 */
public class TransactionCSVValidator implements CSVStructureValidator {

    private static final List<String> REQUIRED_HEADERS = List.of(
            "transaction_id",
            "timestamp",
            "user_id",
            "amount",
            "currency",
            "status");

    /**
     * Validates that the given header list contains all required transaction
     * fields.
     *
     * @param header a list of strings representing the CSV file's header row
     * @throws InvalidCSVStructureException if any required field is missing
     */
    @Override
    public void validate(List<String> header) throws InvalidCSVStructureException {
        for (String required : REQUIRED_HEADERS) {
            if (!header.contains(required)) {
                throw new InvalidCSVStructureException(
                        "Missing required header: '" + required + "'");
            }
        }
    }
}
