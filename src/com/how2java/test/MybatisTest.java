package com.how2java.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void testAdd() {
		Category category = new Category();
		category.setName("new Category");
		categoryMapper.add(category);
	}

	@Test
	public void testList() {
		System.out.println(categoryMapper);
		List<Category> cs=categoryMapper.list();
		for (Category c : cs) {
			System.out.println(c.getName());
		}
	}

	@Test
	public void testGet(){
		Category c1 = categoryMapper.get(2);
		System.out.println("c1是 ："+c1.getName());
	}

	@Test
	public void testDelete(){
		categoryMapper.delete(6);
		categoryMapper.delete(7);
		categoryMapper.delete(8);
		categoryMapper.delete(9);
		categoryMapper.delete(10);
		System.out.println("delete");
		List<Category> ls = categoryMapper.list();
		for (Category c : ls){
			System.out.println("id是："+c.getId()+"--name是："+c.getName());
		}
	}

	@Test
	public void testUpdate(){
		Category cnew = new Category();
		cnew.setName("updateCategory");
		cnew.setId(1);
		categoryMapper.update(cnew);
		List<Category> ls = categoryMapper.list();
		System.out.println("update:");
		for (Category c : ls){
			System.out.println("id是："+c.getId()+"--name是："+c.getName());
		}
	}

	@Test
	public void testCount(){
		List<Category> c = categoryMapper.count();
		System.out.println("count是 :"+c.size());
	}

}
