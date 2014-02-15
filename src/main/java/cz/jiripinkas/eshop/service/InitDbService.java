package cz.jiripinkas.eshop.service;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import cz.jiripinkas.eshop.domain.Basket;
import cz.jiripinkas.eshop.entity.Item;
import cz.jiripinkas.eshop.entity.OrderedItem;
import cz.jiripinkas.eshop.entity.UserOrder;

@Startup
@Singleton
public class InitDbService {

	@EJB
	private UserOrderService userOrderService;

	@EJB
	private ItemService itemService;

	@PostConstruct
	public void init() {
		System.out.println("*** START INIT DATABASE ***");
		Item itemJavaBook = constructItem("Java book",
				"Learn how to use Java in 21 days", 300);
		itemService.save(itemJavaBook);

		Item itemIntellijIdea = constructItem("IntelliJ Idea licence",
				"single developer licence", 9000);
		itemService.save(itemIntellijIdea);

		Basket basket = new Basket();
		basket.setItems(new HashMap<Integer, OrderedItem>());
		basket.add(itemJavaBook, 5);
		basket.add(itemIntellijIdea, 1);

		UserOrder userOrder = new UserOrder();
		userOrder.setName("Jirka Pinkas");
		userOrder.setCity("Hradec Králové");
		userOrder.setStreet("Šantrochova 424/3");
		userOrder.setZip("500 11");

		userOrderService.save(userOrder, basket);

		System.out.println("*** FINISH INIT DATABASE ***");
	}

	private Item constructItem(String name, String description, double price) {
		Item item = new Item();
		item.setName(name);
		item.setDescription(description);
		item.setPrice(price);
		return item;
	}
}
