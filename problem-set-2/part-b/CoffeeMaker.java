
// Cohort Question 2
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

public class CoffeeMaker {
    private static final int tooCold = 55;
    private static final int tooHot = 85;

   
    public void makeCoffee(int temperature) throws TooCold, TooHot {
        if (temperature <= tooCold) throw new TooCold(temperature);
        if (temperature >= tooHot) throw new TooHot(temperature);
        System.out.println("Mmm!");
    }

   public static void main (String[] args) {
       CoffeeMaker c = new CoffeeMaker ();
       int temperature[] = {20,90,60};
       for (int i = 0; i < 3; i++) {
       try {
            c.makeCoffee(temperature[i]);
        }

        // catch the TooCold exception.
        catch (TooCold ex){
            System.out.println("Yuck!");

        }

        // catch the TooHot exception.
        catch (TooHot ex){
            System.out.println("Ouch!");
        }
       }
    }
}
    class TooCold extends Exception {
      
      private int temp;
        public TooCold (int temperature) {
          super("Too Cold "+temperature);
          this.temp = temperature;
        }

    }

    class TooHot extends Exception {

      private int temp;
        public TooHot (int temperature) {
          super("Too Hot"+temperature);
          this.temp = temperature;
        }

    }