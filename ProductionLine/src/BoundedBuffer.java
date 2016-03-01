/*
 * Brandon Russeau
 * 
 * adapted from @author William Gillespie
 * https://github.com/Wubuntu88/ProductionLine
 *
 */

public class BoundedBuffer {
	private static final int BUFFER_SIZE = 3;
	private int count;
	private int in;
	private int out;
	private Object[] buffer;
	public static final int SLEEP = 5;

	public BoundedBuffer() {
		count = 0;
		in = 0;
		out = 0;
		buffer = new Object[BUFFER_SIZE];
	}

	public static void napping() {
		int sleepTime = (int) (SLEEP * Math.random());
		try {
			Thread.sleep(sleepTime * 1000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	public synchronized void enter(Object item) {
		Worker worker = (Worker) Thread.currentThread();
		String workerName = worker.getName();
		Widget widget = (Widget) item;
		while (count == BUFFER_SIZE) {
			try {
				System.out.println(workerName + " is waiting to put " + widget.getName() + " on the conveyer");
				worker.makeIsWaiting();
				wait();

			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
		Thread currentThread = Thread.currentThread();

		worker.makeIsIdle();

		String currentThreadName = currentThread.getName();
		System.out.println(currentThreadName + " is working on " + widget.getName());
		System.out.println(currentThreadName + " is placing " + widget.getName() + " on the belt");

		count++;
		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;
		BoundedBuffer.napping();
		notify();

	}

	public synchronized Object remove() {
		Widget widget;
		Worker worker = (Worker) Thread.currentThread();
		while (count == 0) {
			try {
				String workerName = worker.getName();
				System.out.println(workerName + " is idle");
				worker.makeIsIdle();
				wait();
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}

		worker.makeIsWorking();

		count--;
		widget = (Widget) buffer[out];
		buffer[out] = null;
		out = (out + 1) % BUFFER_SIZE;

		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is has retrieved " + widget.getName());
		System.out.println(currentThreadName + " is working on " + widget.getName());

		notify();

		return widget;
	}
}