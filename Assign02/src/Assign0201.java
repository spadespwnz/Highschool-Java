import java.util.Scanner;
public class Assign0201 {

	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		for (int i=0; i<5; i++){
		System.out.print("Message to print: ");
		String message = sc.nextLine();
		printMessage(message);
		}
	}
	
	public static void printMessage(String msg){
		System.out.println(msg);
	}
}
