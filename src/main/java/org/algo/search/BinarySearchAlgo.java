package org.algo.search;

public class BinarySearchAlgo {

    public boolean isAvailable(int[] sortedArray, int searchKey) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == searchKey) {
                return true;
            } else if (searchKey > sortedArray[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
