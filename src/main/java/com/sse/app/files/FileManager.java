package com.sse.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

//	HDD(하드디스크)에 파일을 저장하는 메서드

	public String fileSave(MultipartFile files, String path) throws Exception {

		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}

		String fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();

		file = new File(file, fileName);
		files.transferTo(file);

		return fileName;
	}

}
