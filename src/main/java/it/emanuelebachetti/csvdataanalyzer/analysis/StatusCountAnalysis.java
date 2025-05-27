package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Counts the number of transactions grouped by their status
 * (e.g., completed, pending, failed) and prints the result.
 */
public class StatusCountAnalysis implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {
        Map<String, Long> statusCounts = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getStatus, Collectors.counting()));

        System.out.println("[ANALYSIS] Transaction count by status:");
        statusCounts.forEach((status, count) -> System.out.println("  " + status + ": " + count));
    }
}
