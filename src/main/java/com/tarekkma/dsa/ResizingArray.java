package com.tarekkma.dsa;

import java.util.Arrays;

public class ResizingArray<Item> {
    private Item[] items;
    private int size;

    public ResizingArray() {
        items = (Item[]) new Object[2];
        size = 0;
    }

    public void push(Item item) {
        if (size >= items.length)
            resize(items.length * 2);
        items[size++] = item;
    }

    public Item pop() {
        Item item = items[--size];
        if (size > 0 && size <= items.length / 4)
            resize(items.length / 2);
        return item;
    }

    public Item get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }

    private void resize(int newCapacity) {
        items = Arrays.copyOf(items, newCapacity);
    }
}
