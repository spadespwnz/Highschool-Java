import java.awt.Point;
import java.io.IOException;


public class Lineuser {
	public static void main(String args[]) throws IOException{
		Point a = new Point(8,15);
		Point b = new Point(9,2);
		Point c = new Point(3,12);
		Line line1 = new Line(a,b);
		Line line2 = new Line(c,2.1);
		Line line3 = new Line(-1, 4);
		Line line4 = new Line(4);
		Line line5 = new Line(a,b);
		Line line6 = new Line(-1, 3);

		
		System.out.println("Info for Line 1:");
		System.out.println("Made using 2 points, (8,15) and (9,2)");
		System.out.println("Y intercept: " + line1.getB());
		System.out.println("Slope: " + line1.getM());
		System.out.println("X intercept: " + line1.getXintercept());
		System.out.println();
		
		System.out.println("Info for Line 2:");
		System.out.println("Made using point and slope, (3,12) and m = 2.1");
		System.out.println("Y intercept: " + line2.getB());
		System.out.println("Slope: " + line2.getM());
		System.out.println("X intercept: " + line2.getXintercept());
		System.out.println();
		
		System.out.println("Info for Line 3:");
		System.out.println("Made using y intercept and slope, b = 4 and m = -1");
		System.out.println("Y intercept: " + line3.getB());
		System.out.println("Slope: " + line3.getM());
		System.out.println("X intercept: " + line3.getXintercept());
		System.out.println();
		
		System.out.println("Info for Line 4:");
		System.out.println("Made using x position (vertical line), x = 4");
		System.out.println("Y intercept: " + line4.getB());
		System.out.println("Slope: " + line4.getM());
		System.out.println("X intercept: " + line4.getXintercept());
		System.out.println();
		
		System.out.println("Info for Line 5:");
		System.out.println("Exact same as line 1");
		
		System.out.println("Info for Line 6:");
		System.out.println("Same as Line 3 except 1 y position down from Line 3");
		
		System.out.println();
		System.out.println("Is line 1 equal to line 2? " + line1.equals(line2));
		System.out.println("Is line 1 equal to line 5? " + line1.equals(line5));
		System.out.println("Is line 1 equal to line 4? " + line1.equals(line4));
		System.out.println();
		System.out.println("Is line 1 parallel to line 2? " + line1.isParallel(line2));
		System.out.println("Is line 3 parallel to line 6? " + line3.isParallel(line6));
		System.out.println("Is line 1 parallel to line 5? " + line1.isParallel(line5));
		System.out.println();
		System.out.println("Do line 1 and 2 intersect? " + line1.intersects(line2));
		System.out.println("Do line 1 and 4 intersect? " + line1.intersects(line4));
		System.out.println("Do line 3 and 6 intersect? " + line3.intersects(line6));
		
		
	}
}
