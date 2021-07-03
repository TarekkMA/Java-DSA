package com.tarekkma.dsa.sort;

import static com.tarekkma.dsa.Utils.exch;
import static com.tarekkma.dsa.Utils.less;

/**
 * Analysis:
 *  - Randomly ordered district keys:
 *      * 1/4 N^2 Compares
 *      * 1/4 N^2 Exchanges
 *  - Best Case (where the array is in ascending ordered)
 *      * N-1 Compares
 *      * 0 Exchanges
 *  - Worst Case (where the array is in descending order)
 *      * 1/2 N^2 Compares
 *      * 1/2 N^2 Exchanges
 *  - Partially sorted arrays: (number of inversions is <= cN)
 *      * linear time
 *      * number of compares equals the number of inversions
 */
public class InsertionSort implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else
                    break;
            }
        }
    }
}
