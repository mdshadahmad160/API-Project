package org.jsp.UserProductApp.service;

import org.jsp.UserProductApp.dao.ProductDao;
import org.jsp.UserProductApp.dao.ResponseStructure;
import org.jsp.UserProductApp.dao.UserDao;
import org.jsp.UserProductApp.dto.Product;

import org.jsp.UserProductApp.dto.User;
import org.jsp.UserProductApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;
    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int user_id){
        Optional<User> recUser=userDao.findById(user_id);
        ResponseStructure<Product> structure=new ResponseStructure<>();
        if (recUser.isPresent()){
            User user=recUser.get();
            user.getProducts().add(product);
            product.setUser(recUser.get());
            productDao.saveProduct(product);
            structure.setData(product);
            structure.setMessage("Product Added Successfully: ");
            structure.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
        }
        throw new IdNotFoundException();
    }
    public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int user_id){
        Optional<User> recUser=userDao.findById(user_id);
        ResponseStructure<Product> structure=new ResponseStructure<>();
        if (recUser.isPresent()){
            product.setUser(recUser.get());
            productDao.updateProduct(product);
            structure.setData(product);
            structure.setMessage("Product Updated Successfully: ");
            structure.setStatusCode(HttpStatus.CREATED.value());
            return  new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
        }
        throw new IdNotFoundException();
    }
    public ResponseEntity<ResponseStructure<Product>> findById(int id){
        ResponseStructure<Product> structure=new ResponseStructure<>();
        Optional<Product> recProduct=productDao.findById(id);
        if (recProduct.isPresent()){
            structure.setData(recProduct.get());
            structure.setMessage("Product Found: ");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
        }
        throw new IdNotFoundException();
    }
    public ResponseEntity<ResponseStructure<String>> deleteProduct(int id){
        ResponseStructure<String> structure=new ResponseStructure<>();
        Optional<Product> recProduct=productDao.findById(id);
        if (recProduct.isPresent()){
            productDao.deleteProduct(id);
            structure.setData("Product Deleted: ");
            structure.setMessage("Product Found: ");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
        }
       throw new IdNotFoundException();
    }
    public ResponseEntity<ResponseStructure<List<Product>>> findProductsByUserId(int user_id){
        ResponseStructure<List<Product>> structure=new ResponseStructure<>();
        structure.setData(productDao.findProductsByUserId(user_id));
        structure.setMessage("Product Found With User Id: ");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
    }
}
