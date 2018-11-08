//Hassan M. Khan
//Principles of Programming Languages
//Lab 1

package Lab1;

import java.util.*;
import java.io.*;

//This class will read the input file, and then return an Array of Strings,
//with each element of the Array being one line of the input file.

//The code for reading and writing to a file has been implemented from Stackoverflow.

public final class InOut {

	public static ArrayList<String> readfile(String a)
	{
		ArrayList<String> data = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(a))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       //Processing the line
		    	
		    	data.add(line.trim());
		    }
		}catch (Exception e)
		{
			System.err.println(e.getMessage()); 
		}
		
		return data;
	}
	
	public static void writetofile(ArrayList<String> b, String c) throws IOException
	{
		
			File fout = new File(c);
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 
			for (int i = 0; i < b.size(); i++) {
				bw.write(b.get(i));
				bw.newLine();
			}
		 
			bw.close();
		
	}
}
