package StockObjectList;

public class Main {

    public static void main(String[] args) {
        StockObjectList sol = new StockObjectList();
        sol.enterObject("Ammunition, 5.56mm");
        sol.enterObject("Compass, Navigation");
        sol.enterObject("Ammunition, 7.62mm");
        sol.enterObject("Rifle Cleaning Kit, SAR 21");
        sol.enterObject("Magazine, SAR 21");

        System.out.println("Displaying StockObjects:");
        sol.displayObject(0);
        sol.displayObject(1);
        sol.displayObject(2);
        sol.displayObject(3);
        sol.displayObject(4);
        System.out.println(" ");

        System.out.println("Dumping all StockObjects:");
        sol.dumpObjects();
    }

}
