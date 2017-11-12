public class Square implements Visitable {

	// store 1 side as required
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
