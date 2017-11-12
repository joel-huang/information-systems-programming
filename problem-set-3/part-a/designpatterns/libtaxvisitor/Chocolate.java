public class Chocolate implements Visitable {
    
    private double tax;

    public Chocolate(double tax) {
        this.tax = tax;
    }

    public double getFactor() {
        return 0.2;
    }

    public double getHolidayFactor() {
    	return 0.1;
    }

    public double getTax() {
        return tax;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
