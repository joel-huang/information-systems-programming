public class Fish implements Visitable {
    
    private double subtotal;

    public Fish(int price, int weight) {
        this.subtotal = price*weight;
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

