package com.pricer.main.pricer.main;

import com.pricer.main.pricer.PricingStrategy;
import com.pricer.main.pricer.SimpleStrategy;
import com.pricer.order.Item;
import com.pricer.order.Order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPricer {
    private final PricingStrategy defaultStrategy = new SimpleStrategy(BigDecimal.ONE);
    private final Map<String, PricingStrategy> internalMap = new HashMap<>();

    public MainPricer(List<PricingStrategy> strategies) {
        strategies.forEach(strategy -> {
            strategy.getEligibleIds().forEach(id -> {
                internalMap.put(id, strategy);
            });
        });
    }

    public BigDecimal price(Order order) {
        BigDecimal result = BigDecimal.ZERO;
        for (Item item: order.getItems()) {
            var pricer = internalMap.getOrDefault(item.id(), defaultStrategy);
            result = result.add(pricer.getPrice(item));
        }
        return result;
    }

}
