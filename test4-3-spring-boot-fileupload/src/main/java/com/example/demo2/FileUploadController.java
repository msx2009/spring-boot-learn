package com.example.demo2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	SimpleDateFormat sdf = new SimpleDateFormat();
	@PostMapping("/upload")
	public String upload(MultipartFile uploadFile, HttpServletRequest req) {
		String realPath = req.getSession().getServletContext().getRealPath("uploadPath");
		//String format = "test";
		File folder = new File(realPath );
		
		System.out.println(realPath);
		if (!folder.isDirectory()) {
			folder.mkdir();
		}
		String oldName = uploadFile.getOriginalFilename();
		String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
		System.out.println(newName);
		try {
			uploadFile.transferTo(new File(folder, newName));
			String filePath = req.getScheme() + "://" +req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" 
					+ newName;
			return filePath;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "上传失败";
		
		
	}

}
