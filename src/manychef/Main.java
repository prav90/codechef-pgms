package manychef;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static StringBuilder op = new StringBuilder();
	
	public static boolean check(char c,char d,char e,char f) {
		if((c == 'C' || c == '?') && (d == 'H' || d == '?') && (e == 'E' || e == '?') && (f == 'F' || f == '?'))
			return true;
		return false;
	}
	
	public static void getMaxChefString(char [] ip) {
		int n = ip.length - 1;
		for(int i = n; i >= 0;) {
			if(i >=3 && check(ip[i-3],ip[i-2],ip[i-1],ip[i])) {
				ip[i-3] = 'C';
				ip[i-2] = 'H';
				ip[i-1] = 'E';
				ip[i] = 'F';
				i-=4;
			}
			else {
				if(ip[i] == '?') ip[i] = 'A';
				i--;
			}
		}
		op.append(ip);
		op.append("\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		while(N > 0) {
			String ip = scan.next();
			getMaxChefString(ip.toCharArray());
			N--;
		}
		System.out.println(op);
	}

}
