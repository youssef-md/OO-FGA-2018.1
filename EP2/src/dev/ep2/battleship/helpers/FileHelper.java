package dev.ep2.battleship.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHelper {

	private static BufferedReader bufferReader;
	private FileReader fileReader;
	
	public FileHelper(String path) {
				
		try {
			
			fileReader = new FileReader(path);
			bufferReader = new BufferedReader(fileReader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getnumberOfTargetXandY() {
				
		int numberOfTargetX = 0;
		int numberOfTargetY = 0;
		String line = "";
		StringBuilder builder = new StringBuilder();
		
		try {
			
			bufferReader.readLine();
			line = bufferReader.readLine();
			builder.append(line + "\n");
			
			System.out.println(builder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
		
	}	
	
	
	public static int parseInt(String number) {
		
		try {
			return Integer.parseInt(number);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
