package com.br.nunes.sports.repository;

import com.br.nunes.sports.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCodeProduct(UUID code);
    void deleteByCodeProduct(UUID code);
    Boolean existsByCodeProduct(UUID code);

    @Query("""
    SELECT p FROM Product p
        WHERE (:nameProduct IS NULL OR p.nameProduct LIKE CONCAT('%', :nameProduct, '%'))
        AND (:descProduct IS NULL OR p.descProduct LIKE CONCAT('%', :descProduct, '%'))
    """)
    List<Product> filterProductsByNameOrDesc(@Param("nameProduct") String nameProduct, @Param("descProduct") String descProduct);
}