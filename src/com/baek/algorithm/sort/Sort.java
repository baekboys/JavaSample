package com.baek.algorithm.sort;

public interface Sort {
    public void DoSort(int[] array);

    public default void DoSwap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public default void DoPrintArray(int[] arr, int tabSize) {
        for(int i = 0; i < arr.length ; i++) {
            System.out.printf("%" + tabSize + "d", arr[i]);
        }
        System.out.println("");
    }
}
