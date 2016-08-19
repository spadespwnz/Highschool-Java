import java.awt.Rectangle;
public class Assign0302 {
	
	public static void main (String[] args){
		
		Rectangle box1 = new Rectangle (25,17,27,39);
		Rectangle box2 = new Rectangle (30,24,30,30);
		
		Rectangle box4 = new Rectangle (10,10,10,10);
		Rectangle box5 = new Rectangle (100,100,30,30);
		Rectangle box3 = box1.intersection(box2);
		Rectangle box6 = box4.intersection(box5);
		
		System.out.println("Overlapping: ");
		System.out.println("X pos: " + box3.getX());
		System.out.println("Y pos: " + box3.getY());
		System.out.println("Width: " + box3.getWidth());
		System.out.println("height: " + box3.getHeight());
		System.out.println("Not overlapping: ");
		System.out.println("X pos: " + box6.getX());
		System.out.println("Y pos: " + box6.getY());
		System.out.println("Width: " + box6.getWidth());
		System.out.println("height: " + box6.getHeight());
		//If the width or height has a negative number then the rectangles are not overlapping
		
		
	}

}
