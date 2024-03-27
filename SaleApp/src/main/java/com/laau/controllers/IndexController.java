/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laau.controllers;

import com.laau.services.CategoryService;
import com.laau.services.ProductService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("products", this.productService.getProducts(params));
        
        return "index";
    }
}
