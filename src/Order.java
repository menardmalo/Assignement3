import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {
    private List<OrderObserver> observers = new ArrayList();
    private double totalPrice;
    private int itemCount;

    public Order() {
    }

    public void attach(OrderObserver observer) {
        this.observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        this.observers.remove(observer);
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCount() {
        return this.itemCount;
    }

    public void addItem(double price) {
        System.out.println("Add an item with a price of " + price);
        ++this.itemCount;
        this.totalPrice += price;
        this.notifyObservers();
    }

    private void notifyObservers() {
        Iterator var1 = this.observers.iterator();

        while(var1.hasNext()) {
            OrderObserver observer = (OrderObserver)var1.next();
            observer.update(this);
        }

    }

    public String toString() {
        return "Order{totalPrice=" + this.totalPrice + ", itemCount=" + this.itemCount + "}";
    }
}
