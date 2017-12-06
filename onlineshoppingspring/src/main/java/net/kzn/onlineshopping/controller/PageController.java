package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{
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

}
