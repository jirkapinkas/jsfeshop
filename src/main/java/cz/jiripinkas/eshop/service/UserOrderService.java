package cz.jiripinkas.eshop.service;

import java.util.List;

import javax.ejb.Local;

import cz.jiripinkas.eshop.domain.Basket;
import cz.jiripinkas.eshop.entity.UserOrder;

@Local
public interface UserOrderService {

	List<UserOrder> findAll();

	UserOrder findOne(int id);

	void save(UserOrder userOrder, Basket basket);

	List<UserOrder> findAllWithItems();
	
	void remove(int id);

}
