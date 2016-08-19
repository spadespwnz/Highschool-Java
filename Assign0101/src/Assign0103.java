//my third prgram
//by Nathan Brown
//introduces basic input and output
//as well as the basic program structure
//started feb 3
// ended feb 3

import java.io.*;
import java.util.Scanner;

public class Assign0103 {
	public static void main (String[] args) {
	
	Scanner sc = new Scanner (System.in);
	
	System.out.println("Denominator to add to?");
	int n = sc.nextInt();
	
	float sum = 0;
	for (int i=1; i<n+1; i++){
		sum += (double)1/i;
	}
	System.out.println(sum);
	//If you use 4 it should be 2.083333333

	}
}