package com.baek.algorithm;

public class BinarySearch {
    public int DoSearch(int serachNumber, int[] array) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            int midValue = array[mid];

            if (midValue == serachNumber) {
                return mid;
            }
            if (midValue > serachNumber) {
                high = mid - 1;
            }
            if (midValue < serachNumber) {
                low = mid + 1;
            }
        }

        throw new IllegalStateException("숫자가 없습니다.");
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.DoSearch(12, array);

        System.out.println("result : " + result);
    }
}
