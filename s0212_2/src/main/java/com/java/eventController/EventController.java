package com.java.eventController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EService;

import jakarta.servlet.http.HttpSession;


@Controller
public class EventController {

	@Autowired EService eService;
	@Autowired HttpSession session;
	
	@GetMapping("/event/event")
	public String event(Model model) {
		
		ArrayList<EventDto> list = eService.event();
		model.addAttribute("list",list);
		
		return "event/event";
	}
	
	@GetMapping("/event/eview")
	public String eview(int eno,Model model) {
		
		EventDto eventDto = eService.eview(eno);
		ArrayList<CboardDto> clist = eService.clist(eno);
		model.addAttribute("edto",eventDto);
		model.addAttribute("clist",clist);
		return "event/eview";
	}
	
}
