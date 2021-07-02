package com.tarekkma.dsa.sort;

public interface ShellSortIncrementSequence {
    int getMaxH(int n);

    int getPreviousH(int currentH);

    ShellSortIncrementSequence KNUTH_FORMULA = new ShellSortIncrementSequence() {
        @Override
        public int getMaxH(int n) {
            int h = 1;
            while (h < n / 3) h = 3 * h + 1;
            return h;
        }

        @Override
        public int getPreviousH(int currentH) {
            return currentH / 3;
        }
    };

    ShellSortIncrementSequence INSERTION_SORT = new ShellSortIncrementSequence() {
        @Override
        public int getMaxH(int n) {
            return 1;
        }

        @Override
        public int getPreviousH(int currentH) {
            return 0;
        }
    };
}
