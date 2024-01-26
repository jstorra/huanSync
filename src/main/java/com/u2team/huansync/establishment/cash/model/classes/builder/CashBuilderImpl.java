package com.u2team.huansync.establishment.cash.model.classes.builder;

import com.u2team.huansync.establishment.cash.model.classes.Cash;
import java.util.ArrayList;

/**
 * The CashBuilderImpl class is an implementation of the CashBuilder interface,
 * providing methods to build Cash objects with specific properties.
 */
public class CashBuilderImpl implements CashBuilder {
    
    private Cash cash = new Cash();

    /**
     * Sets the state of the Cash object.
     *
     * @param state The state of the Cash object (true for active, false for inactive).
     * @return The CashBuilderImpl instance for method chaining.
     */
    @Override
    public CashBuilder state(boolean state) {
        cash.setState(state);
        return this;
    }

    /**
     * Sets the manager ID for the Cash object.
     *
     * @param managerId The manager ID associated with the Cash object.
     * @return The CashBuilderImpl instance for method chaining.
     */
    public CashBuilder managerId(long managerId) {
        cash.setManagerId(managerId);
        return this;
    }

    /**
     * Sets the opening amount of the Cash object.
     *
     * @param openingAmount The opening amount of the Cash object.
     * @return The CashBuilderImpl instance for method chaining.
     */
    @Override
    public CashBuilder openingAmount(double openingAmount) {
        cash.setOpeningAmount(openingAmount);
        return this;
    }

    /**
     * Sets the closing amount of the Cash object.
     *
     * @param closingAmount The closing amount of the Cash object.
     * @return The CashBuilderImpl instance for method chaining.
     */
    @Override
    public CashBuilder closingAmount(double closingAmount) {
        cash.setClosingAmount(closingAmount);
        return this;
    }

    /**
     * Builds and returns the Cash object based on the provided properties.
     *
     * @return The constructed Cash object.
     */
    @Override
    public Cash build() {
        return cash;
    }

    /**
     * Sets the cash ID for the Cash object.
     *
     * @param cashId The unique identifier for the Cash object.
     * @return The CashBuilderImpl instance for method chaining.
     */
    public CashBuilder cashId(long cashId) {
        cash.setCashId(cashId);
        return this;
    }

    // Uncomment the following method if Order class is available
    // /**
    //  * Sets the list of orders for the Cash object.
    //  *
    //  * @param order The list of orders associated with the Cash object.
    //  * @return The CashBuilderImpl instance for method chaining.
    //  */
    
    // @Override
    // public CashBuilder order(ArrayList<Order> order) {
    //     cash.setOrder(order);
    //     return this;
    // }
}
