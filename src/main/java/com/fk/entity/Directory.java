package com.fk.entity;

import java.util.List;

public class Directory implements IFile{

	private List<File> files;
	private List<Directory> directories;
	public int id;
	public static String name;
	public String path;
	
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public List<Directory> getDirectories() {
		return directories;
	}
	public void setDirectories(List<Directory> directories) {
		this.directories = directories;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Directory.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
