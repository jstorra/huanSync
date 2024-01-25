/**
 * Enumeration representing different types of products in the HuanSync application.
 * Each type is associated with a specific name, and this enum provides a convenient way
 * to categorize products based on their types.
 * <p>
 * Usage example: {@code TypeProductEnum.MANGA.getName()}
 * </p>
 * <p>
 * The available types include:
 * <ul>
 *   <li>MANGA</li>
 *   <li>MULTIMEDIA</li>
 *   <li>ART</li>
 *   <li>FIGURES</li>
 *   <li>SOUVENIRS</li>
 *   <li>CLOTHING</li>
 *   <li>TECHNOLOGY</li>
 * </ul>
 * </p>
 * <p>
 * Each enum constant is associated with a specific name that can be retrieved using the
 * {@code getName()} method. Additionally, the name can be set using the {@code setName()} method.
 * </p>
 * <p>
 * Example:
 * </p>
 * <pre>{@code
 * TypeProductEnum.MANGA.getName(); // Returns "manga"
 * TypeProductEnum.MANGA.setName("newManga"); // Sets the name of the MANGA type to "newManga"
 * }</pre>
 * <p>
 * The {@code TypeProductEnum} enum provides a structured way to manage and represent
 * different types of products in the HuanSync application.
 * </p>
 *
 * @author Kevin Jimenez and sneiderEsteban
 */
package com.u2team.huansync.establishment.store.product.model.classes;

/**
 * Enumeration representing different types of products in the HuanSync application.
 * Each type is associated with a specific name, and this enum provides a convenient way
 * to categorize products based on their types.
 */
public enum TypeProductEnum {

    /**
     * Represents the type of product - MANGA.
     */
    MANGA("manga"),

    /**
     * Represents the type of product - MULTIMEDIA.
     */
    MULTIMEDIA("multimedia"),

    /**
     * Represents the type of product - ART.
     */
    ART("art"),

    /**
     * Represents the type of product - FIGURES.
     */
    FIGURES("figures"),

    /**
     * Represents the type of product - SOUVENIRS.
     */
    SOUVENIRS("souvenirs"),

    /**
     * Represents the type of product - CLOTHING.
     */
    CLOTHING("clothing"),

    /**
     * Represents the type of product - TECHNOLOGY.
     */
    TECHNOLOGY("technology");

    private String name;

    /**
     * Constructs a new TypeProductEnum with the specified name.
     *
     * @param name The name associated with the product type.
     */
    private TypeProductEnum(String name) {
        this.name = name;
    }

    /**
     * Gets the name associated with the product type.
     *
     * @return The name of the product type.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name associated with the product type.
     *
     * @param name The new name for the product type.
     */
    public void setName(String name) {
        this.name = name;
    }
}
