package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;

/**
 * Computes the average transaction amount across all given transactions.
 */
public class AverageAmountAnalysis implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {
        double total = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        double average = total / transactions.size();
        System.out.println("[ANALYSIS] Average transaction amount: " + average);
    }
}
