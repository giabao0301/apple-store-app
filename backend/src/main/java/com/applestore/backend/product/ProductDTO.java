package com.applestore.backend.product;

import com.applestore.backend.variation.VariationDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String category;
    private String description;
    private String imageUrl;
    private String slug;
}
