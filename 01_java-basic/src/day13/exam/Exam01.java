package day13.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam01 {
	public static void main(String[] args) {
		/*
		     설명
		     - 제주지역과 가장 가까운 순으로 출력하는 프로그램을 작성한다.
		     - 위치정보를 처리하기 위해서 위도와 경도를 활용한다.
		     - 특정 위치와의 거리를 측정하기 위해서 피타코라스의 정리를 활용
		       (두점사이의 거리를 구한다.)
		     - 정보를 표현하는 클래스 작성 : LocationVO  
		     - LocationVO("제주", 33.403931, 126.617432)
		       : 제주 - 지역명
		       : 33.403931 - 위도
		       : 126.617432 - 경도  
		       
		     출력결과 > 
		    
		     제주와 가까운 지역
			 1 : 안양
			 2 : 인천
			 3 : 춘천
		 */
		
		LocationVO jeju = new LocationVO("제주", 33.403931, 126.617432);
		LocationVO chun = new LocationVO("춘천", 37.857507, 127.727051);
		LocationVO ahn = new LocationVO("안양", 36.597889, 128.726807);
		LocationVO inchun = new LocationVO("인천", 37.474858, 126.727295);
		LocationVO.target = jeju;

		List<LocationVO> list = new ArrayList<LocationVO>();
		list.add(ahn);
		list.add(chun);
		list.add(inchun);

		// 코드 작성 추가...
		Collections.sort(list);
		
		System.out.println("제주와 가까운 지역");
		int num = 1;
		for (LocationVO location : list) {
			System.out.println(num++ + " : " + location.getRegionName());
		}		
	}
}
