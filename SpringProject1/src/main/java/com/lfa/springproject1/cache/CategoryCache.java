/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.springproject1.cache;

import com.lfa.springproject1.entity.Category;
import java.util.List;

/**
 *
 * @author kamal
 */
public class CategoryCache {

    private List<Category> categoryList;

    public CategoryCache() {
    }

    public CategoryCache(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

}
