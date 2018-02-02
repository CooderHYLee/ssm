package com.how2java.service.impl;

import java.util.List;

import com.how2java.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> list(){
		return categoryMapper.list1();
	};

	@Override
	public void add(Category category) {
		categoryMapper.add(category);
	}

	@Override
	public int total(){
		return  categoryMapper.total();
	}

	@Override
	public List<Category> list(Page page) {
		// TODO Auto-generated method stub
		List<Category> ls = categoryMapper.list(page);
		return ls;
	}

	@Override
	public Category get(int i){
		Category c = categoryMapper.get(i);
		return c;
	}

	@Override
	public void update(Category category){
		categoryMapper.update(category);
	}

	@Override
	public void delete(Category category){
		categoryMapper.delete(category.getId());
	}
}
