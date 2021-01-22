package nongsan.webmvc.dao;

import nongsan.webmvc.model.Product;

import java.util.ArrayList;

public interface ProductDao {
    void insert(Product product);

    void edit(Product product);

    void delete(String id);

    Product get(int id);

    Product get(String name);

   ArrayList<Product> getProduct(int a, int b);/*giới hạn số lượng sản phẩm*/
    int getCount();/*đếm số lượng sản phẩm*/

    ArrayList<Product> getAll();

    ArrayList<Product> getProductById(int id);

    ArrayList<Product> searchByName(String productName);
}
