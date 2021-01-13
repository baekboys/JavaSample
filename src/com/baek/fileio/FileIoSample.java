package com.baek.fileio;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIoSample {
	public static void main(String[] args) throws IOException {

		PrintWriter pw = null;
		String file_name = "D:/Output.txt";

		try {
			// 파일생성
			pw = new PrintWriter(new FileOutputStream(file_name));
			for (int i = 1; i < 11; i++) {
				String data = i + " 번째 줄입니다.";
				pw.println(data);
			}
			pw.close();

			// 파일에 추가
			PrintWriter pw2 = new PrintWriter(new FileWriter(file_name, true));
			for (int i = 11; i < 21; i++) {
				String data = i + " 번째 줄입니다.";
				pw2.println(data);
			}
			pw2.close();

			// 파일 읽기
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			System.out.println(file_name + "파일 읽기 시작!!!");
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}finally {
			if(pw != null) pw.close(); //반드시 닫는다.
		}



	}
}