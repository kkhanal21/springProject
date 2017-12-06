/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.brandmodule.entity;

import java.util.Date;

/**
 *
 * @author kamal
 */
public class Brand {

    private int id;
    private String name;
    private Date addedDate;
    private boolean status, flag;
    private int deleteBy;
    private Date deleteDate;

    public Brand() {
    }

    public Brand(int id) {
        this.id = id;
    }

    public Brand(int id, String name, Date addedDate, boolean status, boolean flag, int deleteBy) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.flag = flag;
        this.deleteBy = deleteBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(int deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

}
