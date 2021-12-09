package ru.anrivlev.lab6.task2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int cartID;
    private ArrayList<Item> items;
    private int itemCount;
    private transient double cartTotal = 0;
    private LocalDate dateOfSerialization;

    public ShoppingCart(int cartID, ArrayList<Item> items) {
        this.cartID = cartID;
        this.items = new ArrayList<>(items);
        this.itemCount = items.size();
        for (int i = 0; i < items.size(); i++) {
            cartTotal = cartTotal + items.get(i).getCost();
        }
    }

    public int getCartID() {
        return cartID;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal() {
        for (Item item : this.items) {
            this.cartTotal = this.cartTotal + item.getCost();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Shopping Cart{" +
                "CartID=" + this.cartID +
                ", itemCount=" + this.itemCount +
                ", cartTotal=" + this.cartTotal +
                ", items{");
        for (int i = 0; i < this.itemCount; i++) {
            result.append(this.items.get(i));
            if (i != this.itemCount - 1) {
                result.append(", ");
            }
        }
        result.append("}")
                .append(", dateOfSerialization=")
                .append(this.dateOfSerialization)
                .append("}");
        return result.toString();
    }

    public LocalDate getDateOfSerialization() {
        return dateOfSerialization;
    }

    public void setDateOfSerialization(LocalDate dateOfSerialization) {
        this.dateOfSerialization = dateOfSerialization;
    }
}
