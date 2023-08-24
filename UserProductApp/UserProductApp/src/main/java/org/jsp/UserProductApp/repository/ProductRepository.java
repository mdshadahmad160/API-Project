package org.jsp.UserProductApp.repository;

import org.jsp.UserProductApp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
    @Query("select p from Product p where p.user=?1")
    List<Product> findProductsByUserId(int user_id) ;


}