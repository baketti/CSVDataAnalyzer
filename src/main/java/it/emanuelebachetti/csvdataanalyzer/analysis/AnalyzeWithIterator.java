package it.emanuelebachetti.csvdataanalyzer.analysis;

// only to show iterator usage
import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;
import it.emanuelebachetti.csvdataanalyzer.iterator.RecordIterator;
import it.emanuelebachetti.csvdataanalyzer.model.Dataset;
import it.emanuelebachetti.csvdataanalyzer.model.DataRecord;

/**
 * The Analyzer class provides statistical operations on a dataset,
 * such as sum, mean, maximum, and minimum of a numeric column.
 * 
 * PS: this class is not really used! It was the first {@link Analyzer}
 * implementation; it's to demonstrate the {@link Iterator} usage only;
 */
public class AnalyzeWithIterator {

    /**
     * Calculates the sum of a numeric column in the dataset.
     *
     * @param dataset     the dataset to analyze
     * @param columnIndex the index of the numeric column
     * @return the sum of the values
     */
    public static double sum(Dataset dataset, int columnIndex) {
        double total = 0;
        RecordIterator iterator = dataset.createIterator();
        while (iterator.hasNext()) {
            DataRecord record = iterator.next();
            try {
                double value = Double.parseDouble(record.getValueAt(columnIndex));
                total += value;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                ExceptionManager.handleException(e, "sum calculation", AnalyzeWithIterator.class);
            }
        }

        return total;
    }

    /**
     * Calculates the average (mean) of a numeric column.
     */
    public static double mean(Dataset dataset, int columnIndex) {
        double total = 0;
        int count = 0;
        RecordIterator iterator = dataset.createIterator();
        while (iterator.hasNext()) {
            DataRecord dataRecord = iterator.next();
            try {
                double value = Double.parseDouble(dataRecord.getValueAt(columnIndex));
                total += value;
                count++;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                ExceptionManager.handleException(e, "mean calculation", AnalyzeWithIterator.class);
            }
        }

        return count == 0 ? 0 : total / count;
    }

    /**
     * Finds the maximum value in a numeric column.
     */
    public static double max(Dataset dataset, int columnIndex) {
        double maxValue = Double.NEGATIVE_INFINITY;
        RecordIterator iterator = dataset.createIterator();
        while (iterator.hasNext()) {
            DataRecord dataRecord = iterator.next();
            try {
                double value = Double.parseDouble(dataRecord.getValueAt(columnIndex));
                if (value > maxValue) {
                    maxValue = value;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                ExceptionManager.handleException(e, "the research of the max value", AnalyzeWithIterator.class);
            }
        }

        return maxValue;
    }

    /**
     * Finds the minimum value in a numeric column.
     */
    public static double min(Dataset dataset, int columnIndex) {
        double minValue = Double.POSITIVE_INFINITY;
        RecordIterator iterator = dataset.createIterator();
        while (iterator.hasNext()) {
            DataRecord dataRecord = iterator.next();
            try {
                double value = Double.parseDouble(dataRecord.getValueAt(columnIndex));
                if (value < minValue) {
                    minValue = value;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                ExceptionManager.handleException(e, "the research of the min value", AnalyzeWithIterator.class);
            }
        }

        return minValue;
    }
}
