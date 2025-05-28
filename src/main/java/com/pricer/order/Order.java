package com.pricer.order;

import java.util.ArrayList;
import java.util.List;

import java.util.Collections;

public class Order {
    private List<Item> items = new ArrayList<>();

    public Order() {}

    public Order(List<Item> items) {
        this.items.addAll(items);
    }

    public List<Item> getItems() { return Collections.unmodifiableList(items); }

    public void addItem(Item item) { items.add(item); }

}
