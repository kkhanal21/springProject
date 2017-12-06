/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.productmodule.dao;

import com.lfa.coremodule.dao.GenericDAO;
import com.lfa.productmodule.entity.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kamal
 */
public interface ProductDAO extends GenericDAO<Product> {

    List<Product> getProductDetaiList() throws ClassNotFoundException, SQLException;
}
