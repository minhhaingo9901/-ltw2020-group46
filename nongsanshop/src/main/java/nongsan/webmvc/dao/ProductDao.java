package nongsan.webmvc.dao;

import nongsan.webmvc.model.Product;

import java.util.ArrayList;

public interface ProductDao {
    void insert(Product product);

    void edit(Product product);

    void delete(String id);

    Product get(int id);

    Product get(String name);

    ArrayList<Product>getListByPage(ArrayList<Product> arr, int start, int end);

    ArrayList<Product> getAll();

    ArrayList<Product> getProductById(int id);

    ArrayList<Product> searchByName(String productName);
}
