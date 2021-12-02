package org.springframework.samples.petclinic.product;

import java.util.ArrayList;
import java.util.List;

public class ProductsJSON {
    private List<Product> products;

    public List<Product> getProductList() {
        if(products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
}
