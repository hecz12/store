package com.store.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.store.dao.CategoryDao;
import com.store.domain.Category;
import com.store.utils.DataSourceUtils;

public class CategoryDaoImpl implements CategoryDao {
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	public List<Category> findAllCategory() throws Exception {
		String sql = "select * from category";
		List<Category> clist = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return clist;
	}

}
