package riseandfall;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static long getLastDigit(long x,int n, int k) {
		if (n == 1)
			return x;
		else if(n%2 == 0) {
			return getLastDigit((x*x)%k,n/2,k);
		}
		else{
			return getLastDigit((x*x)%k,(n-1)/2,k);
		}
	}
	public static long getLastDigits(int n,int k,int powers) {
		long res = 1;
		for(int i=1;i<=n;i++){
			res = (res*n)%k;
		}
		
		return res;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip = br.readLine();
		int num = Integer.parseInt(ip);
		while(num > 0) {
			ip = br.readLine();
			String [] split = ip.split(" ");
			int n = Integer.parseInt(split[0]);
			int k = Integer.parseInt(split[1]);
			Double lastDiv = Math.pow(10, k);
			
			long last = getLastDigit(n,n,lastDiv.intValue());
			
			
			Double firstX = n*Math.log10(n);
			Double first = Math.ceil(Math.pow(10,firstX-Math.floor(firstX)+k-1));
			
			System.out.printf("%d %0"+k+"d\n",first.intValue(),last); 
			
			BigNum bg = new BigNum(n);
			bg.getFirstAndLast(k);
			num --;
		}
	}
}
class BigNum {
	String num;
	BigNum(int n){
		num = ""+n;
		computePower(n);
	}
	
	void computePower(int n){
		for(int i = 1 ; i < n ; i++ ) {
			int l = num.length();
			char [] temp = num.toCharArray();
			int carry = 0;
			for(int j = l-1 ; j >= 0 ; j-- ) {
				int res = (temp[j] - 48) * n;
				res += carry; // if carry exists for before multiplication
				carry = res/10; // carry for the next iteration
				res = res%10; // result for the current iteration
				temp[j] = (char) ('0' + res);
			}
			num = new String(temp);
			if(carry != 0)
				num = carry+ num;
			//num = reverse(temp.toCharArray());
		}
	}
	
	
	void getFirstAndLast(int n){
		String op = "";
		op+= num.substring(0, n);
		op+=" ";
		op+= num.substring(num.length()-n,num.length());
		System.out.println(op);
	}
	
	public String toString(){
		return num;
	}
	
	
}