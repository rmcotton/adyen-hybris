package com.adyen.v6.impl.order.strategies;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.strategies.impl.DefaultCreateOrderFromCartStrategy;

public class AdyenCreateOrderFromCartStrategy extends DefaultCreateOrderFromCartStrategy {
    @Override
    protected String generateOrderCode(CartModel cart) {
        if (!cart.getCode().isEmpty()) {
            //Use the Cart code as order code
            return cart.getCode();
        }

        return super.generateOrderCode(cart);
    }
}
