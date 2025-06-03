package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Groups completed transactions by user ID (and currency) and calculates the
 * total amount spent by each user.
 */
public class TotalAmountPerUserAnalysis implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {
        Map<String, Map<String, Double>> totalPerUser = transactions.stream()
                .filter(transaction -> "completed".equalsIgnoreCase(transaction.getStatus()))
                .collect(Collectors.groupingBy(
                        Transaction::getUserId,
                        Collectors.groupingBy(
                                Transaction::getCurrency,
                                Collectors.summingDouble(Transaction::getAmount))));

        System.out.println("Total amount per user:");
        totalPerUser.forEach((userId, currencyMap) -> {
            currencyMap.forEach((currency, total) -> System.out.println(userId + ": " + currency + " " + total));
        });
    }
}
