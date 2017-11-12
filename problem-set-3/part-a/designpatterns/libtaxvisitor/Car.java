public class Car implements Visitable {

    private double tax;

    public Car(double tax) {
        this.tax = tax;
    }

    public double getFactor() {
        return 0.4;
    }

    public double getHolidayFactor() {
    	return 0.3;
    }

    public double getTax() {
        return tax;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
