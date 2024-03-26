/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.laau.hibernatedemo;

import com.laau.pojo.Product;
import com.laau.reponsitory.impl.CategoryReponsityImpl;
import com.laau.reponsitory.impl.ProductReponsitoryImpl;
import com.laau.reponsitory.impl.StatsRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ngovanlau
 */
public class HibernateDemo {

    public static void main(String[] args) {

//        CategoryReponsityImpl ser = new CategoryReponsityImpl();
//        ser.getCategories().forEach(c -> System.out.println(c.getName()));
//
//        ProductReponsitoryImpl s = new ProductReponsitoryImpl();
//        Product product = new Product();
//        product.setName("ABC");
//        product.setPrice(12000000l);
//        product.setActive(true);
//        product.setCategoryId(ser.getCategoryById(1));
//
//        s.addOrUpdate(product);
        
//        Map<String, String> params = new HashMap<>();
////        params.put("fromPrice", "18000000");
////        params.put("toPrice", "21000000");
//        params.put("cateId", "1");
//        
//        s.getProducts(null).forEach(p -> System.out.printf("%d - %s - %d - %s\n"
//                , p.getId(), p.getName(), p.getPrice(), p.getCategoryId().getName()));

        StatsRepositoryImpl s = new StatsRepositoryImpl();
        s.statsRevenueByPeriod(2020, "QUARTER").forEach(ss -> System.out.printf("%d - %d\n", ss[0], ss[1]));
    }
}
