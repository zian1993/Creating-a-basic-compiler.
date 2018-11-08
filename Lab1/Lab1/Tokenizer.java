//Hassan M. Khan
//Principles of Programming Languages
//Lab 1

package Lab1;

import java.util.*;

public final class Tokenizer {
	
	//Declaring array which will contain all the parsed data.
	public static ArrayList<String> total = new ArrayList<String>();

	public static void breakline(String line)
	{
		int a=0;
		int b=line.length();
		ArrayList<Character> breaker = new ArrayList<Character>();
		
		String temp = new String();
		Package togoaway  = new Package();
		
		if (line.length() == 0)
			return;
		
		//Code to check for string
		if ((line.charAt(a))=='"')
		{
			breaker.add(line.charAt(a));
			a++;
			
			while (line.charAt(a)!='"')
			{
				breaker.add(line.charAt(a));
				a++;
			}
			
			//Adding the last "
			breaker.add(line.charAt(a));
			a++;
			
			for (int d=0; d<breaker.size(); d++)
			{
				temp = temp.concat(Character.toString(breaker.get(d)));
			}
			
			//Converting the read array of chars into a string
			togoaway.a = temp;
				
			//Converting the rest of the line into a string.
			if (line.charAt(a)==' ')
				a++;
			
			togoaway.b = line.substring(a, line.length());
			
			total.add(togoaway.a);
			
			if ((togoaway.b).length()!=0)
			{
				breakline(togoaway.b);
				return;
			}
			else
				return;
		}
		
		if (line.charAt(a) == ' ')
		{
			if ((a+1)>(line.length()-1))
				return;
			else
				a++;
		}
		
		int init_a = a;
		
		if ((line.charAt(a)=='(')||(line.charAt(a)==')')||(line.charAt(a)=='[')||(line.charAt(a)==']')||
				(line.charAt(a)=='{')||(line.charAt(a)=='}')||(line.charAt(a)==',')||
				(line.charAt(a)==';')||(line.charAt(a)=='=')||(line.charAt(a)=='.')||
				(line.charAt(a)=='+')||(line.charAt(a)=='-')||(line.charAt(a)=='*')||
				(line.charAt(a)=='/')||(line.charAt(a)=='&')||(line.charAt(a)=='|')||
				(line.charAt(a)=='~')||(line.charAt(a)=='<')||(line.charAt(a)=='>'))
		{
			if (((line.charAt(a) == '/')&&(line.charAt(a+1) == '/'))||((line.charAt(a) == '/')&&(line.charAt(a+1) == '*'))||
					(line.charAt(a) == '*')&&(line.charAt(a+1) == ' ')||((line.charAt(a) == '*')&&(line.charAt(a+1) == '/')))
				return;
			
			
			togoaway.a = Character.toString(line.charAt(a));
			togoaway.b = line.substring(a+1, line.length());
			
			total.add(togoaway.a);
			
			if ((togoaway.b).length()!=0)
			{
				breakline(togoaway.b);
				return;
			}
			
			else
				return;
		}
		
		while (a<b)
		{
			if ((line.charAt(a)!=' ')&&(line.charAt(a)!='(')&&(line.charAt(a)!=')')&&(line.charAt(a)!='[')&&(line.charAt(a)!=']')&&
			(line.charAt(a)!='{')&&(line.charAt(a)!='}')&&(line.charAt(a)!=',')&&
			(line.charAt(a)!=';')&&(line.charAt(a)!='=')&&(line.charAt(a)!='.')&&
			(line.charAt(a)!='+')&&(line.charAt(a)!='-')&&(line.charAt(a)!='*')&&
			(line.charAt(a)!='/')&&(line.charAt(a)!='&')&&(line.charAt(a)!='|')&&
			(line.charAt(a)!='~')&&(line.charAt(a)!='<')&&(line.charAt(a)!='>'))
			{
				breaker.add(line.charAt(a));
				a++;
			}
			
			else
				break;
			
		}
		
		int final_a = a;
		int c = 0;
		
		if (a>0)
		{
			c = final_a - init_a;
		}
			
		
		for (int d=0; d<c; d++)
		{
			temp = temp.concat(Character.toString(breaker.get(d)));
		}
		
		//Converting the read array of chars into a string
		togoaway.a = temp;
			
		//Converting the rest of the line into a string.
		if (line.charAt(a)==' ')
			a++;
		
		togoaway.b = line.substring(a, line.length());
		
		total.add(togoaway.a);
		
		if ((togoaway.b).length()!=0)
		{
			breakline(togoaway.b);
			return;
		}
		else
			return;
		}
		
	public static ArrayList<String> returndata()
	{
		return total;
	}
	
	
	public static String gettoken(String token)
	{
		boolean aha = true;
		
		if ((token.equals("("))||(token.equals(")"))||(token.equals("["))||(token.equals("]"))||
				(token.equals("{"))||(token.equals("}"))||(token.equals(","))||
				(token.equals(";"))||(token.equals("="))||(token.equals("."))||
				(token.equals("+"))||(token.equals("-"))||(token.equals("*"))||
				(token.equals("/"))||(token.equals("&"))||(token.equals("|"))||
				(token.equals("~"))||(token.equals("<"))||(token.equals(">")))
		{
			return ("<symbol>"+token+"</symbol>");
		}

		else if ((token.equals("class"))||(token.equals("constructor"))||(token.equals("method"))||
				(token.equals("function"))||(token.equals("int"))||(token.equals("boolean"))||
				(token.equals("char"))||(token.equals("void"))||(token.equals("var"))||
				(token.equals("static"))||(token.equals("field"))||(token.equals("let"))||
				(token.equals("do"))||(token.equals("if"))||(token.equals("else"))||(token.equals("while"))||
				(token.equals("return"))||(token.equals("true"))||(token.equals("false"))||(token.equals("null"))||
				(token.equals("this")))
		{
			return ("<keyword>"+token+"</keyword>");
		}
		
		else if (token.startsWith("1")||token.startsWith("2")||token.startsWith("3")||token.startsWith("4")||
				token.startsWith("5")||token.startsWith("6")||token.startsWith("7")||token.startsWith("8")||
				token.startsWith("9"))
		{
			for (int a=0;a<token.length();a++)
			{
				if ((token.charAt(a)=='1')||(token.charAt(a)=='2')||(token.charAt(a)=='3')||(token.charAt(a)=='4')||
						(token.charAt(a)=='5')||(token.charAt(a)=='6')||(token.charAt(a)=='7')||(token.charAt(a)=='8')||
						(token.charAt(a)=='9'))
					aha = true;
				else
					aha = false;
			}
			
			if (aha)
				return ("<integer>"+token+"</integer>");
		}
		
		else if ((token.charAt(0)=='"')&&(token.charAt(token.length()-1)=='"'))
			return ("<string>"+token+"</string");
		
		//Checking for identifiers		
		else if (Character.isLetter(token.charAt(0)))
		{
			boolean hmm = true;
			for (int f=1; f<token.length();f++)
			{
				if (Character.isLetterOrDigit(token.charAt(f)))
					hmm = true;
				else
					hmm = false;
			}
			
			if (hmm)
				return ("<identifier>"+token+"</identifier>"); 
			
		}
		
		//Detecting comments in this function is not necessary, since I already
		//checked for and removed comments in the previous breakline function.
		//I still left the code here for good measure!
		//Detecting comments in the code
		else if ((token.charAt(0)=='/')&&(token.charAt(1)=='/'))
			return null;	//If its a comment, we ignore it.
		
		//Detecting comments in the code
		else if ((token.charAt(0)=='/')&&(token.charAt(1)=='*')&&(token.charAt(2)=='*'))
			return null;	//If its a comment, we ignore it.
		
		//Detecting comments in the code
		else if (token.charAt(0)=='*')
			return null;	//If its a comment, we ignore it.
		
		//Detecting comments in the code
		else if ((token.charAt(0)=='*')&&(token.charAt(1)=='/'))
			return null;	//If its a comment, we ignore it.
	
			return ("unidentified object: "+token);
		
	}

	
}
