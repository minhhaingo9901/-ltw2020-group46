package nongsan.webmvc.dao.impl;

import nongsan.webmvc.dao.ProductDao;
import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoImpl extends connectDB implements ProductDao {

	@Override
	public void insert(Product product) {
		String sql = "INSERT INTO product(catalog_id, name, price,qty, status, description, content, discount, image_link, created) VALUES (?, ?, ?,?, ?, ?, ?, ?, ?, ?)";
		new connectDB();
		Connection con = getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getCatalog_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getPrice());
			ps.setInt(4,product.getQty());
			ps.setString(5, product.getStatus());
			ps.setString(6, product.getDescription());
			ps.setString(7, product.getContent());
			ps.setString(8, product.getDiscount());
			ps.setString(9, product.getImage_link());
			ps.setString(10, product.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Product product) {
		String sql = "UPDATE product SET name = ?, catalog_id = ?, price = ?, qty=?, status = ?, description = ?, content = ?, discount = ?, image_link = ?, created = ? WHERE id = ?";
		new connectDB();
		Connection con = getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getCatalog_id());
			ps.setString(3, product.getPrice());
			ps.setInt(4, product.getQty());
			ps.setString(5, product.getStatus());
			ps.setString(6, product.getDescription());
			ps.setString(7, product.getContent());
			ps.setString(8, product.getDiscount());
			ps.setString(9, product.getImage_link());
			ps.setString(10, product.getCreated());
			ps.setString(11, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM product WHERE id = ?";
		new connectDB();
		Connection conn = getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product get(int id) {
		Connection con = connectDB.getConnect();
		String sql = "SELECT * FROM product WHERE id = ? ";
		/*new connectDB();
		Connection con = getConnect();*/
		Product product = new Product();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				/*Product product = new Product();*/
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQty(rs.getInt("qty"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				/*return product;*/

			}
			con.close();
			ps.close();
			rs.close();

		} catch (SQLException e) {
			Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();

		}
		return product;
	}

	@Override
	public Product get(String name) {
		return null;
	}

	@Override
	public ArrayList<Product> getAll() {
		Connection conn = connectDB.getConnect();
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product";
		/*Connection conn = getConnect();*/

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQty(rs.getInt("qty"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);
			}
			conn.close();
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public ArrayList<Product> getProductById(int id) {
		Connection conn = connectDB.getConnect();
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE catalog_id=?";
		/*Connection conn = getConnect();*/
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQty(rs.getInt("qty"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				products.add(product);
			}
			conn.close();
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	

	@Override
	public ArrayList<Product> searchByName(String keyword) {
		Connection conn = connectDB.getConnect();
		ArrayList<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE name LIKE ? ";
		/*Connection conn = getConnect();*/

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQty(rs.getInt("qty"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				productList.add(product);
			}
			conn.close();
			ps.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	@Override
	public ArrayList<Product> getProduct(int a, int b) {
		Connection conn = connectDB.getConnect();
		ArrayList<Product> list = new ArrayList();
		String sql = "SELECT * FROM product Limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setInt(2, b);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setQty(rs.getInt("qty"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCount() {/*tổng số lượng sản phẩm*/
		Connection conn = connectDB.getConnect();
		ArrayList<Product> list = new ArrayList();
		String sql = "SELECT count(id) FROM product";
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
