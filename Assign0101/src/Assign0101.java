//my first program
//by Nathan Brown
//introduces basic input and output
//as well as the basic program structure
//started feb 3
// ended feb 3

import java.io.*;
import java.util.Scanner;


public class Assign0101 {
	public static void main (String[] args) {

		Scanner sc = new Scanner (System.in);
		String name;
		int age;
		String word = true == true?"yes":"no";
		System.out.println (word);
		System.out.println ("Type in name:");
		name = sc.nextLine();
		System.out.println ("Type in age:");
		age = sc.nextInt();

		if (age >= 18) {
			System.out.println ( name + " is old enough to vote");
			
			player lol = new player();
			System.out.println(lol.a);
		}
	}
	


}

class player{
	
	int a = 1;
}