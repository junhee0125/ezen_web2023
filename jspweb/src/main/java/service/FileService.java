package service;

import java.io.File;

public class FileService {
	
	
	//1. 파일 삭제
	
	public static boolean fileDelete(String filepath) {
		
		//1.파일 경로의 파일객 선언 : 다양한 메소드 제공하니깐
		File file = new File(filepath);
		
		
		if(file.exists()) {
			file.delete();
			return true;
		}
		
		return false;
	}
}
/*
 
 
 
 
 */