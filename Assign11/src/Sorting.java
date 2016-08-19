//NATHAN BROWN
//MAY 17

import java.util.Random;

public class Sorting {
	static int checks = 0;
	static int c = 0;
	public static void main(String[] args){

		System.out.println("Using 10000 Words");
		
		String[] words = new String[10000];
		String[] bubbleSortWords = new String[10000];
		String[] selectionSortWords = new String[10000];
		String[] insertionSortWords = new String[10000];
		String[] mergeSortWords = new String[10000];
		String[] quickSortWords = new String[10000];
		Timer time = new Timer();
		time.start();
		createData(words);
		time.stop();
		System.out.println("Time it took to create words: " + time.getTime()/1000.0);
		System.out.println();
		bubbleSortWords = words.clone();
		selectionSortWords = words.clone();
		insertionSortWords = words.clone();
		mergeSortWords = words.clone();
		quickSortWords = words.clone();
		
		
		time.reset();
		time.start();
		bubbleSort(bubbleSortWords);
		time.stop();
	
		System.out.println("Time it took to bubble sort words: " + time.getTime()/1000.0);
		System.out.println();
		time.reset();
		time.start();
		selectionSort(selectionSortWords);
		time.stop();
		
		System.out.println("Time it took to selection sort words: " + time.getTime()/1000.0);
		System.out.println();
		time.reset();
		time.start();
		insertionSort(insertionSortWords);
		time.stop();
		System.out.println("Time it took to insertion sort words: " + time.getTime()/1000.0);
		System.out.println();
		
		System.out.println();
		time.reset();
		time.start();
		mergeSortWords = mergeSort(mergeSortWords);
		time.stop();
		System.out.println("Merge Sort used " + c + " checks/swaps");
		System.out.println("Time it took to merge sort words: " + time.getTime()/1000.0);
		
		System.out.println();
		time.reset();
		time.start();
		quickSortWords = quickSort(quickSortWords);
		time.stop();
		System.out.println("Time it took to quick sort words: " + time.getTime()/1000.0);
		System.out.println();
		
		String[] wordList = new String[10000];
		createData(wordList);
		String searchWord = wordList[500];
		wordList = mergeSort(wordList);
		time.reset();
		time.start();
		int sp = linearSearch(wordList,searchWord);
		time.stop();
		System.out.println("LINEAR SEARCH");
		System.out.println("Word found at " + sp);
		System.out.println("Time it took: "+time.getTime()/1000.0);
		System.out.println("Checks done: "+checks);
		checks = 0;
		time.reset();
		time.start();
		sp = binarySearch(wordList,searchWord);
		time.stop();
		System.out.println();
		System.out.println("BINARY SEARCH");
		System.out.println("Word found at " + sp);
		System.out.println("Time it took: "+time.getTime()/1000.0);
		System.out.println("Checks done: "+checks);
		checks = 0;
		
		
		
	}
	
	public static void createData(String[] words){
		Random r = new Random();

		String letters = "abcdefghijklmnopqrstuvwxyz";

		for (int i=0;i<words.length;i++){
			words[i] = "";
			for (int j=0;j<4;j++){
				
				words[i] += letters.charAt((int)(r.nextDouble()*26));
			}
		}

	}
	
	public static void show(String[] words){
		for (int i=1;i<words.length+1;i++){
			System.out.print(words[i-1] + " ");
			if (i%10 == 0 ){

				System.out.println();
				
			}
		}
		
	}
	
	public static void bubbleSort(String[] words){
		String temp;
		int checks = 0;
		int swaps = 0;
		for (int i=0;i<words.length;i++){
			for (int j=0;j<words.length-1;j++){
				checks += 1;
				if (words[j].compareTo(words[j+1]) > 0){
					swaps +=1;
					temp = words[j];
					words[j] = words[j+1];
					words[j+1] = temp;
				}
			}
		}
		System.out.println("Bubblesort used " + checks + " checks");
		System.out.println("Bubblesort used " + swaps + " swaps");
	}

	public static void selectionSort(String[] words){
		int temp = 0;
		int checks = 0;
		int swaps = 0;
		String wordTemp;
		for (int i=0;i<words.length;i++){
			for (int j=i;j<words.length;j++){
				checks += 1;
				if (words[j].compareTo(words[temp]) < 0){
					temp = j;
				}	
			}
			swaps += 1;
			wordTemp = words[temp];
			words[temp] = words[i];
			words[i] = wordTemp;
			temp = i+1;
			
		}
		System.out.println("Selection sort used " + checks + " checks");
		System.out.println("Selection sort used " + swaps + " swaps");
	}
	
	public static void insertionSort(String[] words){
		String temp;
		int j;
		int checks=0;
		int swaps=0;
		for (int i=1;i<words.length;i++){
			j=i;
			while (words[j].compareTo(words[j-1]) < 0){
				swaps += 1;
				checks += 1;
				temp = words[j];
				words[j] = words[j-1];
				words[j-1] = temp;
				j -= 1;
				if (j==0){
					break;
				}
			}
			if (j != 0){
				checks += 1;
			}
		}
		System.out.println("Insertion Sort used " + checks + " checks");
		System.out.println("Insertion Sort used " + swaps + " swaps");
	}
	
	public static String[] mergeSort(String[] words){
		if (words.length == 1){
			return words;
		}
		else{
		String[] leftWords;
		String[] rightWords;
		int size = words.length/2;
		leftWords = new String[size];
		rightWords = new String[words.length - size];
		for (int i = 0;i<words.length - size;i++){
			rightWords[i] = words[i+size]; 
			if (i<size){
				leftWords[i] = words[i]; 
			}
		}
		leftWords = mergeSort(leftWords);
		rightWords = mergeSort(rightWords);
		String[] returner = merge(leftWords,rightWords);
		return returner;
		}
		
	}
	
	public static String[] merge(String[] words1, String[] words2){
		String[] returner = new String[words1.length + words2.length];
		int a = 0,b = 0;
		while (a < words1.length || b < words2.length){
			c += 1;
			if (a == words1.length || b == words2.length){
				
				if (a == words1.length){
					returner[a+b] = words2[b];
					b++;
				}
				else{
					returner[a+b] = words1[a];
					a++;
				}
			}
			else{
				if (words1[a].compareTo(words2[b]) < 0){
					returner[a+b] = words1[a];
					a++;
				}else{
					returner[a+b] = words2[b];
					b++;
				}
			}
		}
		return returner;		
	}

	public static String[] quickSort (String[] words){
		int count=0;
		int lCount = 0;
		int rCount = 0;
		if (words.length < 2){
			return words;
		}
		String[] wordsLeft = new String[words.length];
		String[] wordsRight = new String[words.length];
		if (words.length < 2){
			return words;
		}
		else{
			int pivot = words.length/2;
			for (int i=0;i<words.length;i++){
				if (i != pivot){
					if (words[i].compareTo(words[pivot])<0){
						wordsLeft[lCount] = words[i];
						lCount++;
					}
					else{
						wordsRight[rCount] = words[i];
						rCount++;
					}
				}
			}

			String[] leftWords1 = new String[lCount];
			String[] rightWords1 = new String[rCount];
			System.arraycopy(wordsLeft, 0 , leftWords1,0,lCount);
			System.arraycopy(wordsRight, 0 , rightWords1,0,rCount);
			wordsLeft = quickSort (leftWords1);
			wordsRight = quickSort (rightWords1);
			
			String[] returner = new String[words.length];
			for (int i =0;i<wordsLeft.length;i++){
				returner[count] = wordsLeft[i];
				count++;
			}
			returner[count] = words[pivot];
			count++;
			for (int i =0;i<wordsRight.length;i++){
				returner[count] = wordsRight[i];
				count++;
			}
			return returner;
		}
		
	}
	
	public static int binarySearch(String[] words, String find){
		int max = words.length-1;
		int min = 0;
		int mid;
		while (min <= max){
			checks += 1;
			mid = (max+min)/2;
			if (words[mid].compareTo(find) == 0){
				return mid;
			}
			else if (words[mid].compareTo(find) < 0){
				min = mid+1;
			}
			else{
				max = mid-1;
			}

		}
		return -1;
	}

	public static int linearSearch(String[] words, String find){
		for (int i=0;i<words.length;i++){
			checks += 1;
			if (words[i].compareTo(find) == 0){
				return i;
			}
		}
		return -1;
	}
}



