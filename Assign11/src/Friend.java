
public class Friend implements Comparable{
	String name;
	int awesomeness;
	public Friend(String n, int i){
		awesomeness = i;
		name = n;
	}
	
	
	public int compareTo(Object other) {


		if (this.awesomeness > ((Friend) other).getRating()){
			return 1;
		}
		else if (this.awesomeness > ((Friend) other).getRating()){
			return 0;
		}
		else{
			return -1;
		}
	}

	
	public int compareToWord(Object other) {

		
		if (this.name.compareTo( ((Friend) other).name) < 0){
			return 1;
		}
		else if (this.name.compareTo( ((Friend) other).name) == 0){
			return 0;
		}
		else{
			return -1;
		}
	}
	
	public int getRating(){
		return awesomeness;
	}
	public static void alphabetize(Friend[] words){
		Friend temp;
		int j;
		int checks=0;
		int swaps=0;
		for (int i=1;i<words.length;i++){
			j=i;
			while (words[j].compareToWord(words[j-1]) > 0){
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
	}
}
