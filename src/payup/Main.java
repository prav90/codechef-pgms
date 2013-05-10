package payup;

import java.util.Scanner;

public class Main {
	
	public static boolean findSumMatch(int [] notes, int startIndex, int result, int sum) {
		boolean found = false;
		if(startIndex > notes.length) return found;
		if(result == sum) {return true;}
		if(result > sum) return false;
		for(int i = startIndex; i < notes.length; i++) {
			found = (found ||findSumMatch(notes,i+1,result+notes[i],sum));
		}
		return found;
	}
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		StringBuilder result = new StringBuilder();
		while(t > 0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int [] notes = new int[n];
			for(int i = 0; i < notes.length; i++) {
				notes[i] = scan.nextInt();
			}
			if(findSumMatch(notes, 0, 0, m)) {
				result.append("Yes\n");
			}
			else {
				result.append("No\n");
			}
			t--;
		}
		System.out.print(result);
	}

}
