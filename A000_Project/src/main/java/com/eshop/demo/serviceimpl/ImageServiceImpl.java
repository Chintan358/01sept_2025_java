package com.eshop.demo.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.demo.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public String uploadImage(String path, MultipartFile file) {
		
		String filename = file.getOriginalFilename();
		
		
		
		try {
			//String filepath = path+File.separator+filename;
			File f = new File(path);
			if(!f.exists())
			{
				f.mkdir();
			}
			
	
			String filepath = path + File.separator + filename;
			Files.copy(file.getInputStream(), Paths.get(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filename;
	}

	
	
	

}
