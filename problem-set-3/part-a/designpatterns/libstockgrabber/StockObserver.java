// An instance of StockObserver is one subscriber.
// The subscriber has a name, e.g. 'scott' or 'jim'.
// To notify the subscriber when a stock has updated,
// call the update() method to print the message.

public class StockObserver implements Observer {

	private String observerName;

	// StockObserver can be constructed using 1. the StockGrabber,
	// which contains the list of subscribers,
	// and 2. the Observer name.
	StockObserver(StockGrabber stock, String observerName) {
		this.observerName = observerName;
		stock.register(this);
	}

	// Override the update method in the Observer interface,
	// to apply the stock message received format.
	@Override
	public void update (String message) {
		System.out.println(name+": Message received: "+message);
	}
}
