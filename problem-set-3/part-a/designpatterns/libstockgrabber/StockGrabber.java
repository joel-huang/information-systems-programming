import java.util.ArrayList;

// Example of StockGrabber: IBM
// IBM has a list of subscribers. They can be added/removed.
// IBM can send a stockUpdate. The observers/subscribers should be notified thru update(),
// which is re-defined in StockOberver.

public class StockGrabber implements Subject {

    private ArrayList<Observer> observerList = new ArrayList<>();

    // Override the 3 methods in the Subject interface.
    // StockGrabber contains a list of all the observers.
    // They can be registered or de-registered.

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    // Send update to Observer o inside observerList

    @Override
    public void stockUpdate(String s) {
        for (Observer o:observerList) {
            o.update(s);
        }
    }


}
