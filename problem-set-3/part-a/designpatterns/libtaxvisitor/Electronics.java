public class Electronics implements Visitable {
    
    private double tax;

    public Electronics(double tax) {
        this.tax = tax;
    }

    public double getFactor() {
        return 0.8;
    }

    public double getHolidayFactor() {
    	return 0.5;
    }

    public double getTax() {
        return tax;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
