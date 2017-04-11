package com.subratrout.converters;

import com.subratrout.commands.ProductForm;
import com.subratrout.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by subratrout on 4/11/17.
 */
@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {

    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setVersion(product.getVersion());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}
