public class ShoppingVisitor implements Visitor {
    
    private double total;

    public double getTotal() {
        return total;
    }

    // override the visitor methods,
    // calculating the total.

    @Override
    public void visit(Milk m) {
        total += m.getSubtotal();
    }

    @Override
    public void visit(Fish f) {
        total += f.getSubtotal();
    }

    @Override
    public void visit(Jacket j) {
        total += j.getSubtotal();
    }
}
