/*
Recursion.java
Solving Recursion Problems
Sudhanya Golla
Created July 9th, 2024
Last Modified July 9th 2024
*/

// Java Setup
import java.util.*;

class Recursion {

	// Main program
	public static void main(String[] args) {

		// Test cases to test out all recursive subprograms created
		System.out.println(findFact(5));
		System.out.println(findFact(10));
	
		System.out.println(bunnyEars(5));
		System.out.println(bunnyEars(10));
		
		System.out.println(sumDigits(126));
		System.out.println(sumDigits(3241));
		
		System.out.println(countHi("hixxhixhix"));
		System.out.println(countHi("xxaasdshas"));
		
		System.out.println(strCount("callllcalllcall", "call"));
		System.out.println(strCount("hasdoerapplesdh apple", "apple"));
		
		System.out.println(triangle(5));
		System.out.println(triangle(15));

		System.out.println(fibonacci(8));
		System.out.println(fibonacci(17));
			
	}
	
	// All recursive subprograms created
	// Question 1 - determine the factorial of a number using recursion
	public static int findFact(int num)
	{
		// Base case - final number that factorial will multiply itself by
		if (num == 1)
		{
			return 1;
		}
		else
		{
			return num = num * findFact(num - 1);
		}
	}

	// Question 2 - Determine the amount of bunny ears given the numbers of bunnies using recursion
	public static int bunnyEars(int numBunnies)
	{
		// Base case - stop adding ears as no bunnies are left
		if (numBunnies == 0)
		{
			return 0;
		}
		else
		{
			return 2 + bunnyEars(numBunnies - 1);
		}
	}

	// Question 3 - Calculate the sum of all the digits in the numbers using recursion
	public static int sumDigits(int number)
	{
		// Base case - stop adding digits once number is a single-digit number
		if (number < 10)
		{
			return number;
		}
		else
		{
			return number = (number % 10) + sumDigits(number/10);
		}
		
	}

	// Question 4 - Calculate the number of occurences of the word "hi" within a string using recursion
	public static int countHi(String word)
	{	

		// Base case - stop looking for an occurence if word is less than 2 letters
		if (word.length() < 2)
		{
		    return 0;
		}

		// Create a new substring depending on whether the word "hi" occured within the first 2 letters of the string
		if (word.substring(0,2).equals("hi"))
		{
		    return 1 + countHi(word.substring(2));
		}
		else
		{
			return 0 + countHi(word.substring(1));
		}
  
	}

	// Determine the number of occurences of a substring within another string
	public static int strCount(String sentence, String sub)
	{
		// Base case - stop looking for occurence once length of string is less than substring
		if (sentence.length() < sub.length())
		{
		    return 0;
		}

		// Determine whether the substring occurs within the first letters of the original string
		// Create a substring of original string using recursion
		if (sentence.substring(0,sub.length()).equals(sub))
		{
		    return 1 + strCount(sentence.substring(sub.length()), sub);
		}
		else
		{
			return 0 + strCount(sentence.substring(1), sub);
		}
	}

	// Determine the total amount of rows in a triangle using recursion
	public static int triangle(int row)
	{
		// Base case - stop finding amount of rows once program reaches last row
		if (row == 1)
		{
			return 1;
		}

		// Add beginning row with previous rows to find total number of rows
		else
		{
			return row + triangle(row - 1);
		}
	}

	// Determine the fibonacci sequence using recursion
	public static int fibonacci(int term)
	{
		// Base cases - first two terms every single term is a combination of
		if (term == 1)
		{
			return 1;
		}
		else if (term == 0)
		{
			return 0;
		}

		// Calculate fibonacci sequence
		else
		{
			return fibonacci(term - 1) + fibonacci(term - 2);
		}
	}

}