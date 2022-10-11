package com.chandimal.cartmicroservice.controller;

import com.chandimal.cartmicroservice.client.ProductClient;
import com.chandimal.cartmicroservice.dto.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

  private final ProductClient productClient;

  public CartController(ProductClient productClient) {
    this.productClient = productClient;
  }

  @GetMapping("/product/{productId}")
  public Product getProductById(@PathVariable("productId") int productId){
    List<Product> productList =productClient.getProducts();
    if(productList!=null){
      return productList.stream().filter(product -> product.getId() == productId).findAny().orElse(null);
    }
    return null;
  }

}
