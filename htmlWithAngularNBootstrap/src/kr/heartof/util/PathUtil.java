package kr.heartof.util;

import java.util.Map;

import kr.heartof.admin.mapper.PathVO;

public class PathUtil {
	private static Map<String, PathVO> path;
	public static void setPath(Map<String, PathVO> p){
		path = p;
	}
	
	public static String getPath(kr.heartof.constant.Path cPath) { 
		return path.get(cPath.getPath()).getPATH();
	}
	
	public static String getPathNM(kr.heartof.constant.Path cPath) { 
		return path.get(cPath.getPath()).getPATH_NM();
	}
}
