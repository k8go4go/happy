package quiz;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import com.google.gson.Gson;

/*
 *  네이버 오픈 API 사용하기 : 번역 API
 */
public class Quiz02 {
	public static String translate(String koWord, int lang) {
        String clientId = "...";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "..";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode(koWord, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/language/translate";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            // post request
            String postParams = "source=ko&target=" + 
                                (lang == 1 ? "en" : lang == 2 ? "ja" : "zh-CN") + 
                                "&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            // {"message":
            //    {"@type":"response","@service":"naverservice.labs.api","@version":"1.0.0",
            //     "result":{"translatedText":"Nice to meet you."}}}
            Quiz02VO quiz = new Gson().fromJson(
            		response.toString(), Quiz02VO.class
            );
            return quiz.getMessage()
            		   .getResult()
            		   .getTranslatedText();
        } catch (Exception e) {
            System.out.println(e);
        }
		return "번역시 오류 발생함";
	}
	
    public static void main(String[] args) {
    	System.out.println("번역을 시작합니다.");
    	Scanner sc = new Scanner(System.in);
    	while (true) {
    		System.out.print("우리말(종료 quit) : ");
    		String koWord = sc.nextLine();
    		if ("quit".equalsIgnoreCase(koWord)) {
    			break;	
    		}
    		System.out.print("1. 영어   2. 일본어  3. 중국어  : ");
    		int lang = sc.nextInt(); sc.nextLine();
    		String result = translate(koWord, lang);
    		System.out.println("번역 : " + result);
    	}
    	System.out.println("프로그램을 종료합니다.");
    }
}










