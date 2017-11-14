package com.javalec.myBoard_spring.command;

import org.springframework.ui.Model;

public interface Command {
	
	void execute(Model model);
}
