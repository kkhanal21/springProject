/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.springproject1.service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kamal
 */
public interface GenericService <T> {

    List<T> getAll() throws ClassNotFoundException, SQLException;

    T getById(int id) throws ClassNotFoundException, SQLException;

    int insert(T t) throws ClassNotFoundException, SQLException;
}
