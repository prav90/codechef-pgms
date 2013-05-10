package stanford.connectedComponents;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
	private boolean [] marked;
	private Queue<Integer> postOrder;
	
	public DepthFirstOrder(DiGraph G) {
		postOrder = new LinkedList<Integer>();
		marked = new boolean[G.V()+1];
		for(int i = 1; i<= G.V(); i++) {
			if(!marked[i])
				dfs(G,i);
		}
	}
	
	public void dfs(DiGraph G,int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w])
				dfs(G,w);
		}
		postOrder.add(v);
	}
	
	public Iterable<Integer> reversePost() {
		Stack<Integer> stack = new Stack<Integer>();
		for(int v : postOrder)
			stack.push(v);
		return stack;
	}
}
