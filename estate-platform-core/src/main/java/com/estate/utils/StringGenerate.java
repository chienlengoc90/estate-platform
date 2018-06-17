package com.estate.utils;

import java.util.Random;

public class StringGenerate {
	
	public static String generateValue(int lenght) {
		String pass = "";
		final String alphabet = "0123456789ABCDE";
		final int N = alphabet.length();
		Random r = new Random();
		for (int i = 0; i <= lenght; i++) {
			pass += alphabet.charAt(r.nextInt(N));
		}
		return pass;
	}
}
