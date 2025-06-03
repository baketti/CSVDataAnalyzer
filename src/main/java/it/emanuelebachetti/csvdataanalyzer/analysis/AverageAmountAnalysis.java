package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Computes the average transaction amount, grouping by currency, across all
 * given transactions.
 */
public class AverageAmountAnalysis implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {

        Map<String, Double> avgAmountPerCurrency = transactions.stream()
                .filter(transaction -> "completed".equalsIgnoreCase(transaction.getStatus()))
                .collect(Collectors.groupingBy(
                        Transaction::getCurrency,
                        Collectors.averagingDouble(Transaction::getAmount)));
        avgAmountPerCurrency.forEach((currency, avgAmount) -> {
            System.out.println("Average " + currency + " amount transacted: " + String.format("%.2f", avgAmount));
        });
    }
}
