
public class Assign {
	public static void main(String args[]){
		System.out.println(isPrime(84));
	}
	
	public static void repeater(String msg, int x){
		for (int i=0;i<x;i++){
			System.out.println(msg);
		}
	}
	
	public static String repeat(String msg, int x){
		for (int i=0;i<x-1;i++){
			msg = msg + " " + msg.substring(0,msg.length()/(i+1));
		}
		return msg;
	}
	
	public static boolean isPrime(int num){
		for (int i=2;i<num;i++){
			if (num%i == 0){
				return false;
			}
		}
		return true;
		
	}
}
