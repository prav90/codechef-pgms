package sumtrian;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DPSolution {

	/**
	 * @param args
	 */
	
	public static int max(int a,int b) {
		if(a > b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder result = new StringBuilder("");
		while(t > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int [][] input = new int[n][n];
			for(int i = 1; i <= n; i++) {
				StringTokenizer sz = new StringTokenizer(br.readLine().trim()," ");
				for(int j = 0; j < i; j++) {
					input[i-1][j] = Integer.parseInt(sz.nextToken());
				}
			}
			for(int i = 1; i < n; i++) {
				for(int j = i; j >= 0; j--) {
					if(j == 0) {
						input[i][j] += input[i-1][j];
					}
					else {
						input[i][j] += max(input[i-1][j],input[i-1][j-1]);
					}
				}
			}
			int max = 0;
			for(int j = 0; j < n; j++) {
				if(input[n-1][j] > max) max = input[n-1][j];
			}
			result.append(max+"\n");
			t--;
		}
		System.out.print(result);
	}

}
