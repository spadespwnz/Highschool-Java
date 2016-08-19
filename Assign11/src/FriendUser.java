import java.util.Arrays;


public class FriendUser {

	public static void main(String[] args) {
		
		Friend[] friends = new Friend[10];
		friends[0] = new Friend("Baddie", -1000);
		friends[1] = new Friend("Brodie", -1000);
		friends[2] = new Friend("Baller", 87);
		friends[3] = new Friend("somenub", -12);
		friends[4] = new Friend("Ezpz", 4);
		friends[5] = new Friend("nah", 4);
		friends[6] = new Friend("lawlers", 43);
		friends[7] = new Friend("harharharh", -1000);
		friends[8] = new Friend("fag", 4);
		friends[9] = new Friend("keke", -12);
		
		Friend.alphabetize(friends);
		Arrays.sort(friends);
		for (int i=0;i<10;i++){
			System.out.println(friends[i].name);
		}

	}

}
