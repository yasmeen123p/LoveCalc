package com.spring.lc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.spring.lc.api.EmailDTO;
import com.spring.lc.api.UserInfoDTO;
import com.spring.lc.service.LCAppEmailService;
import com.spring.lc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailService;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {
		//model.addAttribute("userName", userNamee);
		model.addAttribute("emailDTO", new EmailDTO());
		//model.addAttribute("userName",userName.toUpperCase() );
		return "send-email-page";

	}

	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("Userinfo") UserInfoDTO userInfoDTO,
			@ModelAttribute("emailDTO") EmailDTO emailDTO) {
		
		//add something to the session in this page
		/*String userName = (String) session.getAttribute("userName");
		String newUserName="Miss " + userName;
		model.addAttribute("userName",newUserName);*/
		
		lcAppEmailService.sendEmail(userInfoDTO.getUserName(),emailDTO.getUserEmail(),"FRIEND");
		
		
		return "process-email-page";

	}
}
