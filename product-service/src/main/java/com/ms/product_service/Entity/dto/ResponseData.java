package com.ms.product_service.Entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private Object data;
    private Map<String, Object> error = new HashMap<>();
}
