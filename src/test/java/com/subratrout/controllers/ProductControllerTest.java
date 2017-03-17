package com.subratrout.controllers;

import com.subratrout.domain.Product;
import com.subratrout.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by subratrout on 3/16/17.
 */
public class ProductControllerTest {

    @Mock //Mockito mock object
    private ProductService productService;

    @InjectMocks // setup controller and injects mock objects into it
    private ProductController productController;

    private MockMvc mockMvc;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this); // initializes controller and mocks

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testList() throws Exception {

        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        //specific Mockito interaction, tells stub to return list of products
        when(productService.listAll()).thenReturn((List) products);

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/list"))
                .andExpect(model().attribute("products", hasSize(2)));

    }

    @Test
    public void testShow() throws Exception{
        Integer id = 1;

        //Tell Mockito stub to return new product for ID 1
        when(productService.getById(id)).thenReturn(new Product());

        mockMvc.perform(get("/product/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/show"))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.instanceOf(Product.class)));
    }

    @Test
    public void tesEdit() throws Exception{
        Integer id = 1;

        //Tell Mockito stub to return new product for ID 1
        when(productService.getById(id)).thenReturn(new Product());

        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productform"))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.instanceOf(Product.class)));
    }

    @Test
    public void testNewProduct() throws Exception {
        Integer id = 1;

        //Should not call the service
        verifyZeroInteractions(productService);

        mockMvc.perform(get("/product/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("product/productform"))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.instanceOf(Product.class)));
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        Integer id = 1;
        String description = "Test Description";
        BigDecimal price = new BigDecimal("12.34");
        String imageUrl = "example.com";

        Product returnProduct = new Product();
        returnProduct.setId(id);
        returnProduct.setDescription(description);
        returnProduct.setPrice(price);
        returnProduct.setImageUrl(imageUrl);

        when(productService.saveOrUpdate(Matchers.<Product>any())).thenReturn(returnProduct);

        mockMvc.perform(post("/product")
        .param("id", "1")
        .param("description", description)
        .param("price", "12.34")
        .param("imageUrl", "example.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/show/1"))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.instanceOf(Product.class)))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.hasProperty("id", org.hamcrest.Matchers.is(id))))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.hasProperty("description", org.hamcrest.Matchers.is(description))))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.hasProperty("price", org.hamcrest.Matchers.is(price))))
                .andExpect(model().attribute("product", org.hamcrest.Matchers.hasProperty("imageUrl", org.hamcrest.Matchers.is(imageUrl))));

        //Verify properties of bound object
        ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
        verify(productService).saveOrUpdate(boundProduct.capture());

        assertEquals(id, boundProduct.getValue().getId());
        assertEquals(description, boundProduct.getValue().getDescription());
        assertEquals(price, boundProduct.getValue().getPrice());
        assertEquals(imageUrl, boundProduct.getValue().getImageUrl());
    }

}
