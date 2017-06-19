package com.niit.ecommercefrontend.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommercebackend.dao.CategoryDAO;
import com.niit.ecommercebackend.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@ModelAttribute
	public Category returnObject()
	{
		return new Category();
	}	
	
	@RequestMapping("/AddCategory")
	public ModelAndView showCategory()
	{
		ModelAndView mv= new ModelAndView("AddCategory");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value="/addcat",method=RequestMethod.POST)
	public String addcat(@ModelAttribute("category")Category category,BindingResult result,HttpServletRequest request,Model model) throws IOException
	{
		model.addAttribute("category",new Category());
		if(category.getCategory_id()==0)
		{
			categoryDAO.saveOrUpdate(category);
			System.out.println("category added");
		}
		else
		{
			categoryDAO.saveOrUpdate(category);
			System.out.println("category updated");
		}
		return "redirect:/AddCategory";
	}
	
	/*@RequestMapping("/AddCategory")
	public ModelAndView showCategory()
	{
		ModelAndView mv= new ModelAndView("AddCategory");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}*/
	@RequestMapping(value="/editcategory{id}")
		public ModelAndView updateCategory(@PathVariable("id")String id,Model model)
		{
		int i=Integer.parseInt(id);
		model.addAttribute("category", categoryDAO.get(i));
		model.addAttribute("categoryList", categoryDAO.list());
		ModelAndView mv=new ModelAndView("AddCategory");
		return mv;
		}
		
		@RequestMapping(value="/deletecategory{id}")
		public ModelAndView deleteCategory(@PathVariable("id")String id,Model model)
		{
		int i=Integer.parseInt(id);
		category = categoryDAO.get(i);
		/*model.addAttribute("category", categoryDAO.get(i));*/
		categoryDAO.delete(category);
		model.addAttribute("categoryList", categoryDAO.list());
		ModelAndView mv=new ModelAndView("AddCategory");
		mv.addObject("addcategory", 0);
		return mv;
		}
	
	
}
