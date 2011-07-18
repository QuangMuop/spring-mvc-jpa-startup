package com.springjpa.service;

import com.springjpa.domain.Product;

import java.util.List;

/**
 * ProductService is the Service that offers an interface for operations
 * related to the person functionality.
 * <p/>
 *
 * @author Ceren Akkan
 */
public interface ProductService {
    /**
     * New product is created with the provided product data.
     *
     * @param product the product object to be created
     * @return the created product
     */
    Product create(Product product);

    /**
     * Return the content for the provided id.
     *
     * @param personId
     * @return the existing content
     */
    Product get(Long personId);

    /**
     * Return the list of person.
     *
     * @return list of {@link com.springjpa.domain.Product}
     */
    List<Product> get();

    /**
     * Deletes an existing {@link com.springjpa.domain.Product} object.
     *
     * @param personId ID of the person to delete
     */
    void delete(Long personId);

    /**
     * Updates an existing {@link com.springjpa.domain.Product} object.
     *
     * @param product the product to be updated
     * @return the updated product
     */
    Product update(Product product);

}
