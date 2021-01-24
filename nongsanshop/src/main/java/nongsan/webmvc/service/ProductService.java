package nongsan.webmvc.service;

import nongsan.webmvc.model.Product;

import java.util.ArrayList;

public interface ProductService {
    void insert(Product product);

    void edit(Product product);

    void delete(String id);

    Product get(int id);

    Product get(String name);

    ArrayList<Product> getAll();

    ArrayList<Product> getProductById(int id);

    ArrayList<Product> searchByName(String productName);

    ArrayList<Product> getProductByIdCate(int idCate);

    ArrayList<Product> getProduct(int a, int b);
    int getCount();
}
