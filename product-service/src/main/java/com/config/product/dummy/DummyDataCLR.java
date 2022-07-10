package com.config.product.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.config.product.domain.Product;
import com.config.product.repository.ProductRepository;

import java.util.stream.Stream;

@Component
class DummyDataCLR implements CommandLineRunner {

	@Autowired
    private ProductRepository productRepository;
	
	@Override
    public void run(String... strings) throws Exception {
        Stream.of("Pencil", "Book", "Eraser").forEach(s->{
        	productRepository.save(new Product(s));	
        });
        productRepository.findAll().forEach(s->System.out.println(s.getName()));
    }


}