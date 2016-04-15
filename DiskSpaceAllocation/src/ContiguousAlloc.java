/* Brandon Russeau
 * COSC 423
 */
public class ContiguousAlloc {
	LinkedList diskSpace = null;
	int counter = 1;
	int size = 0;

	public ContiguousAlloc(int size) {
		diskSpace = new LinkedList();
		this.size = size;
	}

	public void add(String name, int size) {
		for (int i = 0; i < size; i++) {
			diskSpace.add(name, counter);
		}
		counter++;
	}

	public void del(String name) {
		for (int i = 0; i < diskSpace.size(); i++) {
			diskSpace.deleteNode(name);
		}
	}

	public void read(String name) {
		System.out.println("Reading the file: " + name);
	}

	public void print() {
		diskSpace.print();
	}
}
