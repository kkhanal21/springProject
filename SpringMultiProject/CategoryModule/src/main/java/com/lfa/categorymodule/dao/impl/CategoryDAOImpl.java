/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.categorymodule.dao.impl;

import com.lfa.categorymodule.dao.CategoryDAO;
import com.lfa.categorymodule.entity.Category;
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
@Repository(value = "categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_categories";
        return jdbcTemplate.query(sql, new CategoryMapper());
    }

    @Override
    public Category getById(int id) throws ClassNotFoundException, SQLException {
       String sql = "SELECT * FROM tbl_categories WHERE category_id=?";
        return jdbcTemplate.queryForObject(sql, new CategoryMapper());
    }

    @Override
    public int insert(Category c) throws ClassNotFoundException, SQLException {
       String sql = "INSERT INTO tbl_categories(category_name,status)VALUES(?,?)";
        return jdbcTemplate.update(sql,new Object[]{c.getName(),c.isStatus()});
    }

    @Override
    public int update(Category c) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbl_categories category_name,statu)VALUES(?,?)";
        return jdbcTemplate.update(sql,new Object[]{c.getName(),c.isStatus()});
    
    }

    @Override
    public int delete(Category t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("category_id"));
            category.setName(rs.getString("category_name"));
            category.setAddedDate(rs.getDate("added_date"));
            category.setStatus(rs.getBoolean("status"));
            return category;
        }

    }

}
