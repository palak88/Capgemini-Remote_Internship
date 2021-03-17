package com.cg.eis.util;

import java.util.Scanner;

//Input utility class
public class InputUtil {
	
	private static Scanner scanner=null;

	public static Scanner getScanner() {

		if (null == scanner)
			return new Scanner(System.in);
		else
			return scanner;
	}
}
