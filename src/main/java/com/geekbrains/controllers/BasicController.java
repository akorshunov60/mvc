package com.geekbrains.controllers;

import com.geekbrains.component.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class BasicController {

    Product product = new Product();

    @GetMapping
    public String main(Model model) {

        product.setId(1);
        product.setName("Молоко");
        product.setCost(3);

        model.addAttribute("product", product);
        return "products";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String productList(Model model) {

        product.setId(2);
        product.setName("Сметана");
        product.setCost(5);

        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/add")
    public String mvcPostRequest(Model model) {
        model.addAttribute("product", product);
        return "products";
    }
}
