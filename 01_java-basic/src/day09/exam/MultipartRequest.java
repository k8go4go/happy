package day09.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MultipartRequest {
	
	private String key;
	private boolean isFile;
	private Scanner sc;
	private String fileName;
	
	int paramPos = 0;
	private ParamData[] paramArr = new ParamData[10];
	
	int multiPos = 0;
	private MultipartFile[] mfArr = new MultipartFile[10];
	
	// file content 내용 저장
	private StringBuffer sb = new StringBuffer();

	public MultipartRequest(String fileName) {
		try {
			this.fileName = fileName;
			parsing();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	// 파일 내용 파싱 시작..
	private void parsing() throws FileNotFoundException {
		sc = new Scanner(new File("iodata/day09/" + fileName));
		
		// Key 설정
		key = sc.nextLine();
		
		while (sc.hasNextLine()) {
			String data = sc.nextLine();
			if (data.equals(key + "--")) {
				addFileContent();
				return;
			}
			if (data.equals(key)) {
				addFileContent();
				continue;
			}
			if (data.contains("filename=")) {
				addFile(data);
				sc.nextLine(); // Content-Type 스킵
				sc.nextLine(); // 빈 공백 라인 스킵
				continue;
			} 
			else if (data.contains("name=")) {
				sc.nextLine(); // 빈 공백 라인 스킵
				addParam(data);
				continue;
			} 
			sb.append(data + "\n");
		}
	}
	
	// filename 이 없는 경우의 처리
	private void addParam(String data) {
		isFile = false;
		data = data.substring(data.indexOf("name=") + "name=".length() + 1, data.length() -1);
		paramArr[paramPos++] = new ParamData().setName(data)
				                              .setValue(sc.nextLine());
	}
	
	// filename 이 있는 경우의 처리
	private void addFile(String data) {
		isFile = true;
		data = data.substring(data.indexOf("filename=") + "filename=".length() + 1, data.length() -1);
		mfArr[multiPos++] = new MultipartFile().setName(data);
	}
	
	private void addFileContent() {
		if (isFile) {
			mfArr[multiPos - 1].setContent(sb.delete(sb.length() -1, sb.length()).toString());
		}
		sb.delete(0, sb.length());
	}
	
	public String getParameter(String name) {
		for (ParamData pd : paramArr) {
			if (pd.getName().equals(name)) return pd.getValue();
		}
		return "";
	}
	public MultipartFile[] getFiles() {
		return Arrays.copyOfRange(mfArr, 0, multiPos);
	}

}
