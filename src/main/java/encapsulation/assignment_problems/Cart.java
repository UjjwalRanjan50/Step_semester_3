package encapsulation.assignment_problems;

public class Cart {
    private final String cartId;
    private int[] prices;
    private int count;

    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.prices = new int[maxCapacity];
        this.count = 0;
    }

    public void addItem(int price) {
        if (count < prices.length) {
            prices[count++] = price;
        } else {
            System.out.println("Cart is full.");
        }
    }

    public int getTotal() {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += prices[i];
        }
        return sum;
    }

    public int getItemCount() {
        return count;
    }
    
    public String getCartId() {
        return cartId;
    }
}
