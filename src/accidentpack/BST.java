package accidentpack;

import java.util.Comparator;

/**
 * Author Philip Lane
 */
public class BST implements Comparator<AccidentRecord> {
	/**
	 * Represents a node in the binary search tree containing an AccidentRecord object.
	 */
	
	private class Node {
		AccidentRecord data;
		Node left = null;
		Node right = null;
		int leftChildren = 0;
		int rightChildren = 0;

		Node(AccidentRecord data) {
			this.data = data;
		}
	}

	private Node root = null;
	
	public BST(AccidentRecord a) {
		root = new Node(a);
	}
	
	/**
	 * Compares two AccidentRecord objects based on their start times.
	 *
	 * @param a The first AccidentRecord object for comparison.
	 * @param b The second AccidentRecord object for comparison.
	 * @return An integer representing the comparison result.
	 */
	public int compare(AccidentRecord a, AccidentRecord b) {
		return a.getStartTime().compareTo(b.getStartTime());
	}

	/**
	 * Adds a new AccidentRecord to the binary search tree based on start time.
	 *
	 * @param data The AccidentRecord data to be added to the tree.
	 */
	public void add(AccidentRecord data) {
		root = addRecur(root, data);
	}

	private Node addRecur(Node curr, AccidentRecord data) {
		if (curr == null)
			return new Node(data);
		
		if (compare(data, curr.data) < 0) {
			curr.left = addRecur(curr.left, data);
			curr.leftChildren += 1;
		} else if (compare(data, curr.data) == 0) {
			curr.right = addRecur(curr.right, data);
			curr.rightChildren += 1;
		} else if (compare(data, curr.data) > 0) {
			curr.right = addRecur(curr.right, data);
			curr.rightChildren += 1;
		}

		return curr;
	}
	
	/**
	 * Helper method that retrieves the AccidentRecord associated with the specified data from the tree.
	 *
	 * @param data The AccidentRecord data to be retrieved.
	 * @return The AccidentRecord associated with the specified data.
	 */
	public AccidentRecord get(AccidentRecord data) {
		return getRecur(root, data);
	}
	
	/**
	 * Retrieves the number of right children for the given node.
	 *
	 * @param node The node for which to get the number of right children.
	 * @return The number of right children for the given node.
	 */
	private int getRightChildren(Node node) {
		return node.rightChildren;
	}
	
	/**
	 * Retrieves the number of left children for the given node.
	 *
	 * @param node The node for which to get the number of left children.
	 * @return The number of left children for the given node.
	 */
	private int getLeftChildren(Node node) {
		return node.leftChildren;
	}
	
	/**
	 * Recursively searches for the AccidentRecord associated with the specified data in the tree.
	 *
	 * @param curr The current node being considered during recursion.
	 * @param data The AccidentRecord data to be searched for.
	 * @return The AccidentRecord associated with the specified data.
	 */
	private AccidentRecord getRecur(Node curr, AccidentRecord data) {
		if (curr.data == data)
			return curr.data;
		
		if (compare(data, curr.data) < 0)
			getRecur(curr.left, data);
		else if (compare(data, curr.data) > 0)
			getRecur(curr.right, data);
		return curr.data;
	}
	
	public int search(String date) {
		return 0;
	}
	
	public int recursiveSearch(String date) {
		return 0;
	}
}