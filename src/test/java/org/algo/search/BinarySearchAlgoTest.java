package org.algo.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchAlgoTest {

    BinarySearchAlgo binarySearchAlgo;

    @BeforeEach
    public void init() {
        binarySearchAlgo = new BinarySearchAlgo();
    }

    @Test
    void findMid() {
        int[] sortedArray = new int[]{1, 2, 3, 4, 5};
        Assertions.assertTrue(binarySearchAlgo.isAvailable(sortedArray, 5));
        Assertions.assertTrue(binarySearchAlgo.isAvailable(sortedArray, 1));
        Assertions.assertTrue(binarySearchAlgo.isAvailable(sortedArray, 3));
        Assertions.assertFalse(binarySearchAlgo.isAvailable(sortedArray, 6));
    }
}