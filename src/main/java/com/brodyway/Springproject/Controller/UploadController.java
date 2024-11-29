package com.brodyway.Springproject.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@GetMapping("/upload")
	public String getUpload() {
		return "UploadForm";
	}
	
	@PostMapping("/upload")
	public String postupload(@RequestParam MultipartFile image,Model model) throws IOException {
		if(!image.isEmpty()){
			
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

			model.addAttribute("message","sucess");
			return "UploadForm";
		}
		model.addAttribute("message","Faield");
		return"UploadForm";
		
		
	}

}
