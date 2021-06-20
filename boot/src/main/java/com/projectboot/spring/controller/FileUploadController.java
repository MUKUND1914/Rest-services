package com.projectboot.spring.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projectboot.spring.service.FileUploadService;

@RestController
@RequestMapping("/file")
public class FileUploadController {

	@Autowired
	FileUploadService f;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Map<String, Object> uploadfilem(@RequestParam("file") MultipartFile file) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			f.upload(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("Result", "File uploaded");
		return map;
	}

}
