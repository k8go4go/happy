package kr.heartof.constant;

public enum Code {
//	1000 	관리자구분코드
//	1001 	수퍼관리자
//	1002 	일반관리자
	ADMIN_CD ("1000", "관리자구분코드"),
	ADMIN_CD_SUPER("1001", "수퍼관리자"),
	ADMIN_CD_GENERAL("1002", "일반관리자"),
//1100	경고구분코드
//	1101. 경고 1번
//	1102. 경고 2번
//	1103. 그레이회원 등록
//	1104. 다크그레이 회원 등록
//	1105. 블랙 회원	
	WARN_CD ("1100", "경고구분코드"),
	WARN_CD_ONCE("1101", "경고 1번"),
	WARN_CD_TWICE("1102", "경고 2번"),
	WARN_CD_GRAY("1103", "그레이회원"),
	WARN_CD_DARKGRAY("1104", "다크그레이 회원"),
	WARN_CD_BLACK("1105", "블랙 회원"),
//1200	회원등급	
//	1201. 정회원
//	1202. 브론즈회원
//	1203. 실버회원
//	1204. 골드회원
//	1205. VIP 회원
//	1209. 블랙 회원 (멤버쉽 몰수)	
	MEMBER_DEG_CD ("1200", "회원등급"),
	MEMBER_DEG_GENERAL_CD("1201", "정회원"),
	MEMBER_DEG_BRONZE_CD("1202", "브론즈회원"),
	MEMBER_DEG_SIVER_CD("1203", "실버회원"),
	MEMBER_DEG_GOLD_CD("1204", "골드회원"),
	MEMBER_DEG_VIP_CD("1205", "VIP 회원"),
	MEMBER_DEG_BLACK_CD("1206", "블랙 회원 (멤버쉽 몰수)"),
//1300	회원신용등급
//	1301. 양호
//	1302. 불량	
	MEMBER_CRED_DEG_CD ("1300", "회원신용등급"),
	MEMBER_CRED_DEG_OK_CD("1301", "정회원"),
	MEMBER_CRED_DEG_FAIL_CD("1302", "브론즈회원"),
//1400	결제방법
//	1401. 온라인입금
//	1402. 멤버쉽포인트
//	1403. 전자지갑포인트
//	1404. 신용카드
//	1405. 직불카드
//	1406. 폰빌
	PAY_METH_CD ("1400", "결제방법"),
	PAY_METH_ONLINE_CD("1401", "온라인입금"),
	PAY_METH_MEMBERSHIP_CD("1402", "멤버쉽포인트"),
	PAY_METH_ELECWALLET_CD("1403", "전자지갑포인트"),
	PAY_METH_CREDITCARD_CD("1404", "신용카드"),
	PAY_METH_DIRECLYCARD_CD("1405", "직불카드"),
	PAY_METH_PHONEBILL_CD("1406", "폰빌"),
//1500	경매등록승인
//	1501 승인
//	1502 거부
	REG_AUC_APPROVAL_CD ("1500", "경매등록승인"),
	REG_AUC_APPROVAL_Y_CD("1501", "승인"),
	REG_AUC_APPROVAL_N_CD("1502", "거부"),
	REG_AUC_APPROVAL_ING_CD("1503", "대기중"),
// 1600 상품수령/미수령
//	1601. 수령
//	1602. 미수령	
	PRODUCT_RECEIVE_CD ("1600", "상품수령/미수령"),
	PRODUCT_RECEIVE_Y_CD("1601", "수령"),
	PRODUCT_RECEIVE_N_CD("1602", "미수령"),
//1700 회원탈퇴구분
//	1701. 탈퇴
//	1702. 회원
	WITHDRAWAL_CD ("1700", "상품수령/미수령"),
	WITHDRAWAL_Y_CD("1701", "탈퇴"),
	WITHDRAWAL_N_CD("1702", "회원"),
//1800 경매유형
//	1801. 순경매
//	1802. 역경매
//	1803. 더치경매
//	1804. 쌍방향경매	
	AUCTION_CD ("1800", "경매유형"),
	AUCTION_NATURAL_CD("1801", "순경매"),
	AUCTION_REVERSE_CD("1802", "역경매"),
	AUCTION_DUTCH_CD("1803", "더치경매"),
	AUCTION_INTERACTIVE_CD("1804", "쌍방향경매"),
// 1900 이메일유형
//	1901. daum.net
//	1902. naver.com
//	1903. google.com
//	1904. nate.com
//	1905. empas.com	
	EMAIL_CD ("1900", "이메일유형"),
	EMAIL_DAUM_CD("1901", "daum.net"),
	EMAIL_NAVER_CD("1902", "naver.com"),
	EMAIL_GOOGLE_CD("1903", "google.com"),
	EMAIL_NATE_CD("1904", "nate.com"),
	EMAIL_EMPAS_CD("1905", "empas.com"),
	EMAIL_DIRECT_CD("1906", "직접입력"),
//2000 회원구분
//	2001 개인
//	2002 기업	
	MEMBER_CD ("2000", "회원구분"),
	MEMBER_PRI_CD("2001", "개인"),
	MEMBER_COM_CD("2002", "기업"),
//2100 질문답변
//	2101 답변완료
//	2102 답변중
	QNA_CD ("2100", "질문답변"),
	QNA_COMPLETE_CD("2101", "답변완료"),
	QNA_ING_CD("2102", "답변중"),
/*	2200	카테고리사용구분
	2201	사용
	2202	미사용*/
	PROD_CATE_CD ("2200", "카테고리사용구분"),
	PROD_CATE_Y_CD("2201", "사용"),
	PROD_CATE_N_CD("2202", "미사용"),
	
	
	AUC_ING_CD ("2300", "경매진행여부"),
	AUC_APPR_ING_CD("2301", "심사중"),
	AUC_START_BEFORE_CD("2302", "경매시작전"),
	AUC_START_ING_CD("2303", "경매시작"),
	AUC_END_CD("2304", "경매종료"),
	AUC_BIDDED_CD("2305", "낙찰"),
	AUC_NO_BIDDED_CD("2306", "낙찰없음"),
	
/*	9900 검색구분코드
	9901 작성자
	9902 제목*/	
	SEARCH_CD ("9900", "검색구분코드"),
	SEARCH_WRITER_CD("9901", "작성자"),
	SEARCH_TITLE_CD("9902", "제목");
	
	
	private String key;
	private String value;
	
	private Code(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
