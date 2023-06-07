public class QuantityObserver implements OrderObserver {
    private static final double DEFAULT_SHIPPING_COST = 10;
    private static final int MIN_ITEMS_FOR_FREE_SHIPPING = 5;
    private boolean shippingCost = false;
    private boolean freeShipping = false;

    public QuantityObserver() {
    }

    public void update(Order order) {
        double totalPrice = order.getTotalPrice();
        if (order.getCount() < MIN_ITEMS_FOR_FREE_SHIPPING) {
            if (!this.shippingCost) {
                totalPrice += DEFAULT_SHIPPING_COST;
                order.setTotalPrice(totalPrice);
                System.out.println("Until you have 5 or more items, quantity monitor set the shipping cost to $10.");
                this.shippingCost = true;
            }
        } else if (!this.freeShipping) {
            totalPrice -= DEFAULT_SHIPPING_COST;
            order.setTotalPrice(totalPrice);
            System.out.println("Because you have 5 items or more, quantity monitor set the shipping cost to $0.");
        }

    }
}
