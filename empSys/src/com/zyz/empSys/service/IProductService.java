package com.zyz.empSys.service;

import java.util.List;

import com.zyz.empSys.pojo.CartItem;

/**
 * 为商品提供的接口
 * @author XHY
 */
public interface IProductService {
	/**
	 * 显示所有的商品
	 * @return
	 */
	List<CartItem> displayAllProducts();
}
