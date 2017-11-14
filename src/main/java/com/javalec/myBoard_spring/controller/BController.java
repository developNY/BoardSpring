package com.javalec.myBoard_spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.myBoard_spring.command.Command;
import com.javalec.myBoard_spring.command.ContentCommand;
import com.javalec.myBoard_spring.command.DeleteCommand;
import com.javalec.myBoard_spring.command.ListCommand;
import com.javalec.myBoard_spring.command.ModifyCommand;
import com.javalec.myBoard_spring.command.WriteCommand;
import com.javalec.myBoard_spring.util.Constant;

@Controller
public class BController {

	Command command = null;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template){
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		
		System.out.println("list()");
		command = new ListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		
		System.out.println("delete()");
		model.addAttribute("request", request);
		command = new DeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model){
		
		System.out.println("modify()");
		model.addAttribute("request", request);
		command = new ModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		
		System.out.println("write()");
		model.addAttribute("request", request);
		command = new WriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model){
		
		System.out.println("content_view()");
		model.addAttribute("request", request);
		command = new ContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	//이건 그냥 작성 페이지이다.
	@RequestMapping("/write_view")
	public String write_view(Model model){
		
		System.out.println("write_view()");
		
		return "write_view";
	}
}
