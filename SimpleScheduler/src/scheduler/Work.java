/*
 * Brandon Russeau
 * COSC 423
 */
package scheduler;

public class Work implements JobWorkable {
	String name = "";

	public Work() {
		name = Thread.currentThread().getName();
	}

	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		// reference to current thread = Thread.currentThread();
		System.out.println(name + " is currently running");
	}

}
