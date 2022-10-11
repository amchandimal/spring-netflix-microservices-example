package com.chandimal.productmicroservice.controller;

import com.chandimal.productmicroservice.model.Product;
import com.chandimal.productmicroservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  public List<Product> getAllProducts(){
    return productService.getAllProducts();
  }

}
