import java.util.Scanner;
public class Assign0202 {

	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Number to calculate area for: ");
		int value= sc.nextInt();
		double area = calcArea(value);
		System.out.println("The area of a cricle with a radius of " + value + " is " + area);
	}
	
	public static double calcArea(int r){
		//return (double)Math.pow(r,2)*3.14;
		return (double)(r*r)*3.14;
		
	}
}
