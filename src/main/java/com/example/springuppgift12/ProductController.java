package com.example.springuppgift12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;


@Controller
public class ProductController {

    public static Map<Integer, Product> products = new HashMap<>();

    // Konstruktor för att lägga till produkter i HashMap
    public ProductController(){
        products.put(1, new Product( "TV Samsung", 10000.0));
        products.put(2, new Product( "Laptop Dell", 15000.0));
        products.put(3, new Product( "Cat Bed",25000.0));
        products.put(4, new Product( "Dog Bed", 18000.0));

    }


    @GetMapping("/hello")
    public String sayHello (Model model){
        model.addAttribute("message", "Hello World");
                return "hello";
    }

    @GetMapping("/products")
    public String getAllProducts(Model model){
        model.addAttribute("productsMap", products);
        return "products";
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", products.get(id));
        return "product";
    }

}
