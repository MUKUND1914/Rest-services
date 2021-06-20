package com.projectboot.spring.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileUploadServiceImp implements FileUploadService {
     private Path p;
     
     public FileUploadServiceImp() throws IOException {
		p= Paths.get("f:/tsetfile/");
		Files.createDirectories(p);
	}
	
	
	@Override
	public void upload(MultipartFile file) throws IOException {
		
		String filename=StringUtils.cleanPath(file.getOriginalFilename());
		
		if(filename.isEmpty())
		{
			throw new IOException("File is Empty :"+filename);
		}
        try
        {
        	Files.copy(file.getInputStream(),this.p.resolve(filename),StandardCopyOption.REPLACE_EXISTING );
        }
        catch(IOException e)
        {
        	throw new IOException("File upload Error :"+filename);
        }
	}

}
