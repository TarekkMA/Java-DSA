package com.tarekkma.dsa.select;

import com.tarekkma.dsa.shuffle.FisherYatesShuffle;
import com.tarekkma.dsa.shuffle.Shuffle;

import static com.tarekkma.dsa.sort.SortUtils.exch;
import static com.tarekkma.dsa.sort.SortUtils.less;

public class Quickselect implements Select {

    private final Shuffle shuffle;

    public Quickselect() {
        this.shuffle = new FisherYatesShuffle();
    }

    public Quickselect(Shuffle shuffle) {
        this.shuffle = shuffle;
    }

    @Override
    public <T extends Comparable<T>> T select(T[] a, int k) {
        shuffle.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);

            if      (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else            return a[k];
        }
        return a[k];
    }


    private <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo; // pivot
        int j = hi + 1;
        while (true) {
            // find item on left to swap
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            // find item on right to swap
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break; // check if pointers cross

            exch(a, i, j);
        }

        exch(a, lo, j); // swap with partitioning item
        return j;       // return the index of the item we now know to be in place
    }
}
