package kr.heartof.util;

import java.io.File;
import java.io.FileDescriptor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {

	private HttpServletRequest request = null;
	private File uploadDir = null;
	private List<FileItem> items = null;
	private Map<String, String> paramMap = null;
	private long requestLimit = 100 * 1024 * 1024; // 한번에 업로드 용량은 기본 100메가
	private long fileLimit = 5 * 1024 * 1024; // 업로드 가능한 파일의 용량은 기본 5메가

	public FileUpload(HttpServletRequest request, String uploadDir) throws Exception {
		this(request, new File(uploadDir), 1024 * 1024 * 3);
	}

	public FileUpload(HttpServletRequest request, File uploadDir) throws Exception {
		this(request, uploadDir, 1024 * 1024 * 3);
	}

	public FileUpload(HttpServletRequest request, String uploadDir, long fileLimit) throws Exception {
		this(request, new File(uploadDir), fileLimit);
	}

	public FileUpload(HttpServletRequest request, File uploadDir, long fileLimit) throws Exception {
		this.request = request;
		this.uploadDir = uploadDir;
		this.fileLimit = fileLimit;
		init();
	}

	private void init() throws Exception {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			throw new Exception("form의 enctype을 multipart/form-data로 하세요...");
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024); // 메모리에 저장할 최대 size
		factory.setRepository(uploadDir); // 임시 저장할 위치
		// 업로드 핸들러 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(requestLimit); // Set overall request size constraint
		items = upload.parseRequest(request); // Parse the request

		// 파람값들을 맵에 셋팅
		processFormField(items);
	}

	private void processFormField(List<FileItem> items) throws Exception {
		paramMap = new HashMap<String, String>();
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = iter.next();
			if (item.isFormField()) {
				paramMap.put(item.getFieldName(), item.getString("UTF-8"));
			}
		}
	}

	private void chkFileLimit() throws Exception {
		Iterator<FileItem> iter = items.iterator();

		while (iter.hasNext()) {
			FileItem item = iter.next();

			if (!item.isFormField()) {
				String fileName = new File(item.getName()).getName();
				long fileSize = item.getSize();
				if (fileName != null && !"".equals(fileName)) {
					if (fileLimit < fileSize) {
						throw new Exception(fileName + " 파일이 " + fileLimit / 1024 / 1024 + "M를 초과하였습니다.\n");
					}
				}
			}
		}
	}

	/**
	 * 
	 * request상의 모든파일을 업로드한다.<br>
	 * 
	 * 파일명의 중복을 피하기 위해 업로드하는 파일은 파일명 뒷부분에 현재일시를 붙여서 저장한다.<br>
	 * 
	 * 업로드후 변경된 파일명을 map으로 리턴받아 처리한다.
	 * 
	 * @throws Exception
	 * 
	 */

	public Map<String, FileInfo> uploadFiles() throws Exception {
		Map<String, FileInfo> map = new HashMap<String, FileInfo>();
		boolean writeToFile = true; // 파일에 쓸것인지 구분 플래그
		Iterator<FileItem> iter = items.iterator();
		chkFileLimit(); // 파일들의 사이즈 체크

		while (iter.hasNext()) {
			FileItem item = iter.next();
			// Process a file upload
			if (!item.isFormField()) {
				String filePath = item.getName();
				File file = new File(filePath);
				String fileName = file.getName();
				String extendFileName = getExtionFileName(fileName);
				if (fileName != null && !"".equals(fileName)) {
					// 파일업로드시...
					if (writeToFile) {
						String updFilePath = uploadDir + saveLocation(uploadDir) + new UUID(1,2).toString() +"."+extendFileName;
						File newFile = new File(updFilePath);
						
						FileInfo fileInfo = new FileInfo();
						fileInfo.setFILE_PATH(uploadDir + saveLocation(uploadDir));
						fileInfo.setREAL_NM(fileName);
						fileInfo.setFILE_SIZE(item.get().length);
						map.put(item.getFieldName(), fileInfo); 
						item.write(newFile); // 파일을 쓴다.
					}
				}
			}
		}
		return map;
	}
	
	private String getExtionFileName(String fileName) {
		int lastIndex = fileName.lastIndexOf(".");
		
		return fileName.substring(lastIndex+1);
	}
	
	private String saveLocation(File uploadDir) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String yyyy = sdf.format(date);
		
		File dir = new File(uploadDir.getAbsolutePath() + java.io.File.separator + yyyy);
		if(!dir.exists()) dir.mkdirs();
		
		sdf = new SimpleDateFormat("MM");
		String mm = sdf.format(date);
		
		dir = new File(uploadDir.getAbsolutePath() + java.io.File.separator + yyyy + java.io.File.separator + mm);
		if(!dir.exists()) dir.mkdirs();
		
		sdf = new SimpleDateFormat("dd");
		String dd = sdf.format(date);
		
		dir = new File(uploadDir.getAbsolutePath() + java.io.File.separator + yyyy + java.io.File.separator + mm + java.io.File.separator +  dd);
		if(!dir.exists()) dir.mkdirs();
		
		return java.io.File.separator + yyyy + java.io.File.separator + mm + java.io.File.separator + dd  + java.io.File.separator;
	}

	/**
	 * 
	 * request상의 param들을 map으로 반환한다.
	 * 
	 * @return Map
	 * 
	 */

	public Map<String, String> getParamMap() {
		return paramMap;
	}
}