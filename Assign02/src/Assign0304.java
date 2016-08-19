import java.util.Scanner;
public class Assign0304 {
	public static void main (String[] args){
		Scanner sc = new Scanner (System.in);
		String word = "Mississauga";
		String word2;
		System.out.println(word);
		word = word.replace('s', '$');
		word = word.replace('i', '!');
		System.out.println(word);
		
		System.out.println ("Word: ");
		word2 = sc.nextLine();
		word2 = word2.replace('s', '$');
		word2 = word2.replace('i', '!');
		System.out.println(word2);
		System.out.println("Letter Count: " + word2.length());

		
	}
	

}
