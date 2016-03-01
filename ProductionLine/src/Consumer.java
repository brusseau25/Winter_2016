/*
 * Brandon Russeau
 * 
 * adapted from @author William Gillespie
 * https://github.com/Wubuntu88/ProductionLine
 *
 */

public class Consumer extends Worker {
	private BoundedBuffer buffer;

	public Consumer(BoundedBuffer b) {
		buffer = b;
	}

	public void run() {
		while (true) {
			BoundedBuffer.napping();

			buffer.remove();
		}
	}
}