package com.brodyway.Springproject.Controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	
	@GetMapping("/gallery")
	public String getGallery(Model model, HttpSession session) {
		
	    if (session.getAttribute("validuser") == null) { 
            return "LoginForm";
             
	    }
	    
	    File imageDirectory = new File("src/main/resources/static/image");
	    String[] imgNameList = imageDirectory.list();
	    model.addAttribute("imgList", imgNameList);
	    
	    return "GalleryForm";
	}

}