package accidentpack;

public class BST<K extends Comparable<K>, V> {
	private class Node {
		K key;
		V value;
		Node left = null;
		Node right = null;
		int leftChildren = 0;
		int rightChildren = 0;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node root = null;

	private int compare(K a, K b) {
		return a.compareTo(b);
	}

	public void add(K key, V value) {
		root = addRecur(root, key, value);
	}

	private Node addRecur(Node curr, K key, V value) {
		if (curr == null)
			return new Node(key, value);
		
		if (compare(key, curr.key) < 0) {
			curr.left = addRecur(curr.left, key, value);
			curr.leftChildren += 1;
		}
		else if (compare(key, curr.key) > 0)
			curr.right = addRecur(curr.right, key, value);
			curr.rightChildren += 1;
		return curr;
	}

	public V get(K key) {
		return getRecur(root, key);
	}
	
	private Node getRightChild(Node node) {
		return node.
	}
	
	private V getRecur(Node curr, K key) {
		if (curr.key == key)
			return curr.value;
		
		if (compare(key, curr.key) < 0)
			getRecur(curr.left, key);
		else if (compare(key, curr.key) > 0)
			getRecur(curr.right, key);
		return curr.value;
	}
}