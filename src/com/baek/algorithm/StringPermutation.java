package com.baek.algorithm;

/**
 * 문자열 순열
 */
public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        stringPermutation.permutation("","ABCD");
    }
    public void permutation(String str) {
        permutation("", str);
    }

    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
