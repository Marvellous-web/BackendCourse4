package com.stackroute.example.service;


import com.stackroute.example.domain.CommonUser;
import com.stackroute.example.domain.ProductDetails;
import com.stackroute.example.domain.UserDTO;
import com.stackroute.example.domain.UserProduct;
import com.stackroute.example.exception.ProductAlreadyExistException;
import com.stackroute.example.exception.ProductNotFoundException;
import com.stackroute.example.proxy.UserProxy;
import com.stackroute.example.repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ProductServiceImpl implements Product_Service{
    @Autowired
    private Product_Repository product_repository;
    @Autowired
    private UserProxy userProxy;
    @Override
    public List<UserProduct> getAllProducts() {
        return product_repository.findAll();
    }

    @Override
    public UserProduct addProduct(UserProduct product) throws ProductAlreadyExistException,NullPointerException {

        if(product_repository.findById(product.getEmail()).isPresent())
        {
            throw new ProductAlreadyExistException();

        }

        else
            product.setProductDetails(new ArrayList<ProductDetails>());
            return product_repository.insert(product);

    }

    @Override
    public UserProduct updateProduct(UserProduct product) {
        return product_repository.save(product);
    }

    @Override
    public void deleteProduct(String id) throws ProductNotFoundException {
        if(product_repository.findById(id).isPresent())
        {
            product_repository.deleteById(id);
        }
        else
        {
            throw new ProductNotFoundException();
        }
    }

    @Override
    public List<UserProduct> getProductByStock()  {
        return product_repository.getProductByStock();
    }

    @Override
    public UserProduct getProductbyEmail(String email) throws ProductNotFoundException {
        if (product_repository.findById(email).isPresent())
        {

            return product_repository.findById(email).get();
        }
        else {
           throw new ProductNotFoundException();
        }
    }

    @Override
    public UserProduct addProduct1(CommonUser commonUser)  {
        UserDTO userDTO=new UserDTO();
        userDTO.setEmail(commonUser.getEmail());
        userDTO.setPassword(commonUser.getPassword());
        ResponseEntity<?> response=userProxy.sendUserObjectToAuthApp(userDTO);
        System.out.println(response);
        UserProduct userProduct=new UserProduct(commonUser.getEmail(),commonUser.getMob_num(),new ArrayList());
        return product_repository.insert(userProduct);
    }
}
