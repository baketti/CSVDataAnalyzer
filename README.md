# 📊 CSV Data Analyzer

**CSV Data Analyzer** is a Java-based application designed to parse, structure, and analyze tabular data from CSV files using a clean, extensible, and object-oriented architecture.  
The project is structured around well-established **software design patterns** and focuses on **readability, modularity**, and **robust exception handling**.

---

## 📁 Project Structure

src/
└── main/java/it/emanuelebachetti/csvdataanalyzer/
├── analyzer/ # Statistical operations (mean, sum, max, min)
├── exception/ # Centralized exception handling (Exception Shielding)
├── iterator/ # Manual implementation of Iterator Pattern
├── model/ # Core data models (Composite Pattern)
├── parser/ # Parser logic with Factory Method Pattern
└── App.java # Entry point (to be extended)

---

## ✅ Features (Minimum Functional Requirements)

- ✅ CSV file parsing using a flexible factory-based architecture  
- ✅ Structured data representation with the Composite pattern  
- ✅ Manual Iterator for accessing dataset records  
- ✅ Statistical analysis (sum, average, min, max) on numeric columns  
- ✅ Centralized Exception Shielding with clean runtime error reporting  

---

## 💡 Design Patterns Used

### 🏭 Factory Method Pattern
- **Classes**: `ParserFactory`, `Parser<T>`, `CsvParser`
- **Purpose**: Create parsers dynamically based on file type (`csv`, extensible to `json`, `xml`, etc.)

### 🌿 Composite Pattern
- **Interface**: `DatasetComponent`
- **Leaf**: `DataRecord`
- **Composite**: `Dataset`
- **Purpose**: Treat single records and record groups uniformly, allowing recursive traversal.

### 🔁 Iterator Pattern (Manual)
- **Interface**: `RecordIterator`
- **Implementation**: `DatasetIterator`
- **Purpose**: Traverse `Dataset` while encapsulating its internal structure.

### 🛡️ Exception Shielding Pattern
- **Class**: `ExceptionManager`
- **Purpose**: Log internal errors and rethrow generic messages to shield internal logic from the user.

---

## ⚙️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/yourusername/csv-data-analyzer.git
cd csv-data-analyzer
```

2. Compile and run (Java 17+):
```bash 
javac -d out $(find src -name "*.java")
java -cp out it.emanuelebachetti.csvdataanalyzer.App
```

3. Place your input .csv files in a resources/ folder (to be created).

## Testing

## Author