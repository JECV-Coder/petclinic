package org.springframework.samples.petclinic.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private final ProductRepository products;

    public ProductController(ProductRepository products) {
        this.products = products;
    }

    @GetMapping({"/API/productsJSON"})
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody ProductsJSON showResourceProductListJSON() {
        ProductsJSON products = new ProductsJSON();

        products.getProductList().addAll(this.products.findAll());
        return products;
    }

    @GetMapping({"API/productsJSON/{productId}"})
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody Product showResourcesProductJSON(@PathVariable("productId") int productId) {
        Product product = this.products.findById(productId);
        return product;
    }

    @PostMapping(value = { "/API/create-product/"  },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public Product createProduct(@RequestBody Product product) {
        this.products.save(product);
        return product;
    }

    @PutMapping(value = {"/API/update-product/"},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public Product updateProduct(@RequestBody Product product) {
        Product aux = products.findById(product.getId());
        aux.setDescription(product.getDescription());
        aux.setExistence(product.getExistence());
        aux.setName(product.getName());
        aux.setPhoto(product.getName());
        aux.setPrice(product.getPrice());
        this.products.save(aux);
        return aux;
    }

    @DeleteMapping(value = "/API/delete-product/",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    public void deleteProduct(@RequestBody Product product) {
        this.products.delete(product);
    }
}
