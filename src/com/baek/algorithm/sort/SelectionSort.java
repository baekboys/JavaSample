package com.baek.algorithm.sort;

public class SelectionSort implements Sort {

    @Override
    public void DoSort(int[] array) {
        int i, j, min;

        for(i = 0; i < array.length - 1; i++) {
            min = i;
            for(j = i+1; j < array.length ; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }

            DoSwap(array, min, i);

            System.out.printf("\nSelectionSort %d 단계 : ", i+1);
            DoPrintArray(array, 5);
        }
    }

    public static void main(String[] args) {
        int[] array = {52, 10, 26, 4, 16, 12, 9, 30, 7};

        Sort sort = new SelectionSort();
        sort.DoSort(array);
        System.out.print("결과 : ");
        sort.DoPrintArray(array, 5);
    }
}
