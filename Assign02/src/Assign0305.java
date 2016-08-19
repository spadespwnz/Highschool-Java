import java.awt.Rectangle;
public class Assign0305 {
	public static void main (String[] args){
		Rectangle box = new Rectangle (30,40,50,60);
		System.out.println ("Rect x pos: " + box.getX());
		System.out.println ("Rect y pos: " + box.getY());
		box = modify(box);
		System.out.println("Call Method to change box pos");
		System.out.println ("Rect x pos: " + box.getX());
		System.out.println ("Rect y pos: " + box.getY());
		Rectangle newbox = new Rectangle ((int)(1/2*box.getX()), (int)(1/2*box.getY()), (int)box.getWidth(), (int)box.getHeight());

	}
	public static Rectangle modify (Rectangle rect){
		rect.x = (int) (rect.getX()/2);
		rect.y = (int) (rect.getY()/2);
		return rect;
	}

}
