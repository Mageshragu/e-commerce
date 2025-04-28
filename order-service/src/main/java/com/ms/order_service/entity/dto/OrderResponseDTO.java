package com.ms.order_service.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private double totalPrice;

    private String productName;
    private String productPrice;
}
