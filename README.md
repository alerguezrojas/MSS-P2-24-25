# MSS-P2-24-25  
**University:** Universidad de La Laguna  
**Degree:** Grado en Ingeniería Informática  
**Course:** Modelado de Sistemas Software (2024/2025)  
**Author:** Alejandro Rodríguez Rojas  
**Mail:** alu0101317038@ull.edu.es

---

# 📊 Dataset Manager - Java

This project is a Java-based tool to **load**, **normalize**, **edit**, and **save** datasets from CSV files using a simple interactive console interface. It was built as part of a university practical assignment and is designed for clarity, maintainability, and extensibility.

---

## ✅ Features

- Load a dataset from a CSV file (e.g., `iris.csv`)
- Automatically normalize all numeric attributes using min-max normalization
- Add new instances manually via keyboard input
- Remove or update existing instances by index
- Save the modified dataset to a new CSV file
- Input validation and helpful prompts
- Clean and simple object-oriented structure

---

## 🗂️ Project Structure

```
/MSS-P2-24-25/
│
├─ /src/                      # Source code
│   ├─ Main.java
│   ├─ Dataset.java
│   ├─ Instance.java
│   └─ InstanceFactory.java
│
├─ /data/                     # CSV input files
│   └─ iris.csv
```

---

## 🚀 How to Run

### 🔧 Using IntelliJ IDEA

1. Open the project folder in IntelliJ
2. Right-click on `Main.java` > **Run 'Main.main()'**
3. Follow the prompts in the terminal

> 💡 Make sure `iris.csv` is placed in the `data/` folder

---

### 🖥️ Sample Execution

```
Enter the path to the CSV file (e.g., data/iris.csv): data/iris.csv
Loading dataset...
Dataset successfully loaded.

Original dataset content:
[5.1, 3.5, 1.4, 0.2] => Iris-setosa
[4.9, 3.0, 1.4, 0.2] => Iris-setosa
[4.7, 3.2, 1.3, 0.2] => Iris-setosa
...

Normalized dataset content:
[0.222222, 0.625000, 0.067797, 0.041667] => Iris-setosa
[0.166667, 0.416667, 0.067797, 0.041667] => Iris-setosa
[0.111111, 0.500000, 0.050847, 0.041667] => Iris-setosa
...

Do you want to add a new instance? (y/n)
y

Number of attributes: 4
Attribute 1: 6.3
Attribute 2: 3.3
Attribute 3: 6.0
Attribute 4: 2.5
Label: Iris-virginica
Instance added and normalized successfully.

Do you want to remove an instance? (y/n)
y

Index to remove [0 - 149]: 2
Instance removed.

Do you want to update an instance? (y/n)
y

Index to update [0 - 148]: 1
Number of attributes: 4
Attribute 1: 5.5
Attribute 2: 3.7
Attribute 3: 1.5
Attribute 4: 0.3
Label: Iris-setosa
Instance updated and normalized.

Do you want to save the dataset? (y/n)
y

Output filename (e.g., iris_out.csv): iris_out.csv
Dataset saved successfully.

```

---

## 📚 Classes Overview

- `Main.java` – Manages user interaction and program flow
- `Dataset.java` – Stores and manages a list of instances
- `Instance.java` – Represents a single row in the dataset
- `InstanceFactory.java` – Utility class to create instances from CSV or user input

---

## 🛠 Requirements

- Java 17+ recommended
- IntelliJ IDEA (or any IDE that supports Java projects)
- CSV file with comma-separated values and class label as the last column

---

## 🧠 Future Extensions

- Add a `KNNClassifier` class to support classification
- Implement distance metrics interface (e.g., Euclidean, Manhattan)


---


    
