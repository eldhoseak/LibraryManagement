package com.library.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {
	public static String acceptString() {
		String stringData = null;
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			stringData=input.readLine();
        }
        catch(IOException ioException){
			System.out.println("Error in accepting data.");
		}
		finally {
			input=null;
		}
		return stringData;
	}
}
