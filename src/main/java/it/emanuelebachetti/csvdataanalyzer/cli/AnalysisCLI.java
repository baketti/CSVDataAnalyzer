package it.emanuelebachetti.csvdataanalyzer.cli;

import it.emanuelebachetti.csvdataanalyzer.analysis.*;
import it.emanuelebachetti.csvdataanalyzer.logging.LoggerConfig;
import it.emanuelebachetti.csvdataanalyzer.model.transaction.Transaction;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * {@code AnalysisCLI} provides a command-line interface for interacting
 * with the user and executing transaction analysis operations.
 *
 * <p>
 * It leverages the {@link Analyzer} (Context in the Strategy Pattern) and
 * dynamically loads the appropriate {@link AnalysisStrategy} implementation
 * via {@link StrategyLoader} based on user input.
 * </p>
 *
 * <p>
 * The user is presented with a menu of possible analyses, each mapped to
 * a specific strategy class. The selection is handled dynamically using
 * reflection.
 * </p>
 */
public class AnalysisCLI {

    /** Singleton instance of {@code Analyzer} to delegate analysis execution. */
    private final Analyzer analyzer;

    /** Maps user choices to concrete strategy class names. */
    private static final Map<String, String> strategyMap = Map.of(
            "1", "TotalAmountAnalysis",
            "2", "AverageAmountAnalysis",
            "3", "StatusCountAnalysis",
            "4", "TotalAmountPerUserAnalysis",
            "5", "TransactionCountByCurrency");

    /**
     * Constructs the CLI handler and links it to the analyzer instance.
     *
     * @param analyzer the analysis context (Strategy Pattern)
     */
    public AnalysisCLI(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * Starts the CLI loop allowing the user to select and execute
     * transaction analyses.
     *
     * @param transactions the list of validated {@link Transaction} objects
     */
    public void start(List<Transaction> transactions) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim();
            String strategyName = strategyMap.get(choice);

            if (strategyName != null) {
                try {
                    AnalysisStrategy strategy = StrategyLoader.load(strategyName);
                    analyzer.setStrategy(strategy);
                    analyzer.executeAnalysis(transactions);
                } catch (Exception e) {
                    System.err.println("[ERROR] Unable to execute selected analysis strategy.");
                    LoggerConfig.getLogger(AnalysisCLI.class)
                            .severe("Analysis execution failed: " + e.getMessage());
                }
            } else if (choice.equals("0")) {
                System.out.println("Thanks for using CSV Data Analyzer!");
                exit = true;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    /** Displays the list of available analysis options to the user. */
    private void printMenu() {
        System.out.print("""
                \n\n===== Transactions Analysis Menu =====\n
                1. Total amount of all transactions
                2. Average transaction amount
                3. Count by status
                4. Total amount per user
                5. Transaction count by currency
                0. Exit
                \nChoose an option:  """);
    }
}
