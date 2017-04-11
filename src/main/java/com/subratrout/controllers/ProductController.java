package com.subratrout.controllers;

import com.subratrout.commands.ProductForm;
import com.subratrout.domain.Product;
import com.subratrout.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by subratrout on 2/27/17.
 */

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/product/list")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("productForm", productService.getById(id));
        return "product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new Product());
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productForm";
        }
        Product savedProduct = productService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/list";
    }

}
