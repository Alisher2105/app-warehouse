package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Category;
import com.example.appwarehouse.entity.Measurement;
import com.example.appwarehouse.payload.CategoryDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.CategoryService;
import com.example.appwarehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }

    @GetMapping
    public List<Category> getCategory(){
        return categoryService.getCategory();
    }

    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("{id}")
    public Result deleteCategoryById(@PathVariable Integer id){
        return categoryService.deleteCategoryById(id);
    }

    @PutMapping("{id}")
    public Result editCategoryById(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
      return categoryService.editCategoryById(id,categoryDto);

    }



}
