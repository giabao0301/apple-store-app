package com.applemart.backend.product.productItem;

import com.applemart.backend.product.productConfiguration.ProductConfiguration;
import com.applemart.backend.product.Product;
import com.applemart.backend.product.productImage.ProductImage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product_item")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();

    private String sku;

    @Column(name = "qty_in_stock")
    private Integer quantity;

    private Double price;

    private String slug;

    @OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductConfiguration> configurations = new ArrayList<>();

    public void addProductImage(ProductImage productImage) {
        if (!images.contains(productImage)) {
            images.add(productImage);
            productImage.setProductItem(this);
        }
    }

    public void addProductConfiguration(ProductConfiguration productConfiguration) {
        if (!this.configurations.contains(productConfiguration)) {
            this.configurations.add(productConfiguration);
            productConfiguration.setProductItem(this);
        }
    }
}
