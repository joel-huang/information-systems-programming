public class TaxVisitor implements Visitor {

    private double total;
    private String name;

    public TaxVisitor(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }


    @Override
    public void visit(Car c) {

        double tax;

        if (name.equals("TAXHOLIDAY")) {
            tax = c.getTax()*c.getHolidayFactor();
        } else {
            tax = c.getTax()*c.getFactor();
        }

        total += tax;
    }

    @Override
    public void visit(Electronics e) {

        double tax;

        if (name.equals("TAXHOLIDAY")) {
            tax = e.getTax()*e.getHolidayFactor();
        } else {
            tax = e.getTax()*e.getFactor();
        }

        total += tax;
    }

    @Override
    public void visit(Chocolate c) {

        double tax;

        if (name.equals("TAXHOLIDAY")) {
            tax = c.getTax()*c.getHolidayFactor();
        } else {
            tax = c.getTax()*c.getFactor();
        }

        total += tax;
    }
}


