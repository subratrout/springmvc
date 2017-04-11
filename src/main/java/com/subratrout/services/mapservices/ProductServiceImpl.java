package com.subratrout.services.mapservices;

import com.subratrout.commands.ProductForm;
import com.subratrout.converters.ProductFormToProduct;
import com.subratrout.domain.DomainObject;
import com.subratrout.domain.Product;
import com.subratrout.services.ProductService;
import com.subratrout.services.mapservices.AbstractMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.*;

/**
 * Created by subratrout on 2/27/17.
 */
@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    private ProductFormToProduct productFormToProduct;

    @Autowired
    public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {

    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }

}
