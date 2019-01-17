package com.zyz.empSys.service.impl;

import java.util.List;

import com.zyz.empSys.dao.IProductDao;
import com.zyz.empSys.dao.impl.ProductDaoImpl;
import com.zyz.empSys.pojo.CartItem;
import com.zyz.empSys.service.IProductService;

/**
 * 商品服务接口的实现类
 * @author XHY
 */
public class ProductServiceImpl implements IProductService {
	//声明dao接口的引用
	IProductDao ipd=new ProductDaoImpl();
	@Override
	public List<CartItem> displayAllProducts() {
		List<CartItem> items = ipd.findAllProducts();
		return items;
	}

}
