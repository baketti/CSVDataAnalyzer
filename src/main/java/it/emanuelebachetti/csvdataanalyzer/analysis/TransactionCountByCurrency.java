package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Counts the number of transactions for each currency.
 */
public class TransactionCountByCurrency implements AnalysisStrategy {

    @Override
    public void analyze(List<Transaction> transactions) {
        Map<String, Long> countByCurrency = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCurrency,
                        Collectors.counting()));

        System.out.println("Transaction count by currency:");
        countByCurrency.forEach((currency, count) -> System.out.println("  " + currency + ": " + count));
    }
}
