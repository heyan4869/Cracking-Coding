// Given a directed graph, design an algorithm to find out
// whether there is a route between two nodes.
// Idea: use BFS or DFS

package tree;

import java.util.*;


public class FindRoute {
	
	public static class DirectedGraph {

	    private int v;
	    private LinkedList<Integer> edges[];

	    public DirectedGraph(int nodeSize) {
	    	this.v = nodeSize;
	    	this.edges = (LinkedList<Integer>[]) new LinkedList[v];
	    	for (int i = 0; i < v; ++i) {
	    		this.edges[i] = new LinkedList<Integer>();
	    	}
	    }

	    public void addEdge(int v, int w) {
	    	this.edges[v].add(w);
	    }

	    public Iterable<Integer> adj(int v) {
	    	return edges[v];
	    }

	    public int V() {
	    	return v;
	    }

	    public int E() {
	    	int e = 0;
	    	for (LinkedList<Integer> edge : edges)
	    		e += edge.size();
	    	return e;
	    }

	}

	public boolean findRoute(DirectedGraph g, int node1, int node2) {
	    // write implementation here
	    return reachable(g, node1, node2) || reachable(g, node2, node1);
	}

	private boolean reachable(DirectedGraph g, int from, int to) {
	    boolean[] visited = new boolean[g.V()];
	    Stack<Integer> s = new Stack<Integer>();
	    s.push(from);
	    
	    while (!s.isEmpty()) {
	    	int cur = s.pop();
	    	visited[cur] = true;
	    	Iterator<Integer> neighbors = g.adj(cur).iterator();
	    	while (neighbors.hasNext()) {
	    		int neighbor = neighbors.next();
	    		if (!visited[neighbor]) {
	    			if (neighbor == to) {
	    				return true;
	    			}
	    			s.push(neighbor);
	    		}
	    	}
	    }	

	    return false;
	}

}