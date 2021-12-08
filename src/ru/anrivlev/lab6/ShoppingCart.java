package ru.anrivlev.lab6;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1;

    private final int cartID;
    private ArrayList<Item> items;
    private int itemCount;
    private static transient double cartTotal = 0;

    public ShoppingCart(int cartID, ArrayList<Item> items) {
        this.cartID = cartID;
        this.items = new ArrayList<>(items);
        this.itemCount = items.size();
        cartTotal++;
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
}
