/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.productSell;

import org.springframework.samples.petclinic.product.FileStorageService;
import org.springframework.samples.petclinic.product.Product;
import org.springframework.samples.petclinic.product.ProductRepository;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

/**
 *
 * @author marri
 */
@Controller
public class productSellController {

    private final ProductRepository productRepository;
    @Autowired
    private FileStorageService fileStorageService;
    private static final String VIEW_PRODUCTO_HOME = "productSell/productSell";

    public productSellController(ProductRepository product) {
        this.productRepository = product;
    }

    @GetMapping("/productSell")
    public String initFindForm(Map<String, Object> model) {
        Collection<Product> allProducts = this.productRepository.getAllProducts();
        model.put("allProducts", allProducts);
        return VIEW_PRODUCTO_HOME;
    }
}
