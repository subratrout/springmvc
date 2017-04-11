package com.subratrout.services.jpaservices;

import com.subratrout.commands.ProductForm;
import com.subratrout.converters.ProductFormToProduct;
import com.subratrout.converters.ProductToProductForm;
import com.subratrout.domain.Product;
import com.subratrout.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by subratrout on 3/23/17.
 */
@Service
@Profile("jpadao")
public class ProductServicejapDaoImpl extends AbstractJpaDaoService implements ProductService {

    private ProductToProductForm productToProductForm;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductFormToProduct(ProductFormToProduct productFormToProduct) {
        this.productFormToProduct = productFormToProduct;
    }

    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();

        return savedProduct;
    }

//    @Override
//    public ProductForm saveOrUpdate(ProductForm productForm){
//        if(productForm.getId() != null){
//            Product productTopUpdate = this.getById(productForm.getId());
//
//            productTopUpdate.setVersion(productForm.getVersion());
//            productTopUpdate.setDescription(productForm.getDescription());
//            productTopUpdate.setPrice(productForm.getPrice());
//            productTopUpdate.setImageUrl(productForm.getImageUrl());
//
//            return productToProductForm.convert(this.saveOrUpdate(productTopUpdate));
//        } else {
//            return productToProductForm.convert(this.saveOrUpdate(productFormToProduct.convert(productForm)));
//        }
//    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        return saveOrUpdate(productFormToProduct.convert(productForm));
    }

    @Override
    public void delete(Integer id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }
}
