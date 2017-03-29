//package com.subratrout.services;
//
//import com.subratrout.config.JpaIntegrationConfig;
//import com.subratrout.domain.Product;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * Created by subratrout on 3/24/17.
// */
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration
//@SpringBootApplication
//@ActiveProfiles("jpadao")
//public class ProductServicejapDaoImplTest {
//
//    private ProductService productService;
//
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
//
//    public void testListMethod(){
//
//        List<Product> products = (List<Product>) productService.listAll();
//
//        assert products.size() == 5;
//    }
//}
