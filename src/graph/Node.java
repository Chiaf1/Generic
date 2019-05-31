package graph;

import java.util.ArrayList;
import java.util.List;


public class Node implements Comparable<Node> {
	private List<Edge> links = new ArrayList<>();
	private List<Node> linkedNodes = new ArrayList<>();
	private int label;
	
	public Node(int label) {
		this.label = label;
	}
	
	@Override
	public int compareTo(Node o) {
		if (this.label==o.getLabel()) {
			return 0;
		}else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("\nNodo: " + " " + label + " ");
		for (Edge e : links) {
			str.append("\n" + e);
		}
		str.append("\nConnesso a:");
		for (Node n : linkedNodes) {
			str.append("\n" + n.label);
		}
		return str.toString();
	}
	
	public int getLabel() {
		return label;
	}

	public List<Node> getLinkedNodes() {
		return linkedNodes;
	}
	
	public List<Edge> getLinks() {
		return links;
	}
	
	public void setLinkedNodes(Node _linkedNode) {
		this.linkedNodes.add(_linkedNode);
	}
	

	public void addEdge(Edge newEdge) {
		links.add(newEdge);
	}

}
