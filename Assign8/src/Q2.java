//NATHAN BROWN
//QUESTION 4 (OPTIONAL)

import java.util.Random;
import java.util.Scanner;

public class Q2 {
	public static void main(String[] args){
		Scanner sc = new Scanner( System.in );
		double[][] nums = new double[3][4];
		int opt;
		int m;
		int n;
		boolean solved = false;
		int[] v1 = new int[3];
		int[] v2 = new int[3];

		System.out.println("QUESTION 4----(OPTIONAL STUFF)");
		System.out.println("Question a: Find the corssproduct of 2 arrays and store it as an array");
	
		v1 = createArray(3,10);
		v2 = createArray(3,10);
		System.out.println("Vector 1");
		show(v1);
		System.out.println("Vector 2");
		show(v2);
		int[] v3 = getCross(v1,v2);
		System.out.println("Cross Product of V1 and V2");
		show(v3);
		System.out.println();
		
		System.out.println("Question b: Multiply a 2d array by a scalar value");
		int[][] array2 = createArray(3,3,10);
		System.out.println("Array before scalar multiplication");
		show(array2);
		array2 = scalarMult(array2, 4);
		System.out.println("Array after scalar multiplication by 4");
		show(array2);
		
		System.out.println("Question c: Given an array of x-y pairs, determine the line of best for");
		int[][] xy = {{1,3},{2,4},{3,8},{4,9},{5,10},{6,15}};
		System.out.println("X-Y pairs used to make line of best fit");
		show(xy);
		bestFit(xy);
		System.out.println("Question d: Solve 3 equations with 3 unknowns");
		getEquations(nums);	
		while (solved == false){
			show(nums);
			System.out.println("Enter 1 to multiply, 2 to add, 3 to solve or 4 to quit");
			opt = sc.nextInt();
			if (opt == 1){
				System.out.println("Which row to mutliply (1,2 or 3)?");
				m = sc.nextInt();
				System.out.println("What to multiply row " + m +" by?");
				n = sc.nextInt();
				nums = multiply(nums,m-1,n);
				
			}
			
			if (opt == 2){
				System.out.println("Which row to add to (1,2 or 3)?");
				m = sc.nextInt();
				System.out.println("Which row to add?");
				n = sc.nextInt();
				nums = add(nums,m-1,n-1);
			}
			
			if (opt == 4){
				solved=true;
			}
			if (opt == 3){
				solved=true;
				System.out.println("Solving equation...");
				solveEquations(nums);
			}
		}
	}
	
	public static void getEquations(double[][] nums){
		for (int i=0;i<3;i++){
			Scanner sc = new Scanner(System.in);
			String s;
			System.out.println("Equation " + (i+1) + " (ex. 3x-2y+2.4z=5)?");
			s = sc.nextLine();
			if (0 == s.indexOf("x")){
				nums[i][0] = 1;
			}
			else if (s.charAt(s.indexOf("x")-1) == '-'){
				nums[i][0] = -1;
			}
			else{
				nums[i][0] = Double.parseDouble(s.substring(0,s.indexOf("x")));
			}
			
			if (s.indexOf("y") == s.indexOf("x")+2){
				nums[i][1] = 1;
			}
			else{
				nums[i][1] = Double.parseDouble(s.substring(s.indexOf("x")+2,s.indexOf("y")));
			}
			
			if (s.indexOf("z") == s.indexOf("y")+2){
				nums[i][2] = 1;
			}
			else{
				nums[i][2] = Double.parseDouble(s.substring(s.indexOf("y")+2,s.indexOf("z")));
			}
			
			if (s.charAt(s.indexOf("x")+1) == ('-')){
				
				nums[i][1] *= -1;
			}
			
			if (s.charAt(s.indexOf("y")+1) == '-'){
				nums[i][2] *= -1;
			}
			
			nums[i][3] = Double.parseDouble(s.substring(s.indexOf("=")+1));
		}
	}
	
 	public static void solveEquations(double[][] nums){
		show(nums);
		nums = multiply(nums,1,-1*nums[2][0]/nums[1][0]);
		show(nums);
		nums = add(nums,2,1);
		show(nums);
		nums = multiply(nums,0,-1*nums[1][0]/nums[0][0]);
		show(nums);
		nums = add(nums,1,0);
		show(nums);
		nums = multiply(nums,1,-1*nums[2][1]/nums[1][1]);
		show(nums);
		nums = add(nums,2,1);
		show(nums);
		nums = add(multiply(nums,2,-1*nums[1][2]/nums[2][2]),1,2);
		show(nums);
		nums = add(multiply(nums,2,-1*nums[0][2]/nums[2][2]),0,2);
		show(nums);
		nums = multiply(nums,2,1/nums[2][2]);
		show(nums);
		nums = add(multiply(nums,1,-1*nums[0][1]/nums[1][1]),0,1);
		show(nums);
		nums = multiply(nums,1,1/nums[1][1]);
		show(nums);
		nums = multiply(nums,0,1/nums[0][0]);
		show(nums);
		
	}
	
	public static int[] createArray(int len, int range){
		int[] nums = new int[len];
		Random r = new Random();
		for (int i=0;i<len;i++){
			nums[i] = r.nextInt(range)+1;
		}
		return nums;
	}
	
	public static int[][] createArray(int len, int len2, int range){
		int[][] nums = new int[len][len2];
		Random r = new Random();
		for (int i=0;i<len;i++){
			for (int j=0;j<len2;j++){
				nums[i][j] = r.nextInt(range)+1;
			}
		}
		return nums;
	}
	
	public static void show(double[][] nums){
		for (int i = 0;i<nums.length;i++){
			for (int j=0;j<nums[i].length;j++){
				System.out.print(nums[i][j] + "  ");
				if (j == 2){
					System.out.print("|  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static double[][] multiply(double[][] nums, int row, double num){
		double[][] temp = nums.clone();
		for (int i=0;i<4;i++){
			temp[row][i] = Math.round(temp[row][i]*num*100)/100.0;
		}
		return temp;
	}

	public static double[][] add(double[][] nums, int row, int add){
		double[][] temp = nums.clone();
		for (int i=0;i<4;i++){
			temp[row][i] = Math.round((temp[row][i]+temp[add][i])*100)/100.0;
		}
		return temp;
	}
	
	public static int[] getCross(int[] v1, int[] v2){
		int[] c = new int[v1.length];
		for (int i=0;i<v1.length;i++){
			c[i] = (v1[(i+4)%3]*v2[(i+5)%3])-(v2[(i+4)%3]*v1[(i+5)%3]);
		}
		return c;
	}
	
	public static int[][] scalarMult(int[][] nums, int mult){
		for (int i=0;i<nums.length;i++){
			for (int j=0;j<nums[i].length;j++){
				nums[i][j] *= mult;
			}
		}
		return nums;
	}
	
	public static void bestFit(int[][] nums){
		double sumY = 0;
		double sumX = 0;
		double sumXY = 0;
		double sumXsquared = 0;
		double m;
		double b;
		for (int i=0;i<nums[0].length;i++){
			sumY += nums[i][1];
			sumX += nums[i][0];
			sumXY += nums[i][0]*nums[i][1];
			sumXsquared += nums[i][1]*nums[i][0];
		}
		
		m = Math.round(((sumY*sumX - nums.length*sumXY)/(sumX*sumX - nums.length*sumXsquared))*1000)/1000.0;
		b = Math.round(((sumX*sumXY - sumY*sumXsquared)/(sumX*sumX - nums.length*sumXsquared))*1000)/1000.0;
		System.out.println("Equation for line of best fit: y="+m+"x+("+b+")");
		
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

	public static void show(int[][] list){
		for (int j=0;j<list.length;j++){
			for (int i=0;i<list[j].length;i++){
				System.out.print(list[j][i]);
	
				if (i != list[i].length-1){
					System.out.print
					(", ");
				}
				else System.out.println();
			}

		}
	}
	
}
