package com.fk.response;

import com.fk.entity.Directory;
import com.fk.entity.File;

public class LSResponse {

	private File file;
	private Directory directory;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Directory getDirectory() {
		return directory;
	}
	public void setDirectory(Directory directory) {
		this.directory = directory;
	}
	
	
}
