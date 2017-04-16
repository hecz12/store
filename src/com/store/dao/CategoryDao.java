package com.store.dao;

import java.util.List;

import com.store.domain.Category;

public interface CategoryDao {

	List<Category> findAllCategory() throws Exception;

}
