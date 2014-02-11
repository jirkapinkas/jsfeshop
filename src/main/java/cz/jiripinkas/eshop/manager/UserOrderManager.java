package cz.jiripinkas.eshop.manager;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import cz.jiripinkas.eshop.domain.Basket;
import cz.jiripinkas.eshop.entity.UserOrder;
import cz.jiripinkas.eshop.service.UserOrderService;

@ViewScoped
@ManagedBean
public class UserOrderManager {

	private UserOrder userOrder;

	private List<UserOrder> userOrders;

	@EJB
	private UserOrderService userOrderService;

	@ManagedProperty("#{basket}")
	private Basket basket;

	@PostConstruct
	public void init() {
		userOrder = new UserOrder();
	}

	public void save() {
		userOrderService.save(userOrder, basket);
		basket.clear();
		userOrder = new UserOrder();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Order saved", null));
	}

	public void loadAll() {
		userOrders = userOrderService.findAll();
	}

	public void loadAllWithItems() {
		userOrders = userOrderService.findAllWithItems();
	}

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public List<UserOrder> getUserOrders() {
		return userOrders;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}
}
