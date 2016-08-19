import java.awt.Rectangle;
public class Assign06 {
	public static void main(String[] args){
		/*
		 * 
		 *	In java when you pass an argument to a parameter the parameter takes on the value of the
		 *argument. 
		 * When you pass a reference type as an argument, you are actually passing a value.
		 * The value that you pass is a reference to an object.
		 * 
		 * The statement is saying that when you pass a primitive type to an parameter that the 
		 * parameter just copies that value and that when you pass a object type to a parameter
		 * that the parameter just point to object that was passed.
		 * This is wrong because object types are passed as value, its just that the the value passed
		 * is a reference so it seems that object types pass by reference.
		 * 
		 * Wrapper types are used to change primitive types into reference types. This is helpful
		 * if you want to mimic passing by reference.
		 * 
		 * 	
		 */
		int n = 5;
		System.out.println("n value before method is called: " + n);
		testValue(n);
		System.out.println("n value after method is called: " + n);

		Rectangle box = new Rectangle(5,5,5,5);
		System.out.println("Width before method is called: " + box.getWidth());
		testReference(box);
		System.out.println("Width before method is called: " + box.getWidth());
		
	}
	public static void testValue(int n){
		n = n+=1;
		System.out.println ("n value in the method: " + n);
	}
	
	public static void testReference(Rectangle rect){
		rect.width = (int) (rect.getWidth() + 1);
		System.out.println("Width in the method: " + rect.getWidth());
	}
	
}
