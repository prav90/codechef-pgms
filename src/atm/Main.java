package atm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip = br.readLine();
		StringBuilder result = new StringBuilder();
		while(ip != null) {
			StringTokenizer sz = new StringTokenizer(ip," ");
			int money = Integer.parseInt(sz.nextToken());
			double balance = Double.parseDouble(sz.nextToken());
			if(money <= balance - 0.5) {
				if(money % 5 == 0) {
					balance = balance - money - 0.5;
					
				}
			}
			result.append(String.format("%.2f\n", balance));
			//System.out.printf("%.2f\n",balance);
			ip = br.readLine();
		}
		System.out.print(result);
	}

}
