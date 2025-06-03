package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Calculates the total sum of all completed transaction amounts, grouped by
 * currency.
 */
public class TotalAmountAnalysis implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {

        Map<String, Double> totalPerCurrency = transactions.stream()
                .filter(transaction -> "completed".equalsIgnoreCase(transaction.getStatus()))
                .collect(Collectors.groupingBy(
                        Transaction::getCurrency,
                        Collectors.summingDouble(Transaction::getAmount)));
        totalPerCurrency.forEach((currency, total) -> {
            System.out.println("Total " + currency + " amount transacted: " + total);
        });
    }
}
