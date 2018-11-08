package Lab1;

import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Declaring the array which will contain all the data that is read from the file.
		ArrayList<String> data = new ArrayList<String>();
		
		//Declaring the array which will contain all the data that is read from the file,
		//and broken down according to spaces and symbols.
		ArrayList<String> total = new ArrayList<String>();
		
		//Declaring the array which will contain all the final data after it has been tokenized.
		ArrayList<String> final_data = new ArrayList<String>();
		
		//Now reading data from the file.
		//Calling the static method of the InOut class, passing in the file directory
		//and getting an array of strings for each line as a return.
		data = InOut.readfile("D:\\Uni Work Doe\\Programming Languages\\Lab\\Lab 1\\project 10\\Square\\Main.jack");
		
		//Printing out the initial array
//		for (int i=0; i<data.size(); i++)
//		{
//		System.out.println(data);
//		}
		
		//Calling the breakline function on the input array of strings,
		//which basically breaks down each line into the individual tokens.
		for (int z=0; z<data.size(); z++)
		{
			Tokenizer.breakline(data.get(z));
		}

		//The newly created array with the broken down tokens is now called from
		//the tokenizer class to the main. This array is a static variable in the tokenizer
		//class.
		total = Tokenizer.returndata();
		
		//Adding the begin tag first
		final_data.add("<begin>");
		
		for (int d =0; d<total.size(); d++)
		{
			final_data.add(Tokenizer.gettoken(total.get(d)));
		}
		
		//Adding the end tag after all the data has been input
		final_data.add("</end>");
		
		//Printing out all the final data.
		for (int x=0; x<final_data.size(); x++)
		{
			System.out.println(final_data.get(x));
		}
		
		//Exporting the final data to a file, to be used later.
		InOut.writetofile(final_data, "output.xml");
		
	}

}
