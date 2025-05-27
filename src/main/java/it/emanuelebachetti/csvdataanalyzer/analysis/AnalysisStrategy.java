package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;
import java.util.List;

/**
 * Defines the contract for different transaction analysis strategies.
 * Implementations of this interface encapsulate specific statistical
 * operations or business logic to be performed on a list of transactions.
 */
public interface AnalysisStrategy {
    /**
     * Executes the analysis on the given list of transactions.
     *
     * @param transactions the list of transactions to analyze
     */
    void analyze(List<Transaction> transactions);
}
