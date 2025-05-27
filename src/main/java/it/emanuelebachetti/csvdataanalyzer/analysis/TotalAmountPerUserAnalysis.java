package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Groups transactions by user ID and calculates the total amount spent by each
 * user.
 */
public class TotalAmountPerUserAnalysis implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {
        Map<String, Double> totalPerUser = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getUserId,
                        Collectors.summingDouble(Transaction::getAmount)));

        System.out.println("[ANALYSIS] Total amount per user:");
        totalPerUser.forEach((userId, total) -> System.out.println("  " + userId + ": " + total));
    }
}
