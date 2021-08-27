package com.fk.service;

import com.fk.dao.FileDao;
import com.fk.response.LSResponse;

public interface IFileService {

	public LSResponse ls(FileDao fileDao, String path);
}
