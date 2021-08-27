package com.fk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.fk.dao.FileDao;
import com.fk.entity.Directory;
import com.fk.response.LSResponse;

public class DirectoryService implements IFileService{

	public LSResponse ls(FileDao fileDao, String path){
		Directory dir = (Directory)fileDao.filepath.get(path);
		LSResponse lsResponse = new LSResponse();
		lsResponse.setDirectory(dir);
		return lsResponse;
	}
	
	public void makeDir(FileDao fileDao, String path) {
		
		parse(fileDao,path);
		addHeirarchy(fileDao,path);
	}
	
	private void checkDir(FileDao fileDao, String path) {
		Directory dir = (Directory)fileDao.filepath.get(path);
		if(dir==null) {
			Directory directory = new Directory();
			directory.setPath(path);
			
			fileDao.filepath.put(path,directory);
		}
	}
	
	private void addHeirarchy(FileDao fileDao,String path) {
		StringTokenizer st = new StringTokenizer("/");
		
		String parent = st.nextToken();
		String child = null;
		while(st.hasMoreTokens()) {
			child = st.nextToken();
			
			insertHeirarchy(fileDao,parent,child);
			parent = child;
		}
	}
	
	private void parse(FileDao fileDao,String path) {
		StringTokenizer st = new StringTokenizer("/");
		StringBuffer sb = new StringBuffer("");
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken()+"/");
			checkDir(fileDao,sb.toString());
		}
	}
	
	private void insertHeirarchy(FileDao fileDao, String parentPath,String childPath) {
		Directory dir = (Directory)fileDao.filepath.get(parentPath);
		Directory child = (Directory)fileDao.filepath.get(childPath);
		if(dir!=null) {
			List<Directory>list = dir.getDirectories();
			if(list==null) {
				list = new ArrayList<Directory>();
				
			}
			list.add(child);
			dir.setDirectories(list);
		}
	}
	
	
}
