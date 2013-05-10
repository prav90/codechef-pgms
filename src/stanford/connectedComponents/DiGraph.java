package stanford.connectedComponents;

import java.util.ArrayList;

public class DiGraph {
	private int V;
	private ArrayList<Integer> [] adj;
	public DiGraph(int V) {
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V+1];
		for(int i = 1;i <= V; i++)
			adj[i] = new ArrayList<Integer>();
	}
	
	public void addEdge(int u,int v) {
		adj[u].add(v);
	}
	
	public int V() {
		return V;
	}
	
	public Iterable<Integer> adj(int V) {
		return adj[V];
	}
	
	public DiGraph reverse() {
		DiGraph reverse = new DiGraph(V);
		for(int i = 1; i <= V; i++) {
			for(int u : adj[i]) {
				reverse.addEdge(u, i);
			}
		}
		return reverse;
	}
}
