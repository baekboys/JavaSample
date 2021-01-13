package com.baek.fileio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IoStreamSample {

	public static void main(String[] args) throws Exception {
		InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        System.out.print("br>");
        String a = br.readLine();
        System.out.println(a);
        
        System.out.println();
        System.out.print("Scanner>");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next());
    }

}
