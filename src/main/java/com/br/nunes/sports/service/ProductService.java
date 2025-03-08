package com.br.nunes.sports.service;

import com.br.nunes.sports.dtos.ProductDtoCreate;
import com.br.nunes.sports.dtos.ProductDtoUpdate;
import com.br.nunes.sports.model.Product;
import com.br.nunes.sports.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> filterProductsByNameOrDesc(String name,String desc) {
        return productRepository.filterProductsByNameOrDesc(name, desc);
    }

    public Product getProductByCode(UUID code) {
        return productRepository.findByCodeProduct(code).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    @Transactional
    public Product createProduct(ProductDtoCreate productDtoCreate) {
        Product productToSave = new Product(productDtoCreate);
        return productRepository.save(productToSave);
    }

    @Transactional
    public void updateProduct(ProductDtoUpdate productDtoUpdated) {
        UUID code = productDtoUpdated.getCodeProduct();

        Boolean checkCode = productRepository.existsByCodeProduct(code);
        if(!checkCode){
            throw new EntityNotFoundException("Product not found, check the code");
        }

        Product product = getProductByCode(code);
        Product productToUpdate = new Product(productDtoUpdated);
        productToUpdate.setId(product.getId());
        productRepository.save(productToUpdate);
    }

    @Transactional
    public void deleteProduct(UUID code) {
        Boolean checkCode = productRepository.existsByCodeProduct(code);
        if(!checkCode){
            throw new EntityNotFoundException("Product not found, check the code");
        }

        productRepository.deleteByCodeProduct(code);
    }
}
