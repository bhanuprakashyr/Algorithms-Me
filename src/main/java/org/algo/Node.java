package org.algo;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Node<T extends Comparable<T>> {
    private T[] keys;
    private int keySize;
    private Node<T> parent;
    private Node<T>[] children;
    private int childrenSize;

    public Node(int maxKeySize, int maxChildrenSize, Node<T> parent) {
        this.keys = (T[]) new Comparable[maxKeySize + 1];
        this.keySize = 0;
        this.parent = parent;
        this.children = new Node[maxChildrenSize + 1];
        this.childrenSize = 0;
    }

    private final Comparator<Node<T>> comparator = comparing(node -> node.getKey(0));

    public T getKey(int index) {
        if (index >= keySize)
            return null;
        return keys[index];
    }

    public int indexOf(T value) {
        for (int i = 0; i < keySize; i++) {
            if (keys[i].equals(value)) return i;
        }
        return -1;
    }

    public void addKey(T value) {
        keys[keySize++] = value;
        Arrays.sort(keys, 0, keySize);
    }

    public T removeKey(T value) {
        boolean found = false;
        T removed = null;
        for (int i = 0; i < keySize; i++) {
            if (keys[i].equals(value)) {
                found = true;
                removed = keys[i];
            } else if (found) {
                keys[i - 1] = keys[i];
            }
        }
        if (found) {
            keySize--;
            keys[keySize] = null;
        }
        return removed;
    }

    public T removeKey(int index) {
        if (index >= keySize) {
            return null;
        }

        T removed = keys[index];
        for (int i = index + 1; i < keySize; i++) {
            keys[i - 1] = keys[i];
        }

        keySize--;
        keys[keySize] = null;
        return removed;

    }

    public void addChild(Node<T> child) {
        child.parent = this;
        children[childrenSize++] = child;
        Arrays.sort(children, 0, childrenSize, comparator);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("keys=[");
        for (int i = 0; i < numberOfKeys(); i++) {
            T value = getKey(i);
            builder.append(value);
            if (i < numberOfKeys() - 1)
                builder.append(", ");
        }
        builder.append("]\n");

        if (parent != null) {
            builder.append("parent=[");
            for (int i = 0; i < parent.numberOfKeys(); i++) {
                T value = parent.getKey(i);
                builder.append(value);
                if (i < parent.numberOfKeys() - 1)
                    builder.append(", ");
            }
            builder.append("]\n");
        }

        if (children != null) {
            builder.append("keySize=").append(numberOfKeys()).append(" children=").append(numberOfChildren()).append("\n");
        }

        return builder.toString();
    }

    private int numberOfKeys() {
        return keySize;
    }

    private int numberOfChildren() {
        return childrenSize;
    }

    public Node<T> getChild(int index) {
        if (index >= keySize)
            return null;
        return children[index];
    }

    public int getKeySize() {
        return keySize;
    }

}
