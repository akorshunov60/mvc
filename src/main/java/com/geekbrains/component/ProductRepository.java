package com.geekbrains.component;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicInteger count = new AtomicInteger(1);

    public void add(Product product) {
        products.add(product);
    }

    private List<Product> view() { return products; }

    public Product findById(int id) {
        return products.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public List<Product> findAll() {
        return products;
    }

    @PostConstruct
    public void init() {

        Product product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Молоко");
        product.setCost(3);
        products.add(product);

        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Сметана");
        product.setCost(5);
        products.add(product);

        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Хлеб");
        product.setCost(7);
        products.add(product);

        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Сыр");
        product.setCost(10);
        products.add(product);
    }
}
