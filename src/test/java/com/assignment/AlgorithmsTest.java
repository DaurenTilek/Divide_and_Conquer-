package com.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmsTest {

    private Metrics metrics;

    @BeforeEach
    void setUp() {
        metrics = new Metrics();
    }

    @Test
    void testMergeSortBasic() {
        int[] arr = {5, 2, 8, 1, 9, 4};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        MergeSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
        assertTrue(metrics.comparisons > 0);
    }

    @Test
    void testMergeSortWithDuplicates() {
        int[] arr = {4, 2, 4, 1, 2, 3, 4};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        MergeSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testQuickSortBasic() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
        assertTrue(metrics.comparisons > 0);
    }

    @Test
    void testQuickSortLargeRandomArray() {
        Random rnd = new Random(42);
        int[] arr = rnd.ints(1000, -10000, 10000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        QuickSort.sort(arr, metrics);

        assertArrayEquals(expected, arr);
        assertTrue(metrics.maxDepth <= 2 * (Math.log(arr.length) / Math.log(2)) + 5);
    }

    @Test
    void testQuickSelect() {
        int[] arr = {9, 1, 0, 2, 3, 8, 7, 4, 6, 5};

        int kthElement = QuickSelect.select(arr.clone(), 4, metrics);
        assertEquals(4, kthElement);

        int minElement = QuickSelect.select(arr.clone(), 0, metrics);
        assertEquals(0, minElement);

        int maxElement = QuickSelect.select(arr.clone(), arr.length - 1, metrics);
        assertEquals(9, maxElement);
    }
}