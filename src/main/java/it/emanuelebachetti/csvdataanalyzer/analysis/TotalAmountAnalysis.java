package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;

/**
 * Calculates the total sum of all transaction amounts.
 */
public class TotalAmountAnalysis implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {

        double total = transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("[ANALYSIS] Total amount transacted: " + total);
    }
}
