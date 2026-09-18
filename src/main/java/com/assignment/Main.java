package com.assignment;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        Random random = new Random(42);

        System.out.println("==========================================================================");
        System.out.printf("%-12s | %-12s | %-12s | %-15s | %-10s%n",
                "Algorithm", "Array Size", "Time (ms)", "Comparisons", "Max Depth");
        System.out.println("==========================================================================");

        for (int size : sizes) {
            int[] original = random.ints(size, -100000, 100000).toArray();

            // 1. MergeSort Benchmark
            int[] arrMerge = original.clone();
            Metrics m1 = new Metrics();
            m1.startTimer();
            MergeSort.sort(arrMerge, m1);
            m1.stopTimer();
            printRow("MergeSort", size, m1);

            // 2. QuickSort Benchmark
            int[] arrQuick = original.clone();
            Metrics m2 = new Metrics();
            m2.startTimer();
            QuickSort.sort(arrQuick, m2);
            m2.stopTimer();
            printRow("QuickSort", size, m2);

            // 3. QuickSelect Benchmark (k = size / 2)
            int[] arrSelect = original.clone();
            Metrics m3 = new Metrics();
            m3.startTimer();
            int kth = QuickSelect.select(arrSelect, size / 2, m3);
            m3.stopTimer();
            printRow("QuickSelect", size, m3);

            System.out.println("--------------------------------------------------------------------------");
        }
    }

    private static void printRow(String algo, int size, Metrics m) {
        System.out.printf("%-12s | %-12d | %-12d | %-15d | %-10d%n",
                algo, size, m.getTimeMs(), m.comparisons, m.maxDepth);
    }
}