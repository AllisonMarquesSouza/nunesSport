package com.br.nunes.sports.controller;

import com.br.nunes.sports.dtos.ProductDtoCreate;
import com.br.nunes.sports.dtos.ProductDtoUpdate;
import com.br.nunes.sports.model.Product;
import com.br.nunes.sports.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
//localhost:8080/products
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid request parameters", content = @Content(schema = @Schema())),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(schema = @Schema())),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema()))
})
public class ProductController {

    private final ProductService productService;

    @Operation(summary =  "listAll", method = "GET", description ="List all products", responses = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)
                    ))})
    @GetMapping("listAll")
    public ResponseEntity<List<Product>> listAll(){
        return ResponseEntity.ok(productService.listAllProduct());
    }


    @Operation(summary =  "Filter", method = "GET", description ="Filter product by name or description", responses = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)
                    ))})
    @GetMapping("filter")
    public ResponseEntity<List<Product>> getByName(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String description){
        return ResponseEntity.ok(productService.filterProductsByNameOrDesc(name, description));
    }


    @Operation(summary =  "Get by ID", method = "GET", description ="Get product by id", responses = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)
                    ))})
    @GetMapping("getByCode/{code}")
    public ResponseEntity<Product> getByCode(@PathVariable UUID code){
        return ResponseEntity.ok(productService.getProductByCode(code));
    }


    @Operation(summary =  "Create", method = "POST", description ="Create a product", responses = {
            @ApiResponse(responseCode = "201", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)
                    ))})
    @PostMapping("save")
    public ResponseEntity<Product> save(@RequestBody ProductDtoCreate productDtoCreate){
        return new ResponseEntity<>(productService.createProduct(productDtoCreate), HttpStatus.CREATED);
    }


    @Operation(summary =  "Update", method = "PUT", description ="Update a product", responses = {
            @ApiResponse(responseCode = "204", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema()
                    ))})
    @PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody ProductDtoUpdate productDtoUpdate){
        productService.updateProduct(productDtoUpdate);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary =  "Delete", method = "PUT", description ="Delete a product by code", responses = {
            @ApiResponse(responseCode = "204", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema()
                    ))})
    @DeleteMapping("delete/{code}")
    public ResponseEntity<Void> update(@PathVariable UUID code){
        productService.deleteProduct(code);
        return ResponseEntity.noContent().build();
    }
}
