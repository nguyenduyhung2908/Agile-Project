/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.service;

import java.util.List;
import javaapplication11.model.Categories;
import javaapplication11.repository.CategoryRepository;

/**
 *
 * @author Nguyen Duy Hung
 */
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }
   public List<Categories> getAllCategories(){
       return this.categoryRepository.getAllCategories();
   } 
}  
