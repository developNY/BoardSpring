package com.javalec.myBoard_spring.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.myBoard_spring.dao.Dao;
import com.javalec.myBoard_spring.dto.Dto;

public class ListCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Dao dao = new Dao();
		ArrayList<Dto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}

}
