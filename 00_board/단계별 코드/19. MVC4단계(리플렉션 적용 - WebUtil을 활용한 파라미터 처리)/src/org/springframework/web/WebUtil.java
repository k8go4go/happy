package org.springframework.web;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class WebUtil {
	
	/**
	 * 파라미터 정보를 VO에 자동 설정한다.
	 * 
	 * @return
	 */
	public static Object toVO(
			HttpServletRequest request,	Class<?> clz) 
					throws Exception {
		return setFromParamToVO(request, clz);
		/*
		// 메서드를 실행하기 위한 객체 생성
		Object obj = clz.newInstance();
		// 모든 메서드 조회
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			// mName = setUserId
			String mName = m.getName();

			// 메서드의 이름이 set으로 실행하는 메서드만 실행
			// mName = setUserId
			if (!mName.startsWith("set")) continue;
			
			// 메서드의 이름에서 set 제거
			// mName = UserId
			mName = mName.substring("set".length());
			
			// 메서드의 이름에서 첫글자를 소문자로 변환
			// mName = userId
			mName = Character.toLowerCase(mName.charAt(0)) 
				  + mName.substring(1);
			
			// 메서드의 이름에 해당하는 파라미터 값 조회
			String pValue = request.getParameter(mName);
			
			// set 메서드 이름에 해당하는 파라미터가 없을 경우
			if (pValue == null) continue;
			
			// set 메서드의 파라미터 타입을 조회해서 int 인 경우 파라미터의 값을 int로 변환
			String pTypeName = m.getParameterTypes()[0].getName();
			
			// pTypeName 이 int 라면 int로 변환 후 set 메서드 실행
			switch (pTypeName) {
			case "int":
				m.invoke(obj, Integer.parseInt(pValue));
				break;
			default:
				m.invoke(obj, pValue);
				break;
			}
		}
		return obj;
		*/
	}
	public static Object toVO(
			MultipartRequest request,	Class<?> clz) 
					throws Exception {
		
		return setFromParamToVO(request, clz);
		/*
		// 메서드를 실행하기 위한 객체 생성
		Object obj = clz.newInstance();
		// 모든 메서드 조회
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			// mName = setUserId
			String mName = m.getName();
			
			// 메서드의 이름이 set으로 실행하는 메서드만 실행
			// mName = setUserId
			if (!mName.startsWith("set")) continue;
			
			// 메서드의 이름에서 set 제거
			// mName = UserId
			mName = mName.substring("set".length());
			
			// 메서드의 이름에서 첫글자를 소문자로 변환
			// mName = userId
			mName = Character.toLowerCase(mName.charAt(0)) 
					+ mName.substring(1);
			
			// 메서드의 이름에 해당하는 파라미터 값 조회
			String pValue = request.getParameter(mName);
			
			// set 메서드 이름에 해당하는 파라미터가 없을 경우
			if (pValue == null) continue;
			
			// set 메서드의 파라미터 타입을 조회해서 int 인 경우 파라미터의 값을 int로 변환
			String pTypeName = m.getParameterTypes()[0].getName();
			
			// pTypeName 이 int 라면 int로 변환 후 set 메서드 실행
			switch (pTypeName) {
			case "int":
				m.invoke(obj, Integer.parseInt(pValue));
				break;
			default:
				m.invoke(obj, pValue);
				break;
			}
		}
		return obj;
		*/
	}
	
	private static Object setFromParamToVO(Object request, Class<?> clz) throws Exception {
		// 메서드를 실행하기 위한 객체 생성
		Object obj = clz.newInstance();
		// 모든 메서드 조회
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			String mName = m.getName();
			// 메서드의 이름이 set으로 실행하는 메서드만 실행
			if (!mName.startsWith("set")) continue;
			
			// 메서드의 이름에서 set 제거
			mName = mName.substring("set".length());
			
			// 메서드의 이름에서 첫글자를 소문자로 변환
			mName = Character.toLowerCase(mName.charAt(0)) + mName.substring(1);
			
			// 메서드의 이름에 해당하는 파라미터 값 조회
			String reqName = request.getClass().getSimpleName();
			String pValue = null;
			switch (reqName) {
			case "MultipartRequest":
				pValue = ((MultipartRequest)request).getParameter(mName);
				break;
			default:
				pValue = ((HttpServletRequest)request).getParameter(mName);
				break;
			}

			// set 메서드 이름에 해당하는 파라미터가 없을 경우
			if (pValue == null) continue;
			
			// set 메서드의 파라미터 타입을 조회해서 int 인 경우 파라미터의 값을 int로 변환
			String pTypeName = m.getParameterTypes()[0].getName();
			
			// pTypeName 이 int 라면 int로 변환 후 set 메서드 실행
			switch (pTypeName) {
			case "int":
				m.invoke(obj, Integer.parseInt(pValue));
				break;
			default:
				m.invoke(obj, pValue);
				break;
			}
		}
		return obj;
	}
}











