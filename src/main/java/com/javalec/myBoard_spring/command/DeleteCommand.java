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
		HttpServletRequest request = (HttpServletRequest) map.get("request");	//request라는 key이름의 value를 반환한다.
		
		String bId = request.getParameter("bId");
		Dao dao = new Dao();
		dao.delete(bId);
	}

}
