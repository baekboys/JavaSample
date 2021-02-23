package com.baek.algorithm;

public class Combination {
    public static void main(String[] ar){
        Combination ex = new Combination();
        int[] arr = { 1, 8, 3, 2};
        int n = arr.length;
        int r = 4;
        int[] combArr = new int[n];

        System.out.println("---------------------------------------------");
        ex.doCombination(combArr, n, r, 0, 0, arr);
        System.out.println("---------------------------------------------");
        ex.reCombination(combArr, n, r, 0, 0);
    }

    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        if(r == 0){
            for(int i=0; i<index; i++) System.out.print(arr[combArr[i]] + " ");
            System.out.println();
        }else if(target == n) return;
        else{
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i)
            doCombination(combArr, n, r, index, target+1, arr); //(ii)
        }
    }

    //중복 조합 (순서관심없고 뽑은 유무만 생각 + 자기자신도 포함)
    private void reCombination(int[] reComArr, int n, int r, int index, int target) {
        if(r==0){
            for(int i : reComArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        if(target == n)return;

        reComArr[index] = target;
        reCombination(reComArr, n, r-1, index+1, target);//뽑는경우
        reCombination(reComArr, n, r, index, target+1);//안뽑는경우

    }
}