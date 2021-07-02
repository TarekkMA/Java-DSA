package com.tarekkma.dsa.sort;

public interface Sort {
    <T extends Comparable<T>> void sort(T[] a);
}
