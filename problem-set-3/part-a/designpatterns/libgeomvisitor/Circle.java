import java.lang.Math;

public class Circle implements Visitable {
    private int rad;

    public Circle(int rad) {
        this.rad = rad;
    }

    public int getRadius() {
        return rad;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
