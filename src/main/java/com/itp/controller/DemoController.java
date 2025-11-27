package com.itp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itp.model.Player;

@Controller
public class DemoController {
	
	@RequestMapping("/")
	public String demo(Model model)
	{
		String playerName="Mahendra Singh Dhoni";  //service layer
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
	
	@RequestMapping("/playerList")
	public String listOfPlayers(Model model)
	{
		Player player1= new Player(7,"Mahendra Singh Dhoni",100,10000);
		Player player2= new Player(18,"Virat Kohli",90,9000);
		Player player3= new Player(45,"Rohit Sharma",80,8000);
		Player player4= new Player(1,"KL Rahul",50,5000);
		
		List<Player> players=new ArrayList(Arrays.asList(player1,player2,player3,player4));
		model.addAttribute("players", players);
		return "list-of-players";
	}

	
//	@RequestMapping("/addPlayerForm")
//	public String addPlayerForm(Model model)
//	{
//		Player player1= new Player();
//		model.addAttribute("player", player1);
//		return "add-player-form";
//	}
	
//	@RequestMapping("/addPlayerForm")
//	public String addPlayerForm(ModelMap modelmap)
//	{
//		Player player1= new Player();
//		modelmap.addAttribute("player", player1);
//		return "add-player-form";
//	}
	

	@RequestMapping("/addPlayerForm")
	public ModelAndView addPlayerForm()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("add-player-form");
		Player player1= new Player();
		mav.addObject("player", player1);
		return mav;
	}

	@RequestMapping("/addPlayer")
	public String addPlayer(@ModelAttribute Player player,Model model)
	{
		System.out.println(player);
		model.addAttribute("player",player);
		return "confirm";
	}

}
