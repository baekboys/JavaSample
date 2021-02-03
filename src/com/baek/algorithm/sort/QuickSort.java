package com.baek.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort implements Sort {

    @Override
    public void DoSort(int[] array) {
        sort(array, 0, array.length-1);
    }

    private void sort(int[] array, int left, int right) {
        int l = left;
        int r = right;

        int pivot = array[(left + right) / 2];

        do {
            while (array[l] < pivot) l++;
            while (array[r] > pivot) r--;

            if (l <= r) {
                DoSwap(array, l, r);
                l++;
                r--;
            }

            DoPrintArray(array, 5);

        } while (l <= r);

        if(left < r) sort(array, left, r);
        if(l < right) sort(array, l, right);
    }

    public static void main(String[] args) {
        int[] array = {52, 10, 26, 4, 16, 12, 9, 30, 7};
        //int[] array = {66, 10, 1, 34, 5, -10};

        Sort sort = new QuickSort();
        sort.DoSort(array);
        System.out.print("결과 : ");
        sort.DoPrintArray(array, 5);
    }
}
