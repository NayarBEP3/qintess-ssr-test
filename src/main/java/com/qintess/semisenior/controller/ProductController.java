/*
 * @(#)ProductController.java
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
package com.qintess.semisenior.controller;

import com.qintess.semisenior.dto.request.ProductRequestDto;
import com.qintess.semisenior.dto.response.ProductResponseDto;
import com.qintess.semisenior.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController.
 *
 * @author Brayan Estrada.
 * @version 1.0.0, 29-04-2024
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService service;

    public ProductController(final ProductService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto request) {
        return new ResponseEntity<>(this.service.create(request), HttpStatusCode.valueOf(201));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        return new ResponseEntity<>(this.service.getProducts(), HttpStatusCode.valueOf(200));
    }
}