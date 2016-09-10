package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;

@Repository
public class InMemoryCartRepository implements CartRepository {
private Map<String, Cart> listOfCarts;

	public InMemoryCartRepository() {
	listOfCarts = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if(listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Nie można utworzyć koszyka o wskazanym id (%), Koszyk o wskazanym id już istnieje", cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!listOfCarts.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Nie można zaktualizować koszyka o wskazanym id (%). Koszyk o wskazanym id nie istnieje",cartId));
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if(!listOfCarts.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Nie można usunąć koszyka o wskazanym id (%). Koszyk o wskazanym id nie istnieje",cartId));
		}
		listOfCarts.remove(cartId);
	}

}
