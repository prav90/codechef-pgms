package march13.fireEscapeRoutes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1 {
	
	 private boolean[] marked;   // marked[v] = has vertex v been marked?
	    private int[] id;           // id[v] = id of connected component containing v
	    private int count;          // number of connected components
	    
	    public Main1(Graph G) {
	        marked = new boolean[G.V()];
	        id = new int[G.V()];
	        for (int v = 0; v < G.V(); v++) {
	            if (!marked[v]) {
	                dfs(G, v);
	                count++;
	            }
	        }
	    }

	    // depth first search
	    private void dfs(Graph G, int v) {
	        marked[v] = true;
	        id[v] = count;
	        for (int w : G.adj(v)) {
	            if (!marked[w]) {
	                dfs(G, w);
	            }
	        }
	    }
	static class Graph {
		int V;
		int E;
		ArrayList<Integer> [] adj;
		
		Graph(int V) {
			this.V = V;
			E = 0;
			adj = (ArrayList<Integer>[])new ArrayList[V];
			for(int i = 0; i < V; i++) {
				adj[i] = (ArrayList<Integer>) new ArrayList();
			}
		}
		 public int V() { return V; }
		void addEdge(int u, int v) {
			adj[u].add(v);
			adj[v].add(u);
		}
		
		
		Iterable<Integer> adj(int v) {
			return adj[v];
		}
		
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
			
			Graph g = new Graph(N);
			while(M-- > 0) {
				sz = new StringTokenizer(br.readLine()," ");
				int p = Integer.parseInt(sz.nextToken());
				int q = Integer.parseInt(sz.nextToken());
				g.addEdge(p-1, q-1);
			}
			
			Main1 cc = new Main1(g);
			
			int totalways = 1;
			int [] memberCount = new int[cc.count];
			for(int v = 0; v < N; v++) {
				memberCount[cc.id[v]]++;
			}
			for(int i = 0; i < cc.count; i++) {
				totalways *= memberCount[i];
			}
			totalways %= 1000000007;
			result.append(cc.count+" "+totalways+"\n");
		}
		System.out.print(result);
	}

}
