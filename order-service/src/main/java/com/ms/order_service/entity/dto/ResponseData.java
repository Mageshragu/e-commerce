package com.ms.order_service.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData<T> {
    private T data;
    private Map<String, Object> error = new HashMap<>();
}
