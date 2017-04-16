package com.store.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sun.util.resources.ParallelListResourceBundle;

import com.store.dao.ProductDao;
import com.store.domain.Product;
import com.store.utils.DataSourceUtils;

public class ProductDaoImpl implements ProductDao {
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	public List<Product> findHotProduct() throws Exception {
		String sql = "select * from product where is_hot=1 order by pdate desc limit 9";
		List<Product> plist = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return plist;
	}

	public List<Product> findNewProduct() throws Exception {
		String sql = "select * from product order by pdate desc limit 9";
		List<Product> plist = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return plist;
	}

	public Product getProductById(String pid) throws Exception {
		String sql = "select * from product where pid = ? limit 1";
		return qr.query(sql, new BeanHandler<Product>(Product.class),pid);
	}

	public int getTotalCount(String cid) throws Exception {
		String sql = "select count(*) from product where cid = ?";
		int totalCount = ((Long)qr.query(sql, new ScalarHandler(),cid)).intValue();
		return totalCount;
	}

	public List<Product> findByPage(int pageSize, int currPage, String cid)
			throws Exception {
		String sql = "select * from product where cid = ? limit ?,?";
		List<Product> list = qr.query(sql,new BeanListHandler<Product>(Product.class) ,cid,(currPage-1)*pageSize,pageSize);
		return list;
	}

	public List<Product> getHistory(LinkedList<String> list) throws Exception {
		String sql="select * from product where pid=?";
		String[][] params = new String[list.size()][];
		LinkedList<Product> pList = new LinkedList<Product>();
		for(int i = 0;i<list.size();i++)
		{
			Product pro = qr.query(sql, new BeanHandler<Product>(Product.class),list.get(i));
			pList.addLast(pro);
		}
		return pList;
	}
	
}
