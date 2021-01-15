package com.bway.springproject.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String getUploadForm() {
		
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String saveFile(@RequestParam("file") MultipartFile file, Model model) {
		
		
		if(!file.isEmpty()) {
			
			try {
				
				FileOutputStream fw= new FileOutputStream("C:\\Users\\Gautam\\Documents\\workspace-sts-3.9.9.RELEASE\\springproject\\src\\main\\webapp\\resources\\imgs\\"+file.getOriginalFilename());
				fw.write(file.getBytes());
				fw.close();
				model.addAttribute("msg",  "File Upload Success!!");
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			
		}
		
		return "uploadForm";
		
		
	}
	
}
