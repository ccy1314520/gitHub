package com.zyz.empSys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zyz.empSys.dao.IProductDao;
import com.zyz.empSys.pojo.CartItem;
import com.zyz.empSys.utils.C3P0DBUtils;

/**
 * IProductDao接口的实现类
 * 
 * @author XHY
 */
public class ProductDaoImpl implements IProductDao {
	// 获取到数据库当中的元数据
	private static DataSource source = C3P0DBUtils.getDataSource();
	private static QueryRunner runner = new QueryRunner(source);

	@Override
	public List<CartItem> findAllProducts() {
		try {
			List<CartItem> items = runner.query("select * from product", new BeanListHandler<CartItem>(CartItem.class));
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
