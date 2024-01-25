package com.u2team.huansync.establishment.store.productOrder.model.classes;

import com.u2team.huansync.establishment.order.model.classes.Order;
import com.u2team.huansync.establishment.order.model.classes.OrderStatusEnum;
import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.event.staff.model.classes.Staff;

import java.util.List;

public class ProductOrder {
    private long orderId;
    private long productId;
    private int quantity;
    private long promotionId;

    public long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(long promotionId) {
        this.promotionId = promotionId;
    }

    public ProductOrder() {
    }

    public ProductOrder(long orderId, long productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductOrder{" + "orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", promotionId=" + promotionId +
                '}';
    }

    

    
}

