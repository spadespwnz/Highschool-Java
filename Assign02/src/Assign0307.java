import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Assign0307 {
	public static void main(String[] args) throws IOException{
		File file = new File("test.txt");
		StringBuffer contents = new StringBuffer();
		BufferedReader reader = null;
		int counter = 0;
		int h = 0;
		String findLen;
		String text;
		String line;
		String fin = null;
		
		ArrayList<String> all = new ArrayList();
		ArrayList<ArrayList<String>> ind = new ArrayList();
		int n = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			findLen = reader.readLine();
			reader = new BufferedReader(new FileReader(file));
			text = null;
			while ((text = reader.readLine()) != null) {
				n += 1;
			}
			
		}
		finally{}
		int len = findLen.length();
		String[][] words = new String[n][len];

		try {
			reader = new BufferedReader(new FileReader(file));
			text = null;
			while ((text = reader.readLine()) != null) {
				words[counter][0] = text;
				counter += 1;
	
			}
		}
		finally {}
		
		for (int i=0;i<n;i++){
			for(int j = 0; j< len; j++){
				words[i][len-1-j] = ""+words[i][0].charAt(len-1-j);
			}	
		}
		for (int i=0;i<n;i++){
			for(int j = 0; j< len; j++){
					System.out.print(words[i][j]);
					if (j!=len-1){
						System.out.print(",");
					}
			}
			System.out.println();
		}


	}
}
