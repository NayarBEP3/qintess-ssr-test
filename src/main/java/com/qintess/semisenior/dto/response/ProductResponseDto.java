/*
 * @(#)ProductDto.java
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
package com.qintess.semisenior.dto.response;

import lombok.Data;

@Data
public class ProductResponseDto {
    private long id;
    private String name;
    private String description;
    private double price;
}