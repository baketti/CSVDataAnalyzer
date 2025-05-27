package it.emanuelebachetti.csvdataanalyzer.analysis;

import java.util.List;
import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

/**
 * The {@code Analyzer} class serves as the context in the Strategy Pattern.
 * It delegates the execution of a transaction analysis to a configurable
 * implementation of the {@link AnalysisStrategy} interface.
 *
 * <p>
 * This class is implemented as a Singleton to ensure that only one instance
 * of the analyzer is used throughout the application lifecycle.
 * </p>
 */
public class Analyzer {

    /** The analysis strategy to be applied. */
    private AnalysisStrategy strategy;

    /** The singleton instance of Analyzer. */
    private static Analyzer instance;

    /**
     * Private constructor to prevent external instantiation.
     */
    private Analyzer() {
    }

    /**
     * Returns the singleton instance of {@code Analyzer}.
     *
     * @return the unique {@code Analyzer} instance
     */
    public static Analyzer getInstance() {
        if (instance == null) {
            instance = new Analyzer();
        }
        return instance;
    }

    /**
     * Sets the current {@link AnalysisStrategy} to be used.
     *
     * @param strategy the strategy implementation for analysis
     */
    public void setStrategy(AnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Executes the selected strategy on the provided list of transactions.
     *
     * @param transactions a list of {@link Transaction} objects to analyze
     * @throws IllegalStateException if no strategy has been set before calling this
     *                               method
     */
    public void executeAnalysis(List<Transaction> transactions) {
        if (strategy == null)
            throw new IllegalStateException("Strategy not set.");
        strategy.analyze(transactions);
    }
}
