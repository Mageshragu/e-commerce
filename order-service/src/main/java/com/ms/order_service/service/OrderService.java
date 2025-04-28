package com.ms.order_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.order_service.entity.Order;
import com.ms.order_service.entity.dto.OrderResponseDTO;
import com.ms.order_service.entity.dto.ProductDTO;
import com.ms.order_service.entity.dto.ResponseData;
import com.ms.order_service.feign.ProductInterface;
import com.ms.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    WebClient.Builder webClientBuilder;
    @Autowired
    ProductInterface productInterface;

    public Mono<OrderResponseDTO> placeOrder(Order order) {

        ResponseData<?> response = productInterface.getProductById(order.getProductId()).getBody();
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getData();

        ProductDTO product = new ObjectMapper().convertValue(map, ProductDTO.class);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setProductId(order.getProductId());
        orderResponseDTO.setQuantity(order.getQuantity());

        orderResponseDTO.setProductName(product.getName());
        orderResponseDTO.setTotalPrice(product.getPrice() * order.getQuantity());

        orderRepository.save(order);
        orderResponseDTO.setOrderId(order.getId());

        return  Mono.fromRunnable(() -> orderRepository.save(order))
                .thenReturn(orderResponseDTO);
//      using web builder
//        return webClientBuilder.build().get()
//                .uri("http://localhost:8081/product/productById/"+order.getProductId()).retrieve()
//                .bodyToMono(new ParameterizedTypeReference<ResponseData<ProductDTO>>() {}
//                ).map(responseData -> {
//                    ProductDTO productDTO1 = responseData.getData();
//                    OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
//                    orderResponseDTO.setProductId(order.getProductId());
//                    orderResponseDTO.setQuantity(order.getQuantity());
//
//                    orderResponseDTO.setProductName(productDTO1.getName());
//                    orderResponseDTO.setTotalPrice(productDTO1.getPrice() * order.getQuantity());
//
//                    orderRepository.save(order);
//                    orderResponseDTO.setOrderId(order.getId());
//
//                    return orderResponseDTO;
//                });
    }

    public List<Order> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
}
