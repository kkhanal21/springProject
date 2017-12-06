/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.formmodule.entity;

/**
 *
 * @author kamal
 */
public class Field {

    private int id;
    private String field;

    public Field() {
    }

    public Field(int id) {
        this.id = id;
    }

    public Field(int id, String field) {
        this.id = id;
        this.field = field;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
