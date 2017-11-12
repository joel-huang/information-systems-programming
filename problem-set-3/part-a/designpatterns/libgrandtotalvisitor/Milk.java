public class Milk implements Visitable {

	private double subtotal;

	public Milk(int price) {
	    this.subtotal = price;
	}

	@Override
	public double getSubtotal() {
	    return subtotal;
	}

	@Override
	public void accept(Visitor v) {
	    v.visit(this);
	}
}
