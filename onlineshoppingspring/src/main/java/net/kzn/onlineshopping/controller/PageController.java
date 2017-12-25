package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController 
{
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		System.out.println("test.............1");
		mv.addObject("title","home");
		
		//passing the list of category
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	@RequestMapping(value={"/about"})
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		System.out.println("test.............1");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
//	Methods to load all the products and based on category
	@RequestMapping(value={"show/all/products"})
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		System.out.println("test.............1");
		mv.addObject("title","All Products");
		
		//passing the list of category
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		
		
		
		//categoryDAO to fetch a single category
		Category category=null;	
		category=categoryDAO.get(id);
	
		
		
		mv.addObject("title",category.getName());

		//passing the list of category
		mv.addObject("categories",categoryDAO.list());
				
		
		//passing the single category object
		mv.addObject("category",category);
		
		//passing the list of categories
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
	}

	@RequestMapping(value={"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		System.out.println("test.......contact......1");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	

	
	
	/*
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring Web MVC");
		return mv;
	}
	
	//http://localhost:8081/onlineshoppingspring/test  //not run because greeting parameter value is not present
	//http://localhost:8081/onlineshoppingspring/test?greeting=hi //run
	@RequestMapping(value={"/test"})
	public ModelAndView indexed(@RequestParam("greeting")String greeting1)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting1);
		return mv;
	}
	//http://localhost:8081/onlineshoppingspring/testing  //here run because greeting required is false
	//http://localhost:8081/onlineshoppingspring/testing?greeting=hi //run
	@RequestMapping(value={"/testing"})
	public ModelAndView indexs(@RequestParam(value="greeting",required=false)String greeting1)
	{
		if(greeting1==null)
		{
			greeting1="Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting1);
		return mv;
	}
	//http://localhost:8081/onlineshoppingspring/testing2/ee
	@RequestMapping(value="/testing2/{greeting}")
	public ModelAndView indexss(@PathVariable("greeting")String greeting1)
	{
		if(greeting1==null)
		{
			greeting1="Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting1);
		return mv;
	}
*/
}
