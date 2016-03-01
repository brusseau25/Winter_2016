
/*
 * Brandon Russeau
 * 
 * adapted from @author William Gillespie
 * https://github.com/Wubuntu88/ProductionLine
 *
 * Main driver class for the producer-consumer
 * production line
 */

public class Factory {

	public static void main(String args[]) {

		BoundedBuffer lineOne = new BoundedBuffer();
		BoundedBuffer lineTwo = new BoundedBuffer();
		BoundedBuffer lineThree = new BoundedBuffer();

		Producer workerA = new Producer(lineOne);
		workerA.setName("Worker A");
		ProdCons workerB = new ProdCons(lineOne, lineTwo);
		workerB.setName("Worker B");
		ProdCons workerC = new ProdCons(lineTwo, lineThree);
		workerC.setName("Worker C");
		Consumer workerD = new Consumer(lineThree);
		workerD.setName("Worker D");

		workerA.start();
		workerB.start();
		workerC.start();
		workerD.start();
	}
}
