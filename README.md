# CCS2300 Assignment 1 - Smart City & Data Sorter

This repository contains the implementation for CCS2300 Assignment 1, featuring three integrated modules for city planning, data sorting, and performance analysis.

## How to Run

To compile and run the entire project, follow these steps from the root directory:

1. **Compile all modules:**
   ```powershell
   javac src/*.java src/Module1/*.java src/Module2/*.java src/Module3/*.java
   ```

2. **Run the main menu:**
   ```powershell
   java -cp src Main
   ```

---

## Project Structure

The project is organized into a single entry point that manages all three modules:

- **`src/Main.java`**: The universal entry point providing a menu to access all modules.
- **`src/Module1/`**: Smart City Route Planner.
- **`src/Module2/`**: Data Sorter & Performance.
- **`src/Module3/`**: Algorithm Performance Analysis.

---

## Detailed Module Explanation

### 1. Module 1: Smart City Route Planner
This module focuses on hierarchical data management and network connectivity.
- **Location Tree (`LocationTree.java`)**: Stores city locations (like Colombo, Kandy, etc.) in a Binary Search Tree (BST) structure. This allows for efficient searching and sorted retrieval of city names.
- **Route Graph (`RouteGraph.java`)**: Manages the physical connections (roads) between locations using an Adjacency List representation.
- **Workflow**:
    1. Users add locations to the Tree.
    2. Data is "mapped" from the Tree to the Graph.
    3. Users define roads (edges) between those locations.
    4. **BFS Traversal**: Users can simulate travel by performing a Breadth-First Search to see reachable locations from a starting point.

### 2. Module 2: Data Sorter & Performance
This module demonstrates the efficiency of different sorting algorithms.
- **Algorithms Included**: 
    - **Bubble Sort**: Simple comparison-based sort ($O(n^2)$).
    - **Merge Sort**: Divide-and-conquer algorithm ($O(n \log n)$).
    - **Quick Sort**: Highly efficient partitioning algorithm ($O(n \log n)$ average).
- **Features**:
    - **Manual Input**: Type your own numbers to see them sorted.
    - **Random Generation**: Generate large datasets automatically to see real-world performance.
    - **Comparison Table**: Displays the time taken by each algorithm in nanoseconds for a fair comparison.

### 3. Module 3: Algorithm Performance Analysis
A controlled laboratory-style analysis of search and sort operations.
- **Sorting**: Uses Quick Sort to organize data across varied sizes (100, 500, and 1000 elements).
- **Searching**: Uses **Binary Search** ($O(\log n)$) to find specific elements within the sorted data.
- **Analysis**: Outputs a clear table showing how execution time scales as the dataset size grows, highlighting the logarithmic nature of binary search compared to sorting.

---

## Visual Interface (CLI Examples)

Below are text-based representations of what you will see when running the application.

### Main Menu
```text
=============================================
       CCS2300 ASSIGNMENT MAIN MENU          
=============================================
1. Module 1: Smart City Route Planner
2. Module 2: Data Sorter & Performance
3. Module 3: Algorithm Performance Analysis
4. Exit
Select a module to run: 
```

### Module 2: Performance Comparison Table
```text
=================================================
       ALGORITHM PERFORMANCE COMPARISON          
=================================================
Algorithm Name       | Time (Nanoseconds)  
-------------------------------------------------
Bubble Sort          | 1377800             
Merge Sort           | 45600               
Quick Sort           | 32100               
=================================================
```

### Module 3: Performance Analysis
```text
----------------------------------------------
Size	Sort Time(ns)	Search Time(ns)
----------------------------------------------
100	    125400		    1800
500	    456200		    2100
1000	891500		    2400
----------------------------------------------
```
