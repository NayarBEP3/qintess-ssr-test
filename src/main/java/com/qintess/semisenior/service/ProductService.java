/*
 * @(#)ProductService.java
 *
 * Copyright (c) BANCO DE CHILE (Chile). All rights reserved.
 *
 * All rights to this product are owned by BANCO DE CHILE and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BANCO DE CHILE.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.qintess.semisenior.service;

import com.qintess.semisenior.dto.request.ProductRequestDto;
import com.qintess.semisenior.dto.response.ProductResponseDto;
import com.qintess.semisenior.entity.ProductEntity;
import com.qintess.semisenior.repository.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService.
 *
 * @author Brayan Estrada.
 * @version 1.0.0, 29-04-2024
 */
@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    private final ModelMapper mapper = new ModelMapper();

    public ProductService(final IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto create(ProductRequestDto request) {
        ProductEntity entity = mapper.map(request, ProductEntity.class);
        ProductEntity entitySaved = productRepository.save(entity);
        return mapper.map(entitySaved, ProductResponseDto.class);
    }

    public List<ProductResponseDto> getProducts() {
        List<ProductEntity> products = productRepository.findAll();
        List<ProductResponseDto> productResult = new ArrayList<>();
        for(ProductEntity product: products) {
            productResult.add(mapper.map(product, ProductResponseDto.class));
        }
        return productResult;
    }
}