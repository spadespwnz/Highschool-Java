//BY NATHAN BROWN
//ARRAYS QUESTION 1
//APRIL 14

import java.awt.Point;
import java.util.Random;


public class Q1 {
	public static void main(String[] args){

		Random r = new Random();
		System.out.println("QUESTION 1----");
		System.out.println("Question a and b: create and print 10 random numbers from 1-50 in an array");
		int[] list = createArray(10,50);
		show(list);
		System.out.println("Question c: Create an array and check if its sorted, repeat until sorted, count amount");
		System.out.println("Array's Test: " + howMany());
		System.out.println("Question d: Print an array, then reverse it and print again");
		int[] list2 = createArray(10,50);
		show(list2);
		list2 = reverse(list2);
		show(list2);
		System.out.println("Question e: Take the 3rd element out of an array");
		int[] list3 = createArray(10,50);
		show(list3);
		list3 = remove(list3,2);
		show(list3);
		System.out.println("Question f: Insert '7' at element 4");
		int[] list4 = createArray(10,50);
		show(list4);
		list4 = insert(list4,7,3);
		show(list4);
		System.out.println("Question g: Check to see if there are equal numbers in an array");
		int[] list5 = {0,1,3,12,9,6,8,4,12,22,2};
		int[] list6 = {0,1,2,3,4,5,6,7,8,9,10,11};
		show(list5);
		System.out.println("Are there double? " + checkDoubles(list5));
		show(list6);
		System.out.println("Are there double? " + checkDoubles(list6));
		System.out.println("Question h: Check to see if there are equal numbers between 2 arrays");
		int[] list7 = { 25,28,33,34,56,78,44,57,73 };
		System.out.print("List 1:   ");
		show(list5);
		System.out.print("List 2:   ");
		show(list6);
		System.out.print("List 3:   ");
		show(list7);
		System.out.println("Comparing list 1 and list 2:  "+checkDoubles(list5,list6));
		System.out.println("Comparing list 1 and list 3:  "+checkDoubles(list5,list7));
		System.out.println();
		System.out.println();

	}
	
	public static int[] createArray(int len, int range){
		int[] nums = new int[len];
		Random r = new Random();
		for (int i=0;i<len;i++){
			nums[i] = r.nextInt(range)+1;
		}
		return nums;
	}
	
	public static void show(int[] list){

		for (int i=0;i<list.length;i++){
			System.out.print(list[i]);

			if (i != list.length-1){
				System.out.print
				(", ");
			}
			else System.out.println();
		}

	}
	
	public static boolean checkSort(int[] list){
		for (int i=1;i<list.length;i++){
			if (list[i] < list[i-1]){
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkDoubles(int[] list){
		for (int i=0;i<list.length-1;i++){
			for (int j=i+1;j<list.length;j++){
				if (list[i] == list[j]){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean checkDoubles(int[] list1, int[] list2){
		for (int i=0;i<list1.length-1;i++){
			for (int j=0;j<list2.length;j++){
				if (list1[i] == list2[j]){
					return true;
				}
			}
		}
		return false;
	}
	
	public static int[] reverse(int[] list){
		int temp;
		for (int i=0;i<list.length/2;i++){
			temp = list[i];
			list[i] = list[list.length-1-i];
			list[list.length-1 - i] = temp;	
		}
		
		return list;
	}
	
	public static int[] remove(int[] list, int r){
		for (int i=r;i<list.length-1;i++){
			list[i] = list[i+1];
		}
		list[list.length-1] = -1;
		return list;
	}
	
	public static int[] insert(int[] list, int n, int s){
		for (int i=list.length-1;i>s;i--){
			list[i] = list[i-1];
		}
		list[s] = n;
		return list;
	}
	
	public static int howMany(){
		int counter = 0;
		Random r = new Random();
		int list[] = new int[10];
		do {
			for (int i=0;i<list.length;i++){
				list[i] = r.nextInt(50)+1;
			}
			counter += 1;
		} while (!checkSort(list));
		show(list);
		return counter;
	}
	

}
