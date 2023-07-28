package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Category;
import com.example.appwarehouse.payload.CategoryDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalParentCategory.isPresent()){
                return new Result("Bunday ota category mavjud emas",false);
            }category.setParentCategory(optionalParentCategory.get());
        }
        Category save = categoryRepository.save(category);
        return new Result("Category muvaffaqiyatli saqlandi",true,category.getId());
    }

    public List<Category> getCategory(){
        List<Category> all = categoryRepository.findAll();
        return all;
    }

    public Category getCategoryById(Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            return category;
        }return null;
    }

    public Result deleteCategoryById(Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()){
            categoryRepository.deleteById(id);
            return new Result("Category o`chirildi",true);
        }return new Result("Bunday category mavjud emas",false);
    }

    public Result editCategoryById(Integer id,CategoryDto categoryDto){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()){
            Category category = byId.get();
            category.setName(categoryDto.getName());
            categoryRepository.save(category);
            return new Result("Category muvaffaqiyatli o`zgartirildi",true);
        }
        return new Result("Bynday Category mavjud emas",false);
    }
}
