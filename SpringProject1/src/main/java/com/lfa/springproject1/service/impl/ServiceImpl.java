/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.springproject1.service.impl;

import com.lfa.springproject1.cache.CategoryCache;
import com.lfa.springproject1.dao.CategoryDAO;
import com.lfa.springproject1.entity.Category;
import com.lfa.springproject1.service.CategoryService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kamal
 */
@Service(value = "categoryService")
public class ServiceImpl implements CategoryService {
    
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    CategoryCache categoryCache;
    
    @Override
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
        if (categoryCache.getCategoryList() == null) {
            categoryCache.setCategoryList(categoryDAO.getAll());
        }
        return categoryCache.getCategoryList();
    }
    
    @Override
    public Category getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int insert(Category c) throws ClassNotFoundException, SQLException {
        categoryCache.setCategoryList(null);
        return categoryDAO.insert(c);
    }
    
}
