package com.javalec.myBoard_spring.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.myBoard_spring.dao.Dao;

public class ModifyCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Dao dao = new Dao();
		dao.modify(bId, name, title, content);
	}

}
