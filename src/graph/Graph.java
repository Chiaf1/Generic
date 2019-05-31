package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<Node> nodes = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();
	private int numNodes;

	public Graph(int nodes) {
		numNodes = nodes;
		for (int i = 0; i < nodes; i++) {
			this.nodes.add(new Node(i));
		}
	}

	public void addEdgeUnoriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}

	public void addEdgeUnoriented(int from, int to, int weight) {
		Edge edge = new Edge(nodes.get(from), nodes.get(to), weight);

		if (!edges.contains(edge)) {
			edge.getStartNode().setLinkedNodes(edge.getEndNode());
			edge.getEndNode().setLinkedNodes(edge.getStartNode());
			edge.getStartNode().addEdge(edge);
			edge.getEndNode().addEdge(edge);
			edges.add(edge);
		}
	}

	public void addEdgeOriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}

	public void addEdgeOriented(int from, int to, int weight) {
		Edge edge = new Edge(nodes.get(from), nodes.get(to), weight);

		if (!edges.contains(edge)) {
			edge.getStartNode().setLinkedNodes(edge.getEndNode());
			edge.getStartNode().addEdge(edge);
			edges.add(edge);
		}
	}

	public void print() {
		for (Node n : nodes) {
			System.out.println(n);
		}
		System.out.print("\n\n");
		for (Edge e : edges) {
			System.out.println(e + " ");
		}
	}
}
