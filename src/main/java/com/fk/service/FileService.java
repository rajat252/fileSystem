package com.fk.service;

import java.util.List;

import com.fk.dao.FileDao;
import com.fk.entity.Directory;
import com.fk.entity.File;
import com.fk.response.LSResponse;

public class FileService {

	public LSResponse ls(FileDao fileDao, String path){
		
		File file = (File)fileDao.filepath.get(path);
		LSResponse lsResponse = new LSResponse();
		lsResponse.setFile(file);
		return lsResponse;
		
	}
	
	public String addToFile(FileDao fileDao,String path, String content) {
		File file = (File)fileDao.filepath.get(path);
		if(file==null) {
			file = new File();
			file.setContent(content);
		}else {
			content = file.getContent()+content;
			file.setContent(content);
		}
		fileDao.filepath.put(content, file);
		return content;
	}
	
	public String readFile(FileDao fileDao, String path) throws Exception {
		File file = (File)fileDao.filepath.get(path);
		if(file==null) {
			throw new Exception("File does not exist");
		}else {
			return file.getContent();
		}
	}
}
