/**
 * The {@code ProductConcreteBuilder} class is an implementation of the {@link ProductBuilder} interface,
 * responsible for constructing {@link Product} objects with specific attributes. It follows the fluent builder pattern
 * to facilitate the creation of complex product instances.
 * <p>
 * Example usage:
 * </p>
 * <pre>{@code
 * Product product = new ProductConcreteBuilder()
 *     .productId(1)
 *     .storeId(123)
 *     .nameProduct("Example Product")
 *     .productPrice(49.99)
 *     .description("A sample product for demonstration purposes.")
 *     .manufacturer("Sample Manufacturer")
 *     .quantity(10)
 *     .type("MANGA")
 *     .build();
 * }</pre>
 * <p>
 * The {@code ProductConcreteBuilder} class provides methods for setting various attributes of the
 * {@link Product} being constructed, including product ID, store ID, name, price, description, manufacturer,
 * quantity, and type. The {@code build()} method finalizes the construction process and returns the
 * resulting {@link Product} object.
 * </p>
 * <p>
 * Note: The {@code type} attribute is set using a String representation, such as the name of an enum,
 * for better flexibility.
 * </p>
 * <p>
 * This builder pattern enhances the readability and maintainability of code when creating instances
 * of the {@link Product} class with multiple attributes.
 * </p>
 *
 * @author Kevin Jimenez
 */
package com.u2team.huansync.establishment.store.product.model.classes.builder;

import com.u2team.huansync.establishment.store.product.model.classes.Product;
import com.u2team.huansync.establishment.store.product.model.classes.TypeProductEnum;

/**
 * The {@code ProductConcreteBuilder} class is an implementation of the {@link ProductBuilder} interface,
 * responsible for constructing {@link Product} objects with specific attributes.
 */
public class ProductConcreteBuilder implements ProductBuilder {

    private Product product = new Product();

    /**
     * Sets the product ID for the {@link Product} being built.
     *
     * @param productId The ID of the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder productId(long productId) {
        product.setProductId(productId);
        return this;
    }

    /**
     * Sets the store ID for the {@link Product} being built.
     *
     * @param storeId The ID of the store associated with the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder storeId(long storeId) {
        product.setStoreId(storeId);
        return this;
    }

    /**
     * Sets the name of the product for the {@link Product} being built.
     *
     * @param nameProduct The name of the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder nameProduct(String nameProduct) {
        product.setNameProduct(nameProduct);
        return this;
    }

    /**
     * Sets the price of the product for the {@link Product} being built.
     *
     * @param productPrice The price of the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder productPrice(Double productPrice) {
        product.setProductPrice(productPrice);
        return this;
    }

    /**
     * Sets the description of the product for the {@link Product} being built.
     *
     * @param description The description of the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder description(String description) {
        product.setDescription(description);
        return this;
    }

    /**
     * Sets the manufacturer of the product for the {@link Product} being built.
     *
     * @param manufacturer The manufacturer of the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder manufacturer(String manufacturer) {
        product.setManufacturer(manufacturer);
        return this;
    }

    /**
     * Sets the quantity of the product for the {@link Product} being built.
     *
     * @param quantity The quantity of the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder quantity(int quantity) {
        product.setQuantity(quantity);
        return this;
    }

    /**
     * Sets the type of the product for the {@link Product} being built using a String representation.
     * The type is expected to be a name corresponding to one of the enum constants in {@link TypeProductEnum}.
     *
     * @param type The type of the product.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public ProductBuilder type(String type) {

        if (type.equalsIgnoreCase("MANGA")) {
            product.setType(TypeProductEnum.MANGA);
        }

        if (type.equalsIgnoreCase("MULTIMEDIA")) {
            product.setType(TypeProductEnum.MULTIMEDIA);
        }

        if (type.equalsIgnoreCase("ART")) {
            product.setType(TypeProductEnum.ART);
        }

        if (type.equalsIgnoreCase("FIGURES")) {
            product.setType(TypeProductEnum.FIGURES);
        }

        if (type.equalsIgnoreCase("SOUVENIERS")) {
            product.setType(TypeProductEnum.SOUVENIRS);
        }

        if (type.equalsIgnoreCase("CLOTHING")) {
            product.setType(TypeProductEnum.CLOTHING);
        }

        if (type.equalsIgnoreCase("TECHNOLOGY")) {
            product.setType(TypeProductEnum.TECHNOLOGY);
        }

        return this;
    }

    /**
     * Constructs and returns the final {@link Product} object based on the provided attributes.
     *
     * @return The constructed {@link Product} object.
     */
    @Override
    public Product build() {
        return product;
    }

    /**
     * Placeholder method for an event ID, subject to implementation in concrete builders.
     *
     * @param aLong The event ID.
     * @return The updated {@code ProductConcreteBuilder} instance.
     */
    @Override
    public Object eventId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
