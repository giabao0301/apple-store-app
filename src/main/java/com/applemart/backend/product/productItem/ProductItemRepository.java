package com.applemart.backend.product.productItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
    @Query("SELECT p FROM ProductItem p JOIN FETCH p.images WHERE p.slug = :slug")
    Optional<ProductItem> findBySlug(@Param("slug") String slug);
    Optional<ProductItem> findById(Integer id);
    boolean existsBySku(String sku);
}