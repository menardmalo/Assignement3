public class PriceObserver implements OrderObserver {
    private static final double DISCOUNT_AMOUNT = 20;
    private boolean discounted = false;

    public PriceObserver() {
    }

    public void update(Order order) {
        if (!discounted && order.getTotalPrice() > DISCOUNT_AMOUNT) {
            double discountedPrice = order.getTotalPrice() - DISCOUNT_AMOUNT;
            order.setTotalPrice(discountedPrice);
            System.out.println("Price monitor applied a $20 discount. New total price: $" + discountedPrice);
            discounted = true;
        }

    }
}
