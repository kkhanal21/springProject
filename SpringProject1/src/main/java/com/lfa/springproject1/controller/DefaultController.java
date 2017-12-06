/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.springproject1.controller;

import com.lfa.springproject1.entity.Category;
import com.lfa.springproject1.service.CategoryService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            categoryService.insert(new Category(0, "Communications", true));
            model.addAttribute("categories", categoryService.getAll());
        } catch (ClassNotFoundException | SQLException se) {
            System.out.println(se.getMessage());
        }
        return "index";
    }
}
