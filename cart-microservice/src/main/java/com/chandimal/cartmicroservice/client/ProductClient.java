package com.chandimal.cartmicroservice.client;

import com.chandimal.cartmicroservice.dto.Product;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name=ProductClient.SERVICE_NAME, fallback= productClientFallback.class)
public interface ProductClient {
    String SERVICE_NAME = "product-microservice";
    @RequestMapping(value="/api/products", method= RequestMethod.GET)
    List<Product> getProducts();
}

class productClientFallback implements ProductClient {
    @Override
    public List<Product> getProducts() {
        return null;
    }
}