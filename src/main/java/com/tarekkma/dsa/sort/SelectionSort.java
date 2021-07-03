package com.tarekkma.dsa.sort;

import static com.tarekkma.dsa.Utils.*;


/**
 * Analysis:
 *  - 1/2 N^2 Compares
 *  - N       Exchanges
 */
public class SelectionSort implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIndex = findMinIndex(a, i);
            exch(a, minIndex, i);
        }
    }

    private <T extends Comparable<T>> int findMinIndex(T[] a, int startingIndex) {
        int minIndex = startingIndex;
        for (int i = startingIndex + 1; i < a.length; i++)
            if (less(a[i], a[minIndex]))
                minIndex = i;

        return minIndex;
    }
}
