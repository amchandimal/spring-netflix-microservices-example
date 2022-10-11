package com.chandimal.productmicroservice.service;

import com.chandimal.productmicroservice.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  List<Product> productList = new ArrayList<>();
  @PostConstruct
  void populateProducts(){
    productList.add(new Product(1,"Apple"));
    productList.add(new Product(2,"Oranges"));
  }

  public List<Product> getAllProducts(){
    return productList;
  }

}
