package com.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateFile {

	List<String> lines = new ArrayList<String>();
	String line = null;

	public void doIt() {
		try {
			File f1 = new File("output.txt");
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("please enter old data: ");
			Scanner pr = new Scanner(System.in);
			String old_sc = pr.next();
			System.out.println("please enter replace data: ");
			String update_sc = pr.next();
			while ((line = br.readLine()) != null) {
				if (line.contains(old_sc))
					line = line.replace(old_sc, update_sc);
				lines.add(line);
			}
			fr.close();
			br.close();

			FileWriter fw = new FileWriter(f1);
			BufferedWriter out = new BufferedWriter(fw);
			for (String s : lines)
				out.write(s);
			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("******************File Opreration******************");
		System.out.println("1. File Write.");
		System.out.println("2. File Read.");
		System.out.println("3. File Update.");
		System.out.println("4. File Delete.");
		Scanner sw = new Scanner(System.in);
		while (true) {
			System.out.println("Please Enter a Number: ");
			int rw = sw.nextInt();
			switch (rw) {
			case 1:
				Scanner sc = new Scanner(System.in);
				String[] str = sc.nextLine().split(" ");
				try {
					FileWriter fw = new FileWriter("output.txt");
					for (int i = 0; i < str.length; i++) {
						fw.write(str[i] + " ");

					}
					System.out.println("writing successful");
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 2:
				File file = new File("output.txt");
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));

					String st;
					try {
						while ((st = br.readLine()) != null) {
							System.out.println(st);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 3:
				CreateFile fr = new CreateFile();
				fr.doIt();

				System.out.println("done");

				break;

			case 4:
				PrintWriter writer;
				try {
					writer = new PrintWriter("output.txt");
					writer.print("");
					writer.close();
					break;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}
}
