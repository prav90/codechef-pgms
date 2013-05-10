package payup;

import java.util.Scanner;

public class MainOpt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			int SubCount = (int)Math.pow(2,n);
			boolean resultfound = false;
			
			for(int i = 1; i < SubCount; i++) {
				int sum = 0;
				for(int j = 0; j < n; j++) {
					if((i & (1 << j)) > 0) {
						sum+= notes[j];
					}
					if(sum == m) {
						break;
					}
				}
				if(sum == m) {
					resultfound = true;
					break;
				}
			}
			if(resultfound) {
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
