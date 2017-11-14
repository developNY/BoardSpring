package com.javalec.myBoard_spring.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.myBoard_spring.dao.Dao;

public class DeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");	//request��� key�̸��� value�� ��ȯ�Ѵ�.
		
		String bId = request.getParameter("bId");
		Dao dao = new Dao();
		dao.delete(bId);
	}

}
