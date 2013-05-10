package lcaunionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class UF {
	
	private int [] UF;
	private int count;
	
	UF(int N) {
		UF = new int[N];
		count = N;
		for(int i = 0; i < N; i++)
			UF[i] = i;
	}
	int find(int x) {
		return UF[x];
	}
	void union(int x,int y) {
		if(isConnected(x,y)) return;
		int pid = UF[x];
		for(int i = 0; i < UF.length; i++) {
			if(UF[i] == pid)
				UF[i] = UF[y];
		}
		count--;
	}
	
	int count() {
		return count;
	}
	
	boolean isConnected(int x,int y) {
		return UF[x] == UF[y]?true:false;
	}
	
	void print() {
		for(int i = 0; i < UF.length; i++) {
			System.out.print(UF[i]+" ");
		}
		System.out.println();
	}
}

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
	}

}
