/**
 * The {@code ProductBuilder} interface defines a contract for building {@link Product} objects
 * with a fluent builder pattern. It is designed to handle the construction of complex {@link Product}
 * instances with multiple attributes.
 * <p>
 * The builder pattern is implemented to simplify the creation of {@link Product} objects, especially
 * when there are many attributes involved in the process. Each method in this interface represents
 * a specific attribute of the product that can be set during the building process.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>{@code
 * Product product = new ProductBuilderImpl()
 *     .productId(1)
 *     .storeId(123)
 *     .nameProduct("Example Product")
 *     .productPrice(49.99)
 *     .description("A sample product for demonstration purposes.")
 *     .manufacturer("Sample Manufacturer")
 *     .quantity(10)
 *     .type("SampleType")
 *     .build();
 * }</pre>
 * <p>
 * Implementations of this interface should provide a concrete implementation of the builder methods
 * and the {@code build()} method to construct the final {@link Product} object.
 * </p>
 * <p>
 * Note: The {@code type} attribute is expected to be a String representation, such as the name of an enum,
 * for better flexibility.
 * </p>
 * <p>
 * The {@code ProductBuilder} interface aims to enhance the readability and maintainability of code
 * when creating instances of the {@link Product} class.
 * </p>
 *
 * @author Kevin Jimenez and sneiderEsteban
 */
package com.u2team.huansync.establishment.store.product.model.classes.builder;

import com.u2team.huansync.establishment.store.product.model.classes.Product;

/**
 * The {@code ProductBuilder} interface defines a contract for building {@link Product} objects
 * with a fluent builder pattern.
 */
public interface ProductBuilder {

    /**
     * Sets the product ID for the {@link Product} being built.
     *
     * @param productId The ID of the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder productId(long productId);

    /**
     * Sets the store ID for the {@link Product} being built.
     *
     * @param storeId The ID of the store associated with the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder storeId(long storeId);

    /**
     * Sets the name of the product for the {@link Product} being built.
     *
     * @param nameProduct The name of the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder nameProduct(String nameProduct);

    /**
     * Sets the price of the product for the {@link Product} being built.
     *
     * @param productPrice The price of the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder productPrice(Double productPrice);

    /**
     * Sets the description of the product for the {@link Product} being built.
     *
     * @param description The description of the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder description(String description);

    /**
     * Sets the manufacturer of the product for the {@link Product} being built.
     *
     * @param manufacturer The manufacturer of the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder manufacturer(String manufacturer);

    /**
     * Sets the quantity of the product for the {@link Product} being built.
     *
     * @param quantity The quantity of the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder quantity(int quantity);

    /**
     * Sets the type of the product for the {@link Product} being built.
     * The type is expected to be a String representation, such as the name of an enum.
     *
     * @param type The type of the product.
     * @return The updated {@code ProductBuilder} instance.
     */
    ProductBuilder type(String type);

    /**
     * Constructs and returns the final {@link Product} object based on the provided attributes.
     *
     * @return The constructed {@link Product} object.
     */
    Product build();

    /**
     * Placeholder method for an event ID, subject to implementation in concrete builders.
     *
     * @param aLong The event ID.
     * @return The updated {@code ProductBuilder} instance.
     */
    Object eventId(long aLong);
}
