/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.productmodule.dao.impl;

import com.lfa.brandmodule.entity.Brand;
import com.lfa.categorymodule.entity.Category;
import com.lfa.productmodule.dao.ProductDAO;
import com.lfa.productmodule.entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kamal
 */
@Repository(value = "productDAO")
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_products";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Product getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_products WHERE product_id=?";
        return jdbcTemplate.queryForObject(sql, new ProductMapper());
    }

    @Override
    public int insert(Product p) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_products(product_name,description,"
                + "category_id,brand_id,price,quantity,status)VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{p.getName(),
            p.getDescription(), p.getCategory().getId(), p.getBrand().getId(),
            p.getPrice(), p.getQuantity(), p.isStatus()});

    }

    @Override
    public int update(Product p) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_products product_name=?,description=?,"
                + "brand_id=?,category_id=?,price=?,quantity=?,status=? WHERE product_id=?";
        return jdbcTemplate.update(sql, new Object[]{p.getName(),
            p.getDescription(), p.getBrand().getId(),
            p.getCategory().getId(), p.getPrice(), p.getQuantity(), p.isStatus()});
    }

    @Override
    public int delete(Product p) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public List<Product> getProductDetaiList() throws ClassNotFoundException, SQLException {
        String sql = "SELECT p.*,c.category_name,b.brand_name "
                + "FROM tbl_products p join tbl_categories c on "
                + "p.category_id=c.category_id join tbl_brands b "
                + "on b.brand_id=p.brand_id";
        return jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                Category category = new Category(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                product.setCategory(category);
                Brand brand = new Brand(rs.getInt("brand_id"));
                brand.setName(rs.getString("brand_name"));
                product.setBrand(brand);
                product.setPrice(rs.getInt("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setStatus(rs.getBoolean("status"));
                return product;
            }
        });
    }

    private class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int i) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("product_id"));
            product.setName(rs.getString("product_name"));
            product.setDescription(rs.getString("description"));
            product.setCategory(new Category(rs.getInt(("category_id"))));
            product.setBrand(new Brand(rs.getInt(("brand_id"))));
            product.setPrice(rs.getInt("price"));
            product.setQuantity(rs.getInt("quantity"));
            product.setStatus(rs.getBoolean("status"));

            return product;
        }

    }

}
