package com.tarekkma.dsa;

import java.util.Comparator;

public final class Utils {

    private Utils() {
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static <T> boolean less(T v, T w, Comparator<T> comparator) {
        return comparator.compare(v, w) < 0;
    }

    public static <T> void exch(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
