package org.jsp.UserProductApp.controller;

import java.util.List;


import org.jsp.UserProductApp.dao.ResponseStructure;
import org.jsp.UserProductApp.dto.Product;
import org.jsp.UserProductApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/products/{user_id}")
    public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product, @PathVariable int user_id){
        return service.saveProduct(product, user_id);
    }
    @PutMapping("/products/{user_id}")
    public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@PathVariable int user_id){
        return service.updateProduct(product, user_id);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable int id){
        return service.findById(id);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    @GetMapping("/products/byuser-id/{id}")
    public ResponseEntity<ResponseStructure<List<Product>>> findProductsByUserId(@PathVariable int id){
        return service.findProductsByUserId(id);
    }



}
