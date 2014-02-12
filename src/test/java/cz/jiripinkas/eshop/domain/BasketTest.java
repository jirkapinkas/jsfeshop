package cz.jiripinkas.eshop.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cz.jiripinkas.eshop.entity.Item;

public class BasketTest {

	private Basket basket;

	@Before
	public void setUp() {
		basket = new Basket();
		basket.init();
	}

	@Test
	public void testAddOne() {
		assertEquals(0, basket.getItems().size());
		basket.add(constructItem(1), 1);
		assertEquals(1, basket.getItems().size());
	}

	@Test
	public void testAddTwo() {
		assertEquals(0, basket.getItems().size());
		basket.add(constructItem(1), 1);
		basket.add(constructItem(2), 1);
		assertEquals(2, basket.getItems().size());
	}

	@Test
	public void testAddAddition() {
		assertEquals(0, basket.getItems().size());
		basket.add(constructItem(1), 1);
		basket.add(constructItem(1), 1);
		assertEquals(1, basket.getItems().size());
		assertEquals(2, basket.getItems().get(0).getQuantity());
	}

	private Item constructItem(int id) {
		Item item = new Item();
		item.setId(id);
		return item;
	}

}
