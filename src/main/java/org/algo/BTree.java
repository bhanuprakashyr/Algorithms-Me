package org.algo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class BTree<T extends Comparable<T>> implements ITree<T> {

    private int minKeySize;
    private int maxKeySize;
    private int minChildrenSize;
    private int maxChildrenSize;

    private Node<T> root = null;
    private int size = 0;

    public BTree() {
    }


    private static class Node<T extends Comparable<T>> {
        private T[] keys = null;
        private int keySize = 0;
        private Node<T>[] children = null;
        private int childrenSize = 0;
        private Node<T> parent = null;

        /*private Comparator<Node<T>> comparator = new Comparator<Node<T>>() {
            @Override
            public int compare(Node<T> node1, Node<T> node2) {
                return 0;
            }
        }*/

        private T getKey(int index){
            return keys[index];
        }

        private int indexOf(T value){
            for (int i=0;i<keySize; i++){
                if(keys[i].equals(value)) return i;
            }
            return -1;
        }

        private void addKey(T value){
            keys[keySize++] = value;
            Arrays.sort(keys,0,keySize);
        }

        private T removeKey(T value) {
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

        private T removeKey(int index){
            if (index >= keySize){
                return null;
            }

            T removed = keys[index];
            for (int i=index + 1; i < keySize ; i++){
                keys[i - 1] = keys[i];
            }

            keys[keySize] = null;
            keySize --;
            return removed;

        }

        private void addChild(Node<T> child) {
            child.parent = this;
            children[childrenSize++] = child;
            Arrays.sort(children, 0, childrenSize, null);
        }

    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public boolean contains(T Value) {
        return false;
    }


    @Override
    public Collection toCollection() {
        return List.of();
    }
}
