package com.brodyway.Springproject.Controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brodyway.Springproject.Model.User;
import com.brodyway.Springproject.Service.UserService;
import com.brodyway.Springproject.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired 
	private UserService userService;

	@GetMapping({ "/login", "/" })
	public String getLogin() {

		return "LoginForm";

	}

	@GetMapping("/Signup")
	public String getsignup() {
		return "SignupForm";
	}
	
	@PostMapping("/Signup")
	public String postSingnup(@ModelAttribute User user) {
		
     
		userService.signup(user);

		return "LoginForm";

	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model,
			HttpSession session/* ,@RequestParam("g-recaptcha-response" *//* )String recptCode */) throws IOException {
       
		/* if(VerifyRecaptcha.verify(recptCode)) { */
			
		
		User u = userService.login(user.getUsername(), user.getPassword());
		if (u != null) {
			session.setAttribute("validuser",u);
			session.setMaxInactiveInterval(200);
			
			//model.addAttribute("uname", u.getFname());
			
			return "Home"; 

		}else {
			model.addAttribute("error", "user not found !!");
			return "LoginForm";   
		}
		
	}/*
		 * model.addAttribute("error", " I AM robot !!"); return "LoginForm"; }
		 */

	@GetMapping("/userlist")
	public String getUserList(Model model) {
		model.addAttribute("UserList", userService.getAllUsers());
		return "userlistForm";

	}

	@GetMapping("/ur/delete")
	public String delete(@RequestParam int id) {
		userService.deleteUser(id);

		return "redirect:/userlist";
	}

	@GetMapping("/ur/edit")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("urmodel", userService.getUserById(id));
		return "userEditForm";

	}

	@PostMapping("/ur/update")
	public String update(@ModelAttribute User ur) {
		userService.updateUser(ur);
		return "redirect:/userlist";

	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();  //session kill-- 
		return "LoginForm";  
	}
	
	@GetMapping("/ur/view")
	public String userview(@RequestParam int id,Model model) {
		model.addAttribute("urmodel",userService.getUserById(id));
		return "userViewForm";
	}
	@PostMapping("/ur/Back")
	public String userBack(@ModelAttribute User ur) {
		return"redirect:/userlist";
	}
	@GetMapping("/profile")
	public String getprofile(){
		return"Profile";
		
		
		
	}
}
