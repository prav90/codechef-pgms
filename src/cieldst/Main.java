package cieldst;

import java.util.Scanner;

public class Main {
	
	public static double max(int v1,int v2,int v3,int v4) {
		double max = -1;
		if(v1 > max) max = v1;
		if(v2 > max) max = v2;
		if(v3 > max) max = v3;
		if(v4 > max) max = v4;
		return max;
	}
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		while(N > 0) {
			int ds = scan.nextInt();
			int dt = scan.nextInt();
			int d = scan.nextInt();
			System.out.println(max(0,(d-ds-dt),ds-d-dt,dt-d-ds));
			N--;
		}
	}

}
