package dev.ep2.battleship.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileHelper {

		
	public static String loadFileAsString(String path) {

		
		StringBuilder builder = new StringBuilder();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			
			reader.readLine();
			line = reader.readLine();
			
			Scanner input = new Scanner(line);
			int width = input.nextInt();
			int height = input.nextInt();
			
			builder.append(line + "\n");
			
			reader.readLine();
			reader.readLine();
			
			for(int y = 0; y < height; y++) {
				line = reader.readLine();
				builder.append(line + "\n");
			}
			
			reader.readLine();
			reader.readLine();
			
			while((line = reader.readLine()) != null)
				builder.append(line + "\n");
			
			System.out.println(builder);
			
			reader.close();
			
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
