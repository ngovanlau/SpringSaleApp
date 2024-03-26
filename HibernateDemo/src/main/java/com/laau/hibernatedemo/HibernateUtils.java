/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laau.hibernatedemo;

import com.laau.pojo.Category;
import com.laau.pojo.Comment;
import com.laau.pojo.OrderDetail;
import com.laau.pojo.ProdTag;
import com.laau.pojo.Product;
import com.laau.pojo.SaleOrder;
import com.laau.pojo.Tag;
import com.laau.pojo.User;
import java.util.Properties;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ngovanlau
 */
public class HibernateUtils {

    @Getter
    private static final SessionFactory factory;

    static {
        Configuration conf = new Configuration();

        Properties props = new Properties();
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "Admin@123");
        props.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(OrderDetail.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        factory = conf.buildSessionFactory(registry);
    }

}
