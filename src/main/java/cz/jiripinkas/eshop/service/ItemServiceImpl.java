package cz.jiripinkas.eshop.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.jiripinkas.eshop.entity.Item;

@Stateless
public class ItemServiceImpl implements ItemService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Item> findAll() {
		return entityManager.createQuery("from Item", Item.class).getResultList();
	}

	@Override
	public Item findOne(int id) {
		return entityManager.find(Item.class, id);
	}

	@Override
	public void save(Item item) {
		if(item.getId() == null) {
			entityManager.persist(item);
		} else {
			entityManager.merge(item);
		}
	}

}
