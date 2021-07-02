package com.tarekkma.dsa.shuffle;

import java.util.Random;

import static com.tarekkma.dsa.sort.SortUtils.exch;

public class FisherYatesShuffle implements Shuffle {
    public final Random random;

    public FisherYatesShuffle() {
        random = new Random();
    }

    @Override
    public <T> void shuffle(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = random.nextInt(i + 1);
            exch(a, i, r);
        };
    }
}
