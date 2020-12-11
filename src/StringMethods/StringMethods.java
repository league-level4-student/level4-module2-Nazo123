package StringMethods;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return s1;
		}
		return s2;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
	if(s.contains("underscores")) {
		s = s.replace(' ', '_');

	}

		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		
		return null;
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int value = 0;
		char[] a = s.toCharArray();
		for(int i = 0; i< s.length(); i++) {
			if(Character.isDigit(a[i])) {
				value += Integer.parseInt(a[i]+"");
 			}
		}
		/*char[] a = s.toCharArray();
		for(int i = 0; i < a.length;i++) {
		switch(""+a[i]) {
		case "1": value++;
		break;
		case "2": value = value+2;	
		break;
		case "3": value = value+3;
	    break;
		case "4": value = value+4;
	    break;
		case "5": value = value+5;
	    break;
		case "6": value = value+6;
	    break;
		case "7": value = value+7;
	    break;
		case "8": value = value+8;
	    break;
		case "9": value = value+9;
	    break;
	    }
		*/
		

		return value;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
	if(s.contains(substring)) {
		char[] a = s.toCharArray();
		char[] b = substring.toCharArray();
		int correct = 0;
		boolean c = false;
		for(int i = 0; i < a.length; i++) {
			c = true;
			for(int g = 0; g < b.length; g++) {
				
				if(a[i+g] == b[g]) {
			
				}
				else {
					c = false;
					break;
				}
			}
			if(c) {
				correct++;
			}
			}

		return correct;
	}
	return 0;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {

		char[] g = s.toCharArray();
		byte[] b =  new byte[g.length];
		for(int i = 0; i < g.length;i++) {
			 b[i] =  (byte) g[i]; 
		}
		byte a = (byte) key;
	
		return Utilities.encrypt(b, a) ;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		byte a = (byte) key;
		
		return Utilities.decrypt(s, a);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		
		return 0;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		char[] a = s.toCharArray();
		char[] b = substring.toCharArray();
		int first = -1;
		int last = -1;
		int counter = 0;
System.out.println(a.length);
System.out.println(s);
		for(int i = 0; i <a.length-b.length+1;i++) {
			System.out.println(i);
	System.out.println("era");
			for(int c = 0; c < b.length; c++) {
				System.out.println(c);
				if(a[i+c]==b[c]) {
					counter++;
				}
				else {
					counter = 0;
					break;
				}
				if(counter == b.length) {
					if(first == -1) {
						first = i+b.length;
					}
					else {
						last = i;
					}
					counter = 0;
					break;
				}
			}
		}
		System.out.println(s);
		System.out.println(substring);
		System.out.println(first);
		System.out.println(last);
		return last-first;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		s = s.toLowerCase();
		s = s.replace(" ", "");
		s = s.replace("?","");
		s = s.replace(".", "");
		s = s.replace("!", "");
		s = s.replace(",", "");
		s = s.replace("–", "");
		s = s.replace(":", "");
		char[] a = s.toCharArray();
		
		for(int i = 0; i < (a.length-1)/2;i++) {
			if(a[i] != a[a.length-i-1]) {
				return false;
			}
		}
		return true;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
