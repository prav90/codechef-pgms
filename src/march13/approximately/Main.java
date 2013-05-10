package march13.approximately;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();

		int rem = 4687;
		char [] temp = new char[1000003];
		temp[0] = '3';
		temp[1] = '.';
		int i = 1,j =2;
		while(i <= 1000000) {
			rem *= 10;
			if(rem > 33102) {
				temp[j++] = (char)((rem/33102)+ '0');
				rem = rem % 33102;
			}
			else {
				temp[j++] = '0';
			}
			i++;
		}

		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int scale = Integer.parseInt(br.readLine());
			if(scale == 0)
				result.append("3\n");
			else
				result.append(new String(temp,0,scale+2)+"\n");
		}
		
		System.out.print(result);
		

	}

}
