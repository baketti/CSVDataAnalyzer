package it.emanuelebachetti.csvdataanalyzer.parser;

import java.io.File;

public interface Parser<T> {
    T parse(File file) throws Exception;
}
