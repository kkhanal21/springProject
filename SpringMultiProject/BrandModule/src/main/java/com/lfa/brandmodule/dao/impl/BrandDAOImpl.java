/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.brandmodule.dao.impl;

import com.lfa.brandmodule.dao.BrandDAO;
import com.lfa.brandmodule.entity.Brand;
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
@Repository(value = "brandDAO")
public class BrandDAOImpl implements BrandDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Brand> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_brands";
        return jdbcTemplate.query(sql, new BrandMapper());
    }

    @Override
    public Brand getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_brands WHERE brand_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BrandMapper());
    }

    @Override
    public int insert(Brand b) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_brands(brand_name,status) VALUES(?,?)";
        return jdbcTemplate.update(sql, new Object[]{b.getName(), b.isStatus()});
    }

    @Override
    public int update(Brand b) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_brands brand_name=?,status=? WHERE brand_id=?";
        return jdbcTemplate.update(sql, new Object[]{b.getName(), b.isStatus(), b.getId()});
    }

    @Override
    public int delete(Brand b) throws ClassNotFoundException, SQLException { //for soft delete from tb_brands
        String sql = "UPDATE INTO tbl_brands delete_flag=?,deleted_by=? WHERE brand_id=?";
        return jdbcTemplate.update(sql, new Object[]{b.isFlag(), b.getDeleteBy(), b.getId()});

    }

    private class BrandMapper implements RowMapper<Brand> {

        @Override
        public Brand mapRow(ResultSet rs, int i) throws SQLException {
            Brand brand = new Brand();
            brand.setId(rs.getInt("brand_id"));
            brand.setName(rs.getString("brand_name"));
            brand.setAddedDate(rs.getDate("added_date"));
            brand.setStatus(rs.getBoolean("status"));
            return brand;
        }

    }

}
