package it.emanuelebachetti.csvdataanalyzer.parser.CSV.validator;

import it.emanuelebachetti.csvdataanalyzer.exception.InvalidCSVStructureException;

import java.util.List;

public class TransactionCSVValidator implements CSVStructureValidator {

    private static final List<String> REQUIRED_HEADERS = List.of(
            "transaction_id",
            "timestamp",
            "user_id",
            "amount",
            "currency",
            "status");

    @Override
    public void validate(List<String> header) throws InvalidCSVStructureException {
        for (String required : REQUIRED_HEADERS) {
            if (!header.contains(required)) {
                throw new InvalidCSVStructureException(
                        "Missing required header: '" + required + "'");
            }
        }
    }

    @Override
    public boolean supports(List<String> header) {
        return header.containsAll(REQUIRED_HEADERS);
    }
}
