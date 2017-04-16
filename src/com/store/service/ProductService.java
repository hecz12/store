package com.store.service;

import java.util.LinkedList;
import java.util.List;

import com.store.domain.PageBean;
import com.store.domain.Product;

public interface ProductService {

	List<Product> findHotProduct() throws Exception;

	List<Product> findNewProduct() throws Exception;

	Product getProductById(String pid) throws Exception;

	PageBean<Product> findByPage(String cid, int currPage, int pageSize) throws Exception;

	List<Product> findHistory(LinkedList<String> list) throws Exception;
	
}
