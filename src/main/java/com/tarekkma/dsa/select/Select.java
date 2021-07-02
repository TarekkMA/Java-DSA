package com.tarekkma.dsa.select;

public interface Select {
    <T extends Comparable<T>> T select(T[] a, int k);
}
