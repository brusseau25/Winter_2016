/* Brandon Russeau
 * E01160846
 * Linked list class with Node private inner class
 */

public class LinkedList {
	// node class
	private class Node {
		int item;
		Node link;

		public Node() {
			item = Integer.MIN_VALUE;
			link = null;
		}

		public Node(int x, Node p) {
			item = x;
			link = p;
		}
	}

	private Node head;

	public LinkedList() {
		head = null;
	}

	// add node at the start of the list
	public void addToStart(int item) {
		head = new Node(item, head);
	}

	// add node to end of the list
	public void add(int data) {
		Node newLast = new Node();
		if (head == null) {
			addToStart(data);
		}
		Node position = head;
		while (position.link != null) {
			position = position.link;
		}
		newLast.item = data;
		position.link = newLast;
	}

	// delete head node and return false if list is empty
	public boolean deleteHeadNode() {
		if (head != null) {
			head = head.link;
			return true;
		} else
			return false;
	}

	// delete specific node
	public void deleteNode(int target) {
		Node p = head;
		Node position = head;
		if (contains(target)) {
			p = find(target);
			while (position.link != p) {
				position = position.link;
			}
			position.link = p.link;
		}
	}

	// return number of nodes
	public int size() {
		int count = 0;
		Node position = head;

		while (position != null) {
			count++;
			position = position.link;
		}
		return count;
	}

	// returns true if list contains target element
	public boolean contains(int target) {
		return (find(target) != null);
	}

	// find first node to contain target element
	private Node find(int target) {
		Node position = head;
		int item;
		while (position != null) {
			item = position.item;
			if (item == target)
				return position;
			position = position.link;
		}
		return null; // target not found
	}

	// display list
	public void print() {
		Node position = head;
		while (position != null) {
			System.out.print(position.item + " ");
			position = position.link;
		}
		System.out.println();
	}

	private void printListRec(Node p) {
		if (p != null) {
			System.out.print(p.item + " ");
			printListRec(p.link);
		}
	}

}
