package StockObjectList;

public class StockObject {

    private int header;
    String value;

    // Is a doubly linked list - has previous and next pointers
    private StockObject nextStockObject;
    private StockObject prevStockObject;

    StockObject(String s) {
        this.value = s;
        this.header = s.length();
        this.prevStockObject = null;
        this.nextStockObject = null;
    }

    public String getValue() {
        return value;
    }

    public int getHeader() {
        return header;
    }

    public void setValue(String s) {
        this.value = s;
    }

    // There is no setHeader as the header variable derives from
    // the length of the value string.

    public StockObject getNextStockObject() {
        return this.nextStockObject;
    }

    public StockObject getPrevStockObject() {
        return this.prevStockObject;
    }

    public void setNextStockObject(StockObject next) {
        this.nextStockObject = next;
    }

    public void setPrevStockObject(StockObject prev) {
        this.prevStockObject = prev;
    }
}