/*
 * Brandon Russeau
 * 
 * adapted from @author William Gillespie
 * https://github.com/Wubuntu88/ProductionLine
 *
 */

public class Producer extends Worker {
	private BoundedBuffer buffer;

	public Producer(BoundedBuffer b) {
		buffer = b;
	}

	public void run() {
		while (true) {
			Widget widget = new Widget("widget" + (int) Math.ceil(Math.random() * 10));

			this.makeIsWorking();
			BoundedBuffer.napping();

			buffer.enter(widget);
		}
	}
}