package it.emanuelebachetti.csvdataanalyzer.analysis;

import it.emanuelebachetti.csvdataanalyzer.exception.ExceptionManager;

public class StrategyLoader {
    public static AnalysisStrategy load(String strategyName) {
        try {
            String fullClassName = "it.emanuelebachetti.csvdataanalyzer.analysis." + strategyName;
            Class<?> clazz = Class.forName(fullClassName);
            return (AnalysisStrategy) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            ExceptionManager.handleException(e, "while loading strategy", StrategyLoader.class);
            return null;
        }
    }
}
