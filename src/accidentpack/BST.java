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
		Node localRoot = root;
		int counter = 0;

		while(localRoot != null) {
			if (localRoot.data.getStartTime().compareTo(date) < 0) {
				localRoot = localRoot.right;
			} else {
				counter += localRoot.rightChildren + 1;
				localRoot = localRoot.left;
			}
		}
		
		return counter;
	}
	
	public int recurSearch(String date) {
		return recurSearch(date, root);
	}
	
	private int recurSearch(String date, Node localRoot) {
		if (localRoot == null) {
			return 0;
		} if (localRoot.data.getStartTime().compareTo(date) >= 0) {
			return 1 + recurSearch(date, localRoot.left) + recurSearch(date, localRoot.right);
		}
		return recurSearch(date, localRoot.right);
	}
}
