package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Input;
import com.example.appwarehouse.entity.InputProduct;
import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.payload.InputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.InputProductRepository;
import com.example.appwarehouse.repository.InputRepository;
import com.example.appwarehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {

    @Autowired
    InputProductRepository inputProductRepository;

    @Autowired
    InputRepository inputRepository;

    @Autowired
    ProductRepository productRepository;


    public Result addInputProduct(InputProductDto inputProductDto) {

        Optional<Product> optionalInputProduct = productRepository.findById(inputProductDto.getProductId());
        if (optionalInputProduct.isEmpty())
            return new Result(" Bunday Id li product yo`q",false);

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (optionalInput.isEmpty())
            return new Result("Bunday Id li maxsulot yo`q",false);

        InputProduct inputProduct = new InputProduct();
        inputProduct.setProduct(optionalInputProduct.get());
        inputProduct.setInput(optionalInput.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());
        inputProductRepository.save(inputProduct);
        return new Result("Input Product saqlandi",true,inputProduct.getId());
    }

    public  List<InputProduct> getInputProduct() {
        return inputProductRepository.findAll();
    }


    public InputProduct getInputProductById(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        return optionalInputProduct.orElse(null);
    }

    public Result editInputProductById(Integer id, InputProductDto inputProductDto) {

        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isEmpty())
            return new Result("Bunday Id li InputProduct Mavjud emas",false);

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (optionalProduct.isEmpty())
            return new Result("Bunday Id li product Mavjud emas",false);

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (optionalInput.isEmpty())
            return new Result("Bunday Id li kirim yo`q",false);

        InputProduct inputProduct = optionalInputProduct.get();
        inputProduct.setExpireDate(inputProductDto.getExpireDate());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setInput(optionalInput.get());
        inputProduct.setProduct(optionalProduct.get());
        inputProductRepository.save(inputProduct);
        return new Result("Input Product saqlandi",true);



    }
}
