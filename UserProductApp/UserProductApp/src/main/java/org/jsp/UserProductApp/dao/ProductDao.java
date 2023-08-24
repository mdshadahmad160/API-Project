package org.jsp.UserProductApp.dao;

import org.jsp.UserProductApp.dto.Product;
import org.jsp.UserProductApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
    public Optional<Product> findById(int id){
        return productRepository.findById(id);
    }
    public boolean deleteProduct(int id){
        Optional<Product> recProduct=findById(id);
        if (recProduct.isPresent()){
            productRepository.delete(recProduct.get());
            return true;
        }
        return false;
    }
    public List<Product> findProductsByUserId(int user_id){
        return productRepository.findProductsByUserId(user_id);
    }
}
