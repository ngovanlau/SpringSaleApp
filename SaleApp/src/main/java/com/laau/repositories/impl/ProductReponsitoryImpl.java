/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laau.repositories.impl;

import com.laau.pojo.Product;
import com.laau.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class ProductReponsitoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root<Product> r = q.from(Product.class);
        q.select(r);

        if (params != null && !params.isEmpty()) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");

            if (kw != null) {
                predicates.add(b.like(r.get("name"), String.format("%%%s%%", kw)));
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null) {
                predicates.add(b.greaterThanOrEqualTo(r.get("price"), Double.parseDouble(fromPrice)));
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null) {
                predicates.add(b.lessThanOrEqualTo(r.get("price"), Double.parseDouble(toPrice)));
            }

            String cateId = params.get("cateId");
            if (cateId != null) {
                predicates.add(b.equal(r.get("category"), Integer.parseInt(cateId)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);
        List<Product> products = query.getResultList();

        return products;
    }

    public void addOrUpdate(Product product) {
        Session s = this.factory.getObject().getCurrentSession();
        s.saveOrUpdate(product);
    }
}
