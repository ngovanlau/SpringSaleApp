package com.laau.reponsitory.impl;

import com.laau.hibernatedemo.HibernateUtils;
import com.laau.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class CategoryReponsityImpl {
    public List<Category> getCategories() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            Query query = s.createNamedQuery("Category.findAll");
            return query.getResultList();
        }
    }
    
    public Category getCategoryById(int id) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            return s.get(Category.class, id);
        }
    }
}
