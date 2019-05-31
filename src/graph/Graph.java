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
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	public Node getNodeByLabel(int label) {
		for (Node n: nodes) {
			if (n.getLabel() == label) {
				return n;
			}
		}
		return null;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public int getNumNodes() {
		return numNodes;
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
	
	public Dijkstra dijkstra(int from, int to) {
		Dijkstra dk = new Dijkstra();
		if (getNodeByLabel(from) == null || getNodeByLabel(to) == null) {
			return null;
		}
		//riempio l'insieme toDo con tutti i nodi del grafo ed
		//inizializzo la distanza dall'origine ad infinito e
		//il nodo precendente a null
		for (int i = 0; i < this.nodes.size(); i++) {
			dk.addDist0(Double.POSITIVE_INFINITY);
			dk.addPrev(null);
			dk.addNodeToDo(i);
		}
		//setUp primo nodo
		int indAttNode = nodes.indexOf(getNodeByLabel(from));
		dk.setDist0(indAttNode, 0.0);
		dk.setPrev(indAttNode, indAttNode);
		
		while(dk.getToDo().size()!=0) {
			indAttNode = dk.getMinDist0();
			Node attNode = nodes.get(indAttNode);
			for (Node n : attNode.getLinkedNodes()) {
				double totDist = dk.getDist0(indAttNode) + 
			}
			
			dk.removeFromToDo(indAttNode);
		}
		return dk;
	}
	
	public void aStar(){
		
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
