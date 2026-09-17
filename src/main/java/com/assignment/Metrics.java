package com.assignment;

public class Metrics {
    public long comparisons = 0;
    public int maxDepth = 0;
    private int currentDepth = 0;
    private long startTime = 0;
    private long elapsedTime = 0;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        elapsedTime = System.nanoTime() - startTime;
    }

    public long getTimeMs() {
        return elapsedTime / 1_000_000;
    }

    public void reset() {
        comparisons = 0;
        maxDepth = 0;
        currentDepth = 0;
        startTime = 0;
        elapsedTime = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        currentDepth--;
    }
}