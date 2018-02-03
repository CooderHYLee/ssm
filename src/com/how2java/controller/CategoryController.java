package com.how2java.controller;


import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/")
	public String addCategory(){
		return "addCategory";
	}

	@RequestMapping("listCategory")
	public ModelAndView listCategory(){
		ModelAndView mav = new ModelAndView();
		List<Category> cs= categoryService.list();

		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}

	@RequestMapping("saveCategory")
	public String detailCategory(@ModelAttribute Category category, Model model){
		model.addAttribute("category", category);
		categoryService.add(category);
		return "saveCategory";
	}

	@RequestMapping("listPageCategory")
	public ModelAndView listPageCategory(Page page){

		//		<a href="?start=${page.start+page.count}">下一页</a>
		// 用来接收?start=5 ，page中start就等于5
		ModelAndView mav = new ModelAndView();
		if(page.getStart()>-1){
			List<Category> cs = categoryService.list(page);
			int total = categoryService.total();
			page.caculateLast(total);

			//传参
			mav.addObject("cs",cs);
			//放入jsp路径
			mav.setViewName("listPageCategory");
		}else {

		}

		return mav;
	}

	@RequestMapping("listPageHelperCategory")
	public ModelAndView listPageHelperCategory(Page page){

		ModelAndView mav = new ModelAndView();
		if(page.getStart()>-1){
			//用PageHelper来分页
			PageHelper.offsetPage(page.getStart(),page.getCount());

			List<Category> cs = categoryService.list();
			//用PageHelper来获取总条数
			int total = (int) new PageInfo<>(cs).getTotal();
			page.caculateLast(total);

			mav.addObject("cs",cs);
			mav.setViewName("listPageHelperCategory");
		}
		return mav;
	}

	@RequestMapping("editCategory")
	public ModelAndView editCategory(Category category){
		Category c= categoryService.get(category.getId());
		ModelAndView mav = new ModelAndView("editCategory");
		mav.addObject("c", c);
		return mav;
	}
	@RequestMapping("updateCategory")
	public ModelAndView updateCategory(Category category){
		categoryService.update(category);
		ModelAndView mav = new ModelAndView("redirect:/listPageHelperCategory");
		return mav;
	}

	@RequestMapping("addCategory")
	public ModelAndView addCategory(Category category){
		categoryService.add(category);
		ModelAndView mav = new ModelAndView("redirect:/listPageHelperCategory");
		return mav;
	}

	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(Category category){
		categoryService.delete(category);
		ModelAndView mav = new ModelAndView("redirect:/listPageHelperCategory");
		return mav;
	}


	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category){
		System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:\n"+category);
		JSONObject result = new JSONObject();
		result.put("OK", "OK");
		//这里会将OK返回到 ajax 中的回调函数中
		return result.toJSONString();
	}


	@ResponseBody
	@RequestMapping("/getOneCategory")
	public String getOneCategory() {
		Category c = new Category();
		c.setId(100);
		c.setName("第100个分类");
		JSONObject json= new JSONObject();
		json.put("category", JSONObject.toJSON(c));
		return json.toJSONString();
	}

	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory() {
		List<Category> cs = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setId(i);
			c.setName("分类名称:"+i);
			cs.add(c);
		}

		return JSONObject.toJSON(cs).toString();
	}
}
