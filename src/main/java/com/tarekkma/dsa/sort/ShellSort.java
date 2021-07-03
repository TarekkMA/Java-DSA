package com.tarekkma.dsa.sort;

import static com.tarekkma.dsa.Utils.exch;
import static com.tarekkma.dsa.Utils.less;

/**
 * Analysis: (Still open, dependant on the increment sequence)
 * Accurate model has not yet been discovered
 *
 * Worst case for knuth formula is N^(3/2)
 *
 * Shell sort is useful when array is not huge
 *              Tiny, fixed footprint for code (embedded systems)
 */
public class ShellSort implements Sort {

    public final ShellSortIncrementSequence incrementSequence;

    public ShellSort() {
        this.incrementSequence = ShellSortIncrementSequence.KNUTH_FORMULA;
    }

    public ShellSort(ShellSortIncrementSequence incrementSequence) {
        this.incrementSequence = incrementSequence;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;

        int h = incrementSequence.getMaxH(N);

        while (h >= 1){
            for (int i = 0; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h]))
                        exch(a, j, j - h);
                    else
                        break;
                }
            }
            h = incrementSequence.getPreviousH(h);
        }
    }
}
