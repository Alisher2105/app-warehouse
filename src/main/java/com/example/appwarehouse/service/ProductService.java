package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Attachment;
import com.example.appwarehouse.entity.Category;
import com.example.appwarehouse.entity.Measurement;
import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.payload.ProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.AttachmentRepository;
import com.example.appwarehouse.repository.CategoryRepository;
import com.example.appwarehouse.repository.MeasurementRepository;
import com.example.appwarehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MeasurementRepository measurementRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    public Result addProduct(ProductDto productDto){

        boolean b = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (b)
            return new Result("Bunday nomli product ushbu categoriyada mavjud",false);
            // Categoriyani tekshirish
            Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
            if (!optionalCategory.isPresent())
                return new Result("Bynday categoriya mavjud emas",false);
        // Measurementni tekshirish
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Bunday o`lchov birligi mavjud emas",false);
        // Attachmentni tekshirish
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("Bunday rasm yo`q",false);
        // Mahsulotni saqlash
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1");// todo generatsiya qilish kerak
        product.setCategory(optionalCategory.get());
        product.setMeasurement(optionalMeasurement.get());
        product.setPhoto(optionalAttachment.get());
        productRepository.save(product);
        return new Result("Mahsulot saqlandi",true,product.getId());
    }

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id){
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }
}
