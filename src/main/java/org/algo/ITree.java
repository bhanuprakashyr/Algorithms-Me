package org.algo;

import java.util.Collection;

public interface ITree<T> {
    void add();
    void remove();
    void clear();
    int size();
    boolean validate();
    boolean contains(T Value);
    Collection<T> toCollection();
}
