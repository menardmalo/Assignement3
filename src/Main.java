public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Order order = new Order();
        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();
        order.attach(priceObserver);
        order.attach(quantityObserver);
        order.addItem(50.0D);
        System.out.println(order);
        order.addItem(70.0D);
        System.out.println(order);
        order.addItem(80.0D);
        System.out.println(order);
        order.addItem(60.0D);
        System.out.println(order);
        order.addItem(30.0D);
        System.out.println(order);
        order.detach(quantityObserver);
        order.addItem(40.0D);
        System.out.println(order);
    }
}