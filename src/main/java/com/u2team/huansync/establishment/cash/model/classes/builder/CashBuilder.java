package com.u2team.huansync.establishment.cash.model.classes.builder;

import com.u2team.huansync.establishment.cash.model.classes.Cash;

import java.util.ArrayList;

/**
 * The CashBuilder interface defines a contract for building Cash objects.
 * Classes implementing this interface should provide methods for setting various
 * properties of a Cash object and ultimately building the Cash instance.
 */
public interface CashBuilder {

    /**
     * Sets the state of the Cash object.
     *
     * @param state The state of the Cash object (true for active, false for inactive).
     * @return The CashBuilder instance for method chaining.
     */
    CashBuilder state(boolean state);

    /**
     * Sets the opening amount of the Cash object.
     *
     * @param openingAmount The opening amount of the Cash object.
     * @return The CashBuilder instance for method chaining.
     */
    CashBuilder openingAmount(double openingAmount);

    /**
     * Sets the closing amount of the Cash object.
     *
     * @param closingAmount The closing amount of the Cash object.
     * @return The CashBuilder instance for method chaining.
     */
    CashBuilder closingAmount(double closingAmount);

    // Uncomment the following line if Order class is available
    // CashBuilder order(ArrayList<Order> order);

    /**
     * Builds and returns the Cash object based on the provided properties.
     *
     * @return The constructed Cash object.
     */
    Cash build();
}
