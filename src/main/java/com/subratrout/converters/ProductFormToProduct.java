package com.subratrout.converters;

import com.subratrout.commands.ProductForm;
import com.subratrout.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by subratrout on 4/11/17.
 */
@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        product.setId(productForm.getId());
        product.setVersion(productForm.getVersion());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setImageUrl(productForm.getImageUrl());
        return product;
    }
}