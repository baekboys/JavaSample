package com.baek.algorithm.sort;

public class BubbleSort implements Sort {

    @Override
    public void DoSort(int[] array) {
        int size = array.length;

        for(int i=0; i < size-1; i++) {
            System.out.printf("\n버블 정렬 %d 단계 : ", i + 1);
            for(int j=0; j < size -1 -i; j++) {
                if(array[j] > array[j+1]) {
                    DoSwap(array, j, j+1);
                }
                System.out.printf("\n");
                DoPrintArray(array, 5);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {52, 10, 26, 4, 16, 12, 9, 30, 7};

        Sort sort = new BubbleSort();
        sort.DoSort(array);
        System.out.print("결과 : ");
        sort.DoPrintArray(array, 5);
    }
}
