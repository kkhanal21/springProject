/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.webmodule.controller;

import com.lfa.productmodule.dao.ProductDAO;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kamal
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("products", productDAO.getProductDetaiList());
        } catch (ClassNotFoundException | SQLException se) {
            System.out.println(se.getMessage());
        }
        return "index";
    }
}
