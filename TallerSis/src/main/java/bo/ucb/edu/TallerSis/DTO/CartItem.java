package bo.ucb.edu.TallerSis.DTO;

public class CartItem {
    private Food food;
    private Integer quantity;
    private Double price;

    public CartItem(Food food, Integer quantity, Double price) {
        this.food = food;
        this.quantity = quantity;
        this.price = price;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "food=" + food +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
