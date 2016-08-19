import java.util.Random;
import java.util.Scanner;

public class Assign0303 {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many dice would you like to Roll? ");
		int num = sc.nextInt();
		int sum = 0;
		Random rand = new Random();
		for (int i=0;i<num;i++){
		int die = rand.nextInt(6)+1;
		System.out.println("Die " + (i+1) + ": " + die);
			sum += die;
		}
		System.out.println("Sum: " + sum);
		
	}
}
