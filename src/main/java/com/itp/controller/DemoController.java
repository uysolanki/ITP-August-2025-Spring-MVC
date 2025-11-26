package com.itp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itp.model.Player;

@Controller
public class DemoController {
	
	@RequestMapping("/")
	public String demo(Model model)
	{
		String playerName="Mahendra Singh Dhoni";
		model.addAttribute("player", playerName);
		return "test";
	}
	
	@RequestMapping("/csk")
	public String demo1(Model model)
	{
		Player player= new Player(7,"Mahendra Singh Dhoni",100,10000);
		model.addAttribute("myplayer", player);
		return "cricket";
	}

}
