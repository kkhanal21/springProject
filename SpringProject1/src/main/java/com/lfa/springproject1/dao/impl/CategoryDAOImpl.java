/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.springproject1.dao.impl;

import com.lfa.springproject1.dao.CategoryDAO;
import com.lfa.springproject1.entity.Category;
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
        String sql = "select * from tbl_categories";
        jdbcTemplate.query(sql, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                Category category = new Category();
                category.setId(rs.getInt("category_id"));
                category.setName(rs.getString("category_name"));
                category.setAddedDate(rs.getDate("added_date"));
                category.setStatus(rs.getBoolean("status"));
                return category;
            }

        });
        return null;
    }

    @Override
    public Category getById(int id) throws ClassNotFoundException, SQLException {
        return new Category(1, "Hello", true);
    }

    @Override
    public int insert(Category c) throws ClassNotFoundException, SQLException {
        String sql = "insert into tbl_categories(category_name,status)values (?,?)";
        return jdbcTemplate.update(sql, new Object[]{
            c.getName(), c.isStatus()
        });
    }

}
