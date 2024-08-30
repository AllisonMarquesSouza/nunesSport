package com.br.nunes.sports.controller;

import com.br.nunes.sports.dtos.ProductDtoCreate;
import com.br.nunes.sports.dtos.ProductDtoUpdate;
import com.br.nunes.sports.model.Product;
import com.br.nunes.sports.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
//localhost:8080/products
public class ProductController {

    private final ProductService productService;

    @GetMapping("listAll")
    public ResponseEntity<List<Product>> listAll(){
        return ResponseEntity.ok(productService.listAllProduct());
    }

    @GetMapping("filter")
    public ResponseEntity<List<Product>> getByName(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String description){
        return ResponseEntity.ok(productService.filterProductsByNameOrDesc(name, description));
    }

    @GetMapping("getByCode/{code}")
    public ResponseEntity<Product> getByCode(@PathVariable UUID code){
        return ResponseEntity.ok(productService.getProductByCode(code));
    }

    @PostMapping("save")
    public ResponseEntity<Product> save(@RequestBody ProductDtoCreate productDtoCreate){
        return ResponseEntity.ok(productService.createProduct(productDtoCreate));
    }

    @PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody ProductDtoUpdate productDtoUpdate){
        productService.updateProduct(productDtoUpdate);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{code}")
    public ResponseEntity<Void> update(@PathVariable UUID code){
        productService.deleteProduct(code);
        return ResponseEntity.noContent().build();
    }
}
