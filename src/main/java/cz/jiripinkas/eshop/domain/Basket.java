package cz.jiripinkas.eshop.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cz.jiripinkas.eshop.entity.Item;
import cz.jiripinkas.eshop.entity.OrderedItem;

@SessionScoped
@ManagedBean
public class Basket {

	private HashMap<Integer, OrderedItem> items;

	private OrderedItem selectedItem;

	@PostConstruct
	public void init() {
		items = new HashMap<Integer, OrderedItem>();
	}

	public void add(Item item, int quantity) {
		int itemId = item.getId();
		if (items.containsKey(itemId)) {
			OrderedItem orderedItem = items.get(itemId);
			orderedItem.setQuantity(orderedItem.getQuantity() + quantity);
		} else {
			OrderedItem orderedItem = new OrderedItem();
			orderedItem.setItem(item);
			orderedItem.setQuantity(quantity);
			items.put(item.getId(), orderedItem);
		}
	}

	public List<OrderedItem> getItems() {
		return new ArrayList<OrderedItem>(items.values());
	}
	
	public void setItems(HashMap<Integer, OrderedItem> items) {
		this.items = items;
	}

	private void remove(int itemId) {
		items.remove(itemId);
	}

	public void clear() {
		items.clear();
	}

	public void setSelectedItem(OrderedItem selectedItem) {
		this.selectedItem = selectedItem;
	}

	public OrderedItem getSelectedItem() {
		return selectedItem;
	}
	
	public void removeSelected() {
		remove(selectedItem.getItem().getId());
	}
}
