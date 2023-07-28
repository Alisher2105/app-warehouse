package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Output;
import com.example.appwarehouse.entity.OutputProduct;
import com.example.appwarehouse.entity.Product;
import com.example.appwarehouse.payload.OutputProductDto;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.OutputProductRepository;
import com.example.appwarehouse.repository.OutputRepository;
import com.example.appwarehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;

    public Result addOutputProduct(OutputProductDto outputProductDto) {

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (optionalProduct.isEmpty())
            return new Result("Bunday Id li Product Yo`q",false);

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (optionalOutput.isEmpty())
            return new Result("Bunday Id li Output mavjud emas",false);

        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setOutput(optionalOutput.get());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProductRepository.save(outputProduct);
        return new Result("OutputProduct saqlandi",true);
    }

    public List<OutputProduct> getOutputProduct() {
        return outputProductRepository.findAll();
    }

    public OutputProduct getOutputProductById(Integer id) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        return optionalOutputProduct.orElse(null);
    }

    public Result editOutputProductById(Integer id, OutputProductDto outputProductDto) {

        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isEmpty())
            return new Result("Bunday Id li OutputProduct mavjud emas",false);

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (optionalProduct.isEmpty())
            return new Result("Bunday Id li Product mavjud emas",false);

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (optionalOutput.isEmpty())
            return new Result("Bunday Id li Output mavjud emas",false);

        OutputProduct outputProduct = optionalOutputProduct.get();
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setOutput(optionalOutput.get());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProductRepository.save(outputProduct);
        return new Result("Muvaffaqiyatli o`zgartirildi",true,outputProduct.getId());

    }
}
