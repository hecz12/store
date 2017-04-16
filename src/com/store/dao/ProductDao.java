package com.store.dao;

import java.util.LinkedList;
import java.util.List;

import com.store.domain.Product;

public interface ProductDao {

	List<Product> findHotProduct() throws Exception;

	List<Product> findNewProduct() throws Exception;

	Product getProductById(String pid) throws Exception;

	int getTotalCount(String cid) throws Exception;

	List<Product> findByPage(int pageSize, int currPage, String cid) throws Exception;

	List<Product> getHistory(LinkedList<String> list) throws Exception;

}
