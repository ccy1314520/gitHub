package com.zyz.empSys.dao;

import java.util.List;

import com.zyz.empSys.pojo.CartItem;

/**
 * product的dao接口
 * @author XHY
 */
public interface IProductDao {
	/**
	 * 寻找到所有的商品
	 * @return
	 */
	List<CartItem> findAllProducts();
}
