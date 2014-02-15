package cz.jiripinkas.eshop.manager;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import cz.jiripinkas.eshop.service.UserOrderService;

//@ApplicationScoped
//@ManagedBean
public class CountUserOrdersBean {

//	private long count;
//
//	public long getCount() {
//		return count;
//	}
//
//	@EJB
//	private UserOrderService userOrderService;
//
//	@PostConstruct
//	public void init() {
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while (true) {
//					count = userOrderService.count();
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//	}
}
