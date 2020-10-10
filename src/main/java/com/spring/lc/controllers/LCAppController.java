package com.spring.lc.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.lc.api.UserInfoDTO;

@Controller
@SessionAttributes("Userinfo")
public class LCAppController {
		@RequestMapping("/")
		public String showHomePage(Model model) {
			/*Read the cookie for every page
			Cookie[] cookies=request.getCookies();
			for(Cookie temp:cookies) {
				if("lcApp.userName".equals(temp.getName())){
					String myuserName=temp.getValue();
					userinfodto.setUserName(myuserName);
				}
			}*/
			model.addAttribute("Userinfo", new UserInfoDTO());
			
			//read the existing property by fetching it from dto
//			UserInfoDTO userinfodto=new UserInfoDTO();
//			model.addAttribute("Userinfo", userinfodto);
			return "home-page";	
		}
		
		@RequestMapping("/process-homepage")
		public String showResultPage(@Valid @ModelAttribute("Userinfo") UserInfoDTO userinfodto,BindingResult result) {
			
			//writing the value to the properties by fetchingfrom the url
//			System.out.println("user name is "+userinfodto.getUserName());
//			System.out.println("Crush name is "+userinfodto.getCrushName());
//			
		//	model.addAttribute("Userinfo", userinfodto);
//			model.addAttribute("Crushname", crushname1);
			
			System.out.println(userinfodto.isTermAndCondition());
			
			
			if(result.hasErrors()) {
				//System.out.println("my form has errors...");
				List<ObjectError> allErrors = result.getAllErrors();
				for(ObjectError temp:allErrors) {
					System.out.println(temp);
				}
				return "home-page";
			}
			//Create a cookie for the userName
			
			/*Cookie thecookie=new Cookie("lcApp.userName",userinfodto.getUserName());
			thecookie.setMaxAge(60*60*24);*/
			
			//Add cookie to the response
			//response.addCookie(thecookie);
			
			/*Creating a session 
			HttpSession session=request.getSession();
			session.setAttribute("userName", userinfodto.getUserName());
			session.getMaxInactiveInterval(120);*/
			
			
			return "result-page";
		}
}
