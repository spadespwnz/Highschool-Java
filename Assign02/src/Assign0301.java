import java.util.Scanner;
import java.awt.Rectangle;

public class Assign0301 {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What is the x position? ");
		int x = sc.nextInt();
		System.out.println("What is the y position? ");
		int y = sc.nextInt();
		System.out.println("What is the width? ");
		int width = sc.nextInt();
		System.out.println("What is the height? ");
		int height = sc.nextInt();
		
		Rectangle maBox = new Rectangle (x,y,width,height);
		
		System.out.println("X pos: " + maBox.getX() + ", Y pos: " + maBox.getY() + ", width: " + maBox.getWidth() + ", height: " + maBox.getHeight());
		
	}
	

}
