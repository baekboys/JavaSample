package com.baek.algorithm.sort;

public class MergeSort implements Sort {

    @Override
    public void DoSort(int[] array) {
        int[] tmp = new int[array.length];
        sort(array, tmp,0,array.length - 1);
    }

    private void sort(int[] array, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(array, tmp, start, mid);
            sort(array, tmp, mid + 1, end);
            merge(array, tmp, start, mid, end);
        }
    }

    private void merge(int[] array, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = array[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                array[index] = tmp[part1];
                part1++;
            } else {
                array[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0 ; i <= mid - part1 ; i++) {
            array[index + i] = tmp[part1 + i];
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};

        Sort sort = new MergeSort();
        sort.DoSort(array);
        System.out.print("결과 : ");
        sort.DoPrintArray(array, 5);
    }
}
