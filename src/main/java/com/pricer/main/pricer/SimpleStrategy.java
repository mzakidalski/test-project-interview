package com.pricer.main.pricer;

import com.pricer.order.Item;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class SimpleStrategy implements PricingStrategy {

    private final BigDecimal unitPrice;
    private Set<String> ids = new HashSet<>();

    public SimpleStrategy(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public BigDecimal getPrice(Item item) {
        return unitPrice.multiply( BigDecimal.valueOf(item.quantity()));
    }

    @Override
    public Set<String> getEligibleIds() {
        return ids;
    }

    @Override
    public void addEligibleId(String id) {
        ids.add(id);
    }

    @Override
    public void removeEligibleId(String id) {
        ids.remove(id);
    }
}
