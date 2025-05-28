package com.pricer.main.pricer;

import com.pricer.order.Item;

import java.math.BigDecimal;
import java.util.Set;

public interface PricingStrategy {
    BigDecimal getPrice(Item item);
    Set<String> getEligibleIds();
    void addEligibleId(String id);
    void removeEligibleId(String id);
}
