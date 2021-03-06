/* Brandon Russeau
 * COSC 423
 */

public class LinkedList {
	// node class
	private class Node {
		String name;
		int item;
		Node link;

		public Node() {
			name = null;
			item = Integer.MIN_VALUE;
			link = null;
		}

		public Node(String name, int x, Node p) {
			this.name = name;
			item = x;
			link = p;
		}
	}

	private Node head;

	public LinkedList() {
		head = null;
	}

	// add node at the start of the list
	public void addToStart(String name, int item) {
		head = new Node(name, item, head);
	}

	// add node to end of the list
	public void add(String name, int data) {
		Node newLast = new Node();
		if (head == null) {
			addToStart(name, data);
		}
		Node position = head;
		while (position.link != null) {
			position = position.link;
		}
		newLast.name = name;
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
	public void deleteNode(String target) {
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
	public boolean contains(String target) {
		return (find(target) != null);
	}

	// find first node to contain target element
	private Node find(String target) {
		Node position = head;
		String name;
		while (position != null) {
			name = position.name;
			if (name == target)
				return position;
			position = position.link;
		}
		return null; // target not found
	}

	// display list
	public void print() {
		Node position = head;
		String name = position.name;
		System.out.print(position.name + " ");
		while (position != null) {
			if (name == position.name) {
				System.out.print(position.item + " ");
				position = position.link;
			} else {
				name = position.name;
				System.out.print("\n" + position.name + " " + position.item + " ");
				position = position.link;
			}
		}
		System.out.println();
	}
}
