package ru.anrivlev.lab6.task2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void saveShoppingCarts(ArrayList<ShoppingCart> shoppingCartArrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        LocalDate today = LocalDate.now();
        for (ShoppingCart shoppingCart : shoppingCartArrayList) {
            shoppingCart.setDateOfSerialization(today);
            objectOutputStream.writeObject(shoppingCart);
        }
        objectOutputStream.close();
    }
    public static ArrayList<ShoppingCart> loadShoppingCarts() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<ShoppingCart> shoppingCartArrayList = new ArrayList<>();
        while(true) {
            try{
                shoppingCartArrayList.add((ShoppingCart) objectInputStream.readObject());
            } catch (EOFException e) {
                break;
            }
        }
        objectInputStream.close();
        for (ShoppingCart shoppingCart : shoppingCartArrayList) {
            for (Item item : shoppingCart.getItems()) {
                item.updateCost();
            }
            shoppingCart.setCartTotal();
        }
        return shoppingCartArrayList;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Item milk = new Item(1, "milk", 37);
        Item chewingGum = new Item(2, "chewing gum", 1);
        Item monitor = new Item(3, "monitor", 300);
        Item ring = new Item(4, "golden ring", 1200);
        Item fork = new Item(5, "fork", 50);

        ArrayList<Item> items1 = new ArrayList<>();
        items1.add(milk);
        items1.add(fork);
        ArrayList<Item> items2 = new ArrayList<>();
        items2.add(chewingGum);
        items2.add(monitor);
        items2.add(milk);
        ArrayList<Item> items3 = new ArrayList<>();
        items3.add(ring);

        ShoppingCart cart1 = new ShoppingCart(1, items1);
        ShoppingCart cart2 = new ShoppingCart(2, items2);
        ShoppingCart cart3 = new ShoppingCart(3, items3);

        ArrayList<ShoppingCart> shoppingCartArrayList = new ArrayList<>();
        shoppingCartArrayList.add(cart1);
        shoppingCartArrayList.add(cart2);
        shoppingCartArrayList.add(cart3);

        for (ShoppingCart shoppingCart : shoppingCartArrayList) {
            System.out.println(shoppingCart);
        }

        saveShoppingCarts(shoppingCartArrayList);
        System.out.println("Serialization completed");

        ArrayList<ShoppingCart> shoppingCartArrayListLoaded = loadShoppingCarts();
        System.out.println("Deserialization completed");

        for (ShoppingCart shoppingCart : shoppingCartArrayListLoaded) {
            System.out.println(shoppingCart);
        }
    }
}
