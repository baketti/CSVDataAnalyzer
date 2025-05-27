# 📊 CSV Data Analyzer

**CSV Data Analyzer** is a Java-based application designed to parse, validate, transform, and analyze tabular data from CSV files using a clean, extensible, and object-oriented architecture.  
The project is structured around well-established **software design patterns** and focuses on **modularity, separation of concerns**, and **robust exception and validation handling**.

---

## 📁 Project Structure

src/
└── main/java/it/emanuelebachetti/csvdataanalyzer/
    ├─ analysis/         # Analysis strategies and dynamic loading
    ├─ cli/              # CLI interface for interactive analysis
    ├─ exception/        # Centralized exception handling (Exception Shielding)
    ├─ iterator/         # Iterator Pattern for Composite structure
    ├─ logging/          # Logger configuration for console and file output
    ├─ model/
    │   ├─ adapter/      # Adapter pattern for transforming DataRecord to Transaction
    │   └─ transaction/  # Transaction domain model
    ├─ parser/
    │   ├─ CSV/          # CSV parsing and validators
    │   └─ factory/      # Factory Method for parser instantiation
    └─ App.java          # Main entry point

---

## ✅ Features

- ✅ CSV file parsing using a flexible factory-based architecture
- ✅ Structured data representation with the Composite pattern
- ✅ Manual Iterator for accessing dataset records
- ✅ Statistical and domain-specific analysis using the Strategy pattern
- ✅ Exception shielding and logging of all critical errors (console and file)
- ✅ Centralized validation of CSV structure and content using Chain of Responsibility
- ✅ Support for field transformation via Adapter pattern
- ✅ Dynamic loading of strategies using Reflection
- ✅ CLI interface for analysis selection and execution

---

## 💡 Design Patterns Used

### Factory Method Pattern
- **Classes**: `ParserFactory`, `Parser<T>`, `CSVParser`
- **Purpose**: Create parsers dynamically based on file type (`csv`, extensible to `json`, `xml`, etc.)

### Composite Pattern
- **Interface**: `DatasetComponent`
- **Leaf**: `DataRecord`
- **Composite**: `Dataset`
- **Purpose**: Treat single records and record groups uniformly, allowing recursive traversal.

### Iterator Pattern (Manual)
- **Interface**: `RecordIterator`
- **Implementation**: `DatasetIterator`
- **Purpose**: Traverse `Dataset` while encapsulating its internal structure.

### Exception Shielding Pattern
- **Class**: `ExceptionManager`
- **Purpose**: Log internal errors and rethrow generic messages to shield internal logic from the user.

### Strategy Pattern
- **Interface**: `AnalysisStrategy`
- **Implementations**: `TotalAmountAnalysis`, `AverageAmountAnalysis`, etc.
- **Purpose**: Enables flexible execution of analysis logic at runtime.

### Chain of Responsibility
- **Handlers**: `RecordValidatorHandler` and all concrete validators (`TransactionIdValidator`, `AmountValidator`, etc.)
- **Purpose**: Composable and extendable record-level validation logic.

### Adapter Pattern
- **Adapters**: `TransactionAdapter`, `RecordAdapter`
- **Purpose**: Converts `DataRecord` into typed `Transaction` objects.

### Singleton
- **Class**: `Analyzer`
- **Purpose**:  Ensures a single configurable `Analyzer` is used during runtime.

--- 

## Technologies Used

- **Java Collections Framework** – Used for dynamic data storage (`List`, `Map`, etc.)
- **Generics** – Ensures type safety and flexibility in interfaces like `Parser`<T>
- **Java I/O** – Core file reading/writing functionalities for parsing CSV files
- **Logging (java.util.logging)** – Logs errors to both console and file with configurable levels
- **Stream API & Lambdas** – Used in analysis strategies for data aggregation and filtering
- **Reflection** – Enables dynamic strategy loading at runtime based on user input
- **JUnit** – Unit testing framework used to verify the correctness of business logic and application components through automated tests
- **Mockito** – Used for mocking dependencies in some test cases
- **Inversion of Control** – Promotes loose coupling (i.e., decoupling the creation and selection of analysis strategies from their execution context) by delegating the decision of which strategy to use to the consuming component (e.g., `AnalysisCLI`), rather than hardcoding dependencies

---

## ⚙️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/baketti/CSVDataAnalyzer.git 
cd CSVDataAnalyzer
```

2. Compile and run (Java 17+):
```bash 
javac -d out $(find src -name "*.java")
java -cp out it.emanuelebachetti.csvdataanalyzer.App
```

3. Place your input .csv files in a data/ folder (to be created).

---

## Known Limitations and Future Work

### Known Limitations

- **CSV-only Support**: The application currently only supports CSV files. It cannot parse or analyze data from other formats such as JSON or XML.
- **Strict CSV Structure**: The CSV input must strictly follow a predefined schema, with required headers such as `transaction_id`, `timestamp`, `user_id`, etc. If the structure does not match, the program stops its execution.
- **Fixed Dataset**: Users cannot upload or select custom CSV files at runtime. The application only operates on a hardcoded file path embedded in the codebase.
- **Basic Analytics**: The current analysis strategies are minimal and intended for demonstration purposes only. There is no support for advanced filtering, custom queries, or data visualization.

### Future Work

- **Multi-format Support**: Extend the parser system to handle additional formats (e.g., JSON, XML) using the existing factory architecture.
- **User-driven Input**: Allow users to select and upload CSV files dynamically via CLI or GUI interface.
- **Advanced Analytics**: Incorporate more complex statistical computations and visualizations.
- **Improved User Interaction**: Introduce filtering options, pagination, and querying capabilities to let users choose what data to view and how to analyze it.

---

## Testing

---

## Author
