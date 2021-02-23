package com.baek.algorithm;


/**
 * 순열 : 순서 상관있고, 뽑는 경우
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation ex = new Permutation();
        int[] arr = {1, 3, 5, 7};

        int n = arr.length;
        int r = 4;
        int[] combArr = new int[r];
        ex.doCombination(combArr, arr, n, r, 0, 0);
    }
    public void doCombination(int[] combArr, int[] arr, int n, int r, int index, int target) {
        if(r == 0) {
            doPermutation(combArr, 0);
            System.out.println("------------------------");
        } else if(target == n)
            return;
        else {
            combArr[index] = arr[target];
            doCombination(combArr, arr, n, r-1, index+1, target+1);
            doCombination(combArr, arr, n, r, index, target+1);
        }
    }
    public void doPermutation(int[] arr, int startIdx) {
        int length = arr.length;
        if(startIdx == length - 1) {
            for(int item: arr)
                System.out.print(item + " ");
            System.out.println();
            return;
        }
        for(int i = startIdx; i < length; i++) {
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx + 1);
            swap(arr, startIdx, i);
        }
    }
    public void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

}