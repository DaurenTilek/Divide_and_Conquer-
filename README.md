 Getting Started

Running Benchmarks
To run the algorithms benchmark and generate performance metrics:

Compile and run `Main.java`.
The program will run test suites against various array distributions (Random, Sorted, Reverse Sorted, Duplicates) and sizes ($N = 10^3, 10^4, 10^5, \dots$).
Results will be logged to the console and saved to `results.csv`.

To run unit tests and verify algorithmic correctness:
Execute `AlgorithmsTest.java` using JUnit 5 in your IDE or terminal.

Key Implementation Details

3-Way Partitioning**: Handles datasets with high duplicate element density efficiently without worsening to $O(N^2)$ complexity.
Tail-Call Optimization**: Prevents `StackOverflowError` in QuickSort during worst-case inputs by processing the smaller partition recursively first.
Cutoff Strategy**: Uses InsertionSort for array sizes $N \le 15$ in MergeSort to minimize recursive function call overhead.

Author
Tilek Dauren — Software Engineering Student at Astana IT University
GitHub [@DaurenTilek](https://github.com/DaurenTilek)
