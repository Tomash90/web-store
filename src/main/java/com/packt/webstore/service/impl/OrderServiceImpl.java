package com.packt.webstore.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.CartItem;
import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.OrderRepository;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.CartService;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartService cartService;
	
	@Override
	public void processOrder(String productId, int count) {
		Product productById = productRepository.getProductById(productId);
		if(productById.getUnitsInStock() < count) {
			throw new IllegalArgumentException("Zbyt mała ilość towaru. Obecna liczba sztuk w magazynie: " + productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}

	@Override
	public Long saveOrder(Order order) {
		Map<String, CartItem> cartItems = order.getCart().getCartItems();
		for(CartItem item : cartItems.values()) {
			int quantity = item.getQuantity();
			Product product = item.getProduct();
			processOrder(product.getProductId(), quantity);
		}
		Long orderId= orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		return orderId;
	}
}
