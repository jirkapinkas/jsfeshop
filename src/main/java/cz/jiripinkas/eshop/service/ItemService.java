package cz.jiripinkas.eshop.service;

import java.util.List;

import javax.ejb.Local;

import cz.jiripinkas.eshop.entity.Item;

@Local
public interface ItemService {

	List<Item> findAll();

	Item findOne(int id);

	void save(Item item);
}
