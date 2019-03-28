package com.file;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Flejava {
	
	private static Formatter x;
	public static void main(String[] args) throws IOException {

		try {
			x = new Formatter("index.txt");
		}
			   
		catch(Exception e)
		{
			System.out.println("you have no error");
		}

}
}
