public class Jacket implements Visitable {
    
    private double subtotal;

    public Jacket(int price) {
        this.subtotal = price*1.2;
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

