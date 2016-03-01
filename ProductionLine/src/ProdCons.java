/*
 * Brandon Russeau
 * 
 * adapted from @author William Gillespie
 * https://github.com/Wubuntu88/ProductionLine
 *
 * Class to make a worker that is both a producer
 * and consumer
 */

public class ProdCons extends Worker {
	private BoundedBuffer consBelt;
	private BoundedBuffer prodBelt;

	public ProdCons(BoundedBuffer consBelt, BoundedBuffer prodBelt) {
		this.consBelt = consBelt;
		this.prodBelt = prodBelt;
	}

	public void run() {
		Widget widget;
		while (true) {
			widget = (Widget) consBelt.remove();
			BoundedBuffer.napping();

			prodBelt.enter(widget);
		}
	}
}