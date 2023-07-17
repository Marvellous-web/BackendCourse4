package com.stackroute.example.controller;

import com.stackroute.example.domain.CommonUser;
import com.stackroute.example.domain.UserProduct;
import com.stackroute.example.exception.ProductAlreadyExistException;
import com.stackroute.example.exception.ProductNotFoundException;
import com.stackroute.example.service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

@RestController
@RequestMapping("/productapp/v1/")
public class ProductController {
    @Autowired
    Product_Service product_service;
    //http://localhost:8080/productapp/v1/product
    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts()
    {
        return new ResponseEntity<>(product_service.getAllProducts(), HttpStatus.OK);
    }
    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestBody UserProduct product) throws ProductAlreadyExistException
    {
        try
     {
         return new ResponseEntity<>(product_service.addProduct(product),HttpStatus.OK);
     }
     catch (ProductAlreadyExistException productAlreadyExistException)
     {
         throw new ProductAlreadyExistException();
     }
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody UserProduct product)
    {
        return new ResponseEntity<>(product_service.updateProduct(product),HttpStatus.OK);
    }
    @DeleteMapping("/product/id")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) throws ProductNotFoundException
    {
        try
        {
            product_service.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        catch (ProductNotFoundException productNotFoundException)
        {
            throw new ProductNotFoundException();
        }
    }

    @GetMapping("/get-product-by-stock")
    public ResponseEntity<?> getProductByStock()
    {
        return new ResponseEntity<>(product_service.getProductByStock(),HttpStatus.OK);
    }

    @PostMapping("add-product1")
    public ResponseEntity<?> addProduct1(@RequestBody CommonUser commonUser)
    {
        return new ResponseEntity<>(product_service.addProduct1(commonUser), HttpStatus.OK);
    }

    @GetMapping("/get-product-by-email/{email}")

    public ResponseEntity<?> getProductByEmail(@PathVariable String email) throws ProductNotFoundException {
        try {
            return new ResponseEntity<>(product_service.getProductbyEmail(email), HttpStatus.OK);
        } catch (ProductNotFoundException productNotFoundException) {
            throw productNotFoundException;
        }
    }

}
