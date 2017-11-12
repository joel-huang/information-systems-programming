package StockObjectList;

// This is the doubly linked list that stores StockObjects.
public class StockObjectList {

    private int size;
    private StockObject firstObject;
    private StockObject lastObject;

    public StockObjectList() {
        this.firstObject = null;
        this.lastObject = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Creates and inserts a StockObject in the list while ensuring the order.
    public void enterObject(String objectName) {

        StockObject newStockObject = new StockObject(objectName);

        // If the list is empty, the new Object is the first and last.
        if (isEmpty()) {
            firstObject = newStockObject;
            lastObject = newStockObject;
            size++;
            return;
        }

        // If the list has existing StockObjects, we need to check where
        // to insert the new StockObject. The list is sorted in ascending
        // order of StockObject headers.

        // If the header is smaller than all other headers in the list,
        // (which can be reduced to: smaller than the first header in
        // the list) then insert at the head of the list.
        if (newStockObject.getHeader() < firstObject.getHeader()) {

            // New StockObject points to old first object.
            newStockObject.setNextStockObject(firstObject);
            firstObject.setPrevStockObject(newStockObject);
            firstObject = newStockObject;
            size++;
            return;
        }

        // If the header is larger than all other headers in the list,
        // insert at the end of the list.
        if (newStockObject.getHeader() > lastObject.getHeader()) {
            lastObject.setNextStockObject(newStockObject);
            newStockObject.setPrevStockObject(lastObject);
            lastObject = newStockObject;
            size++;
            return;
        }

        // If the header value is somewhere in between the first and
        // last headers, we need to iterate through the headers to find
        // the correct placement. Begin with the first object.

        StockObject discoveredStockObject = firstObject;

        do {

            // Shift the discoveredStockObject tracker to the point where the header
            // to be inserted is at the correct position:

            // Move the tracker to the next StockObject as long as the header is
            // larger or equal to the headers in the list. We should end up with the
            // tracker (discoveredStockObject) positioned at the first StockObject with
            // header greater than newStockObject's.
            if (newStockObject.getHeader() >= discoveredStockObject.getHeader()) {
                discoveredStockObject = discoveredStockObject.getNextStockObject();
            }

            // Once at this position, prime for insertion by rearranging the connections.
            else {
                StockObject previousDiscoveredStockObject = discoveredStockObject.getPrevStockObject();
                previousDiscoveredStockObject.setNextStockObject(newStockObject);
                newStockObject.setNextStockObject(discoveredStockObject);
                discoveredStockObject.setPrevStockObject(newStockObject);
                size++;
                return;
            }

        } while (true);

    }

    // Returns the value of the StockObject at the specified position.
    public String displayObject(int position) {
        int counter = 0;
        StockObject currentStockObject = firstObject;

        while (counter < position) {
            currentStockObject = currentStockObject.getNextStockObject();
            counter++;
        }
        System.out.println(currentStockObject.getValue());
        return currentStockObject.getValue();
    }

    public void dumpObjects() {

        StockObject currentStockObject = firstObject;

        System.out.print("Stock Object List: ");

        while (currentStockObject != lastObject) {
            System.out.print(currentStockObject.getValue()+": "+currentStockObject.getHeader()+" <-> ");
            currentStockObject = currentStockObject.getNextStockObject();
        }

        if (currentStockObject == lastObject) {
            System.out.println(currentStockObject.getValue()+": "+currentStockObject.getHeader());
        }
    }
}
