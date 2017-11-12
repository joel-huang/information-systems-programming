public class AreaVisitor implements Visitor {
    
    private double totalArea;

    public double getTotalArea() {
        return totalArea;
    }

    // Override visitor methods. (Visit)
    @Override
    public void visit(Circle c) {
        totalArea += Math.PI * Math.pow(c.getRadius(), 2);
    }

    @Override
    public void visit(Square s) {
        totalArea += s.getSide() * s.getSide();
    }

    @Override
    public void visit(Rectangle r) {
        totalArea += r.getSides()[0] * r.getSides()[1];
    }
}

