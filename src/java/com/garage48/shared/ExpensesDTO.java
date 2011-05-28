/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.garage48.shared;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class ExpensesDTO implements Serializable {

    private Long id;

    private String item;
    private String description;
    private Double price;
    private String address;

    public ExpensesDTO() {
    }

    public ExpensesDTO(Long id, String item, String description, Double price, String address) {
        this.id = id;
        this.item = item;
        this.description = description;
        this.price = price;
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
