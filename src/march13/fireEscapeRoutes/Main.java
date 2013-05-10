package march13.fireEscapeRoutes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	static void union(int [] employees,int []size,int p, int q) {
		int proot = find(employees,p);
		int qroot = find(employees,q);
		if(proot != qroot) {
			if(size[qroot] <= size[proot]) {employees[qroot] = proot;size[proot] += size[qroot];}
			else {employees[proot] = qroot;size[qroot] += size[proot];}
		}
	}
	
	static int find(int [] employees, int p) {
		while(employees[p] != p) {
			employees[p] = employees[employees[p]];
			p = employees[p];
		}
		return p;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer sz = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(sz.nextToken());
			int M = Integer.parseInt(sz.nextToken());
			int [] employees = new int[N+1];
			int [] size = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				employees[i] = i;
				size[i] = 1;
			}
			
			while(M-- > 0) {
				sz = new StringTokenizer(br.readLine()," ");
				int p = Integer.parseInt(sz.nextToken());
				int q = Integer.parseInt(sz.nextToken());
				union(employees,size,p,q);
			}
			
			int count = 0;
			long numberofways = 1;
			for(int i = 1; i <= N; i++) {
				if(employees[i] == i) {
					count += 1;
					numberofways *= size[i];
					numberofways %= 1000000007;
				}
			}
			
			result.append(count+" "+numberofways+"\n");
		}
		System.out.print(result);
	}

}
