package com.u2team.huansync.establishment.cash.model.classes;

import java.util.List;

/**
 * The CashFull class extends the basic Cash class to include additional information about
 * the list of orders associated with the cash register.
 * 
 * Instances of this class are useful when more detailed information about the orders
 * is required in addition to the standard Cash details.
 * 
 * Note: The primary difference between Cash and CashFull is the inclusion of the listOrders property.
 * 
 */
public class CashFull extends Cash {
    private List<Long> listOrders;

    /**
     * Constructs a CashFull object with the provided list of orders.
     *
     * @param listOrders The list of orders associated with the CashFull object.
     */
    public CashFull(List<Long> listOrders) {
        this.listOrders = listOrders;
    }

    /**
     * Constructs a CashFull object with the provided properties.
     *
     * @param listOrders    The list of orders associated with the CashFull object.
     * @param cashId        Identificador único de la caja.
     * @param state         Estado de la caja (activo o inactivo).
     * @param managerId     Identificador del gerente asociado a la caja.
     * @param openingAmount Monto de apertura de la caja.
     * @param closingAmount Monto de cierre de la caja.
     * @param listOrderId   Lista de identificadores de órdenes asociadas a la caja.
     */
    public CashFull(List<Long> listOrders, long cashId, boolean state, long managerId, double openingAmount, double closingAmount, List<Long> listOrderId) {
        super(cashId, state, managerId, openingAmount, closingAmount, listOrderId);
        this.listOrders = listOrders;
    }

    /**
     * Gets the list of orders associated with the CashFull object.
     *
     * @return The list of orders.
     */
    public List<Long> getListOrders() {
        return listOrders;
    }

    /**
     * Sets the list of orders associated with the CashFull object.
     *
     * @param listOrders The new list of orders.
     */
    public void setListOrders(List<Long> listOrders) {
        this.listOrders = listOrders;
    }
}
