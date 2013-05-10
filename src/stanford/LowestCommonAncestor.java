package stanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LowestCommonAncestor {
	
	int [] anc;
	int [] depth;
	int root;
	
	LowestCommonAncestor(int N) {
		anc = new int[N+1];
		depth = new int[N+1];
		anc[0] = -1;
		root = -1;
		for(int i = 1; i <= N; i++) {
			anc[i] = i;
		}
	}
	
	void insert(int parent,int child) {
		anc[child] = parent;
	}
	
	void setRoot() {
		for(int i = 1; i < anc.length; i++) {
			if(anc[i] == i) {
				root = i;
				break;
			}
		}
	}
	
	void findDepth() {
		for(int i = 1; i < anc.length; i++) {
			depth[i] = depth(i,0);
		}
	}
	
	private int depth(int i,int depth) {
		if(anc[i] == i)
			return depth;
		return depth(anc[i],depth+1);
	}
	
	int lca(int p, int q) {
		if(depth[p] < depth[q]) {
			while(depth[q] != depth[p]) {
				q = anc[q];
			}
		}
		else if(depth[p] > depth[q]) {
			while(depth[p] != depth[q]) {
				p = anc[p];
			}
		}
		
		while(p != q) {
			p = anc[p];
			q = anc[q];
		}
		return p;
	}
	
	int compute(int p, int q) {
		setRoot();
		findDepth();
		return lca(p,q);
	}
	
	void print() {
		for(int i = 1; i < anc.length; i++) {
			System.out.println("Anc of "+i+" : "+ anc[i]+" depth :"+depth[i]);
		}
	}
	
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			LowestCommonAncestor lca = new LowestCommonAncestor(N);
			while(N-- > 1) {
				StringTokenizer ip = new StringTokenizer(br.readLine()," ");
				lca.insert(Integer.parseInt(ip.nextToken()), Integer.parseInt(ip.nextToken()));
			}
			StringTokenizer ip = new StringTokenizer(br.readLine()," ");
			result.append(lca.compute(Integer.parseInt(ip.nextToken()),Integer.parseInt(ip.nextToken()))+"\n");
			
		}
		System.out.print(result);
	}

}
