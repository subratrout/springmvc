package com.subratrout.services;

import com.subratrout.commands.ProductForm;
import com.subratrout.domain.Product;

import java.util.List;

/**
 * Created by subratrout on 2/27/17.
 */
public interface ProductService extends CRUDService<Product> {
    Product saveOrUpdateProductForm(ProductForm productForm);

}
