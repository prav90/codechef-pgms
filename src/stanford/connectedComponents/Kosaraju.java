package stanford.connectedComponents;

public class Kosaraju {
	private boolean [] marked;
	private int [] id;
	private int count;
	
	public Kosaraju(DiGraph G) {
		DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());
		marked = new boolean[G.V()+1];
		id = new int[G.V()+1];
		for(int u : dfs.reversePost()) {
			if(!marked[u]) {
				dfs(G,u);
				count++;
			}
		}
	}
	
	private void dfs(DiGraph G,int u) {
		marked[u] = true;
		id[u] = count;
		for(int w : G.adj(u)) {
			if(!marked[w]) dfs(G,u);
		}
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String [] args) {
		
	}
	
}
