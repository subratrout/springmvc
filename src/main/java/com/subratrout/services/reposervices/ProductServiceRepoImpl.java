package com.subratrout.services.reposervices;

import com.subratrout.commands.ProductForm;
import com.subratrout.converters.ProductFormToProduct;
import com.subratrout.domain.Product;
import com.subratrout.repositories.ProductRepository;
import com.subratrout.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subratrout on 4/7/17.
 */
@Service
@Profile({"springdatajpa", "jpadao"})
public class ProductServiceRepoImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<?> listAll(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(Integer id){
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject){
        return productRepository.save(domainObject);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }

    @Override
    public void delete(Integer id){
        productRepository.delete(id);
    }

}
