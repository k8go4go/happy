/* 회원번호 시퀀스 */
CREATE SEQUENCE usr_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 관리자번호 시퀀스 */
CREATE SEQUENCE mgr_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 게시판번호 시퀀스 */
CREATE SEQUENCE board_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 경매 등록 시퀀스 */
CREATE SEQUENCE reg_auc_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 첨부파일 시퀀스 */
CREATE SEQUENCE atta_file_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 상품첨부파일 시퀀스 */
CREATE SEQUENCE prod_file_seq;

/* 경매 첨부 파일 시퀀스 */
CREATE SEQUENCE auc_file_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 입찰 시퀀스 */
CREATE SEQUENCE bid_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 입찰 등록 시퀀스 */
CREATE SEQUENCE bid_reg_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 결재 시퀀스 */
CREATE SEQUENCE pay_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 배송 시퀀스 */
CREATE SEQUENCE deli_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* 회원 */
CREATE TABLE USR (
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	MEMB_ID VARCHAR(50) NOT NULL, /* 회원ID  */
	SEC_NUM VARCHAR(50) NOT NULL, /* 비밀번호 */
	EMAIL VARCHAR2(40) NOT NULL, /* 이메일  */
	TEL_NUM VARCHAR2(30) NOT NULL, /* 전화번호 */
	MOBIL_NUM VARCHAR(13) NOT NULL, /* 핸드폰번호 */
	ZIP_NUM VARCHAR(6) NOT NULL, /* 우편번호  */
	ADDRESS VARCHAR2(255) NOT NULL, /* 주소  */
	DETA_ADDRESS VARCHAR(255) NOT NULL, /* 상세주소 */
	REG_DTIME DATE DEFAULT sysdate NOT NULL, /* 등록일시 */
	MEMB_CD CHAR(4), /* 회원구분 */
	WITHDRAWAL_CD CHAR(4), /* 탈퇴구분  */
	CRE_DEG_CD CHAR(4), /* 신용등급구분  */
	MAIL_CD CHAR(4) /* 구분 */
);

CREATE UNIQUE INDEX PK_USR
	ON USR (
		MEMB_NUM ASC
	);

CREATE INDEX FK_CD_TO_USR
	ON USR (
		MEMB_CD ASC
	);

CREATE INDEX FK_CD_TO_USR2
	ON USR (
		WITHDRAWAL_CD ASC
	);

CREATE INDEX FK_CD_TO_USR3
	ON USR (
		CRE_DEG_CD ASC
	);

CREATE INDEX FK_CD_TO_USR4
	ON USR (
		MAIL_CD ASC
	);

CREATE UNIQUE INDEX UIX_USR
	ON USR (
		MEMB_ID ASC
	);

ALTER TABLE USR
	ADD
		CONSTRAINT PK_USR
		PRIMARY KEY (
			MEMB_NUM
		);

ALTER TABLE USR
	ADD
		CONSTRAINT UK_USR
		UNIQUE (
			MEMB_ID
		);

/* 개인회원 */
CREATE TABLE PRI_USR (
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	NM VARCHAR(50) NOT NULL, /* 이름 */
	SOC_REG_NUM VARCHAR2(13) NOT NULL /* 주민등록번호 */
);

CREATE UNIQUE INDEX PK_PRI_USR
	ON PRI_USR (
		MEMB_NUM ASC
	);

CREATE INDEX IX_PRI_USR
	ON PRI_USR (
		NM ASC,
		SOC_REG_NUM ASC
	);

ALTER TABLE PRI_USR
	ADD
		CONSTRAINT PK_PRI_USR
		PRIMARY KEY (
			MEMB_NUM
		);

/* 기업회원 */
CREATE TABLE COM_USR (
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	CORP_NM VARCHAR(50) NOT NULL, /* 회사이름 */
	BUS_NUM VARCHAR2(10), /* 사업자등록번호 */
	CEO_NM VARCHAR(50) NOT NULL, /* 대표자이름 */
	CHGR_NM VARCHAR(50) NOT NULL /* 담당자이름 */
);

CREATE UNIQUE INDEX PK_COM_USR
	ON COM_USR (
		MEMB_NUM ASC
	);

CREATE INDEX FK_USR_TO_COM_USR
	ON COM_USR (
		MEMB_NUM ASC
	);

CREATE INDEX IX_COM_USR
	ON COM_USR (
		CORP_NM ASC
	);

CREATE INDEX IX_COM_USR2
	ON COM_USR (
		CORP_NM ASC,
		BUS_NUM ASC,
		CEO_NM ASC
	);

ALTER TABLE COM_USR
	ADD
		CONSTRAINT PK_COM_USR
		PRIMARY KEY (
			MEMB_NUM
		);

/* 관리회원 */
CREATE TABLE MGR (
	MGR_NUM INTEGER NOT NULL, /* 관리자번호  */
	MGR_NM VARCHAR(50) NOT NULL, /* 관리자이름 */
	MEMB_ID VARCHAR(50) NOT NULL, /* 회원ID  */
	SEC_NUM VARCHAR(50) NOT NULL, /* 비밀번호 */
	EMAIL VARCHAR2(40) NOT NULL, /* 이메일  */
	TEL_NUM VARCHAR2(30) NOT NULL, /* 전화번호  */
	MOBIL_NUM VARCHAR(13) NOT NULL, /* 핸드폰번호  */
	REG_DTIME DATE DEFAULT sysdate NOT NULL, /* 등록일시 */
	HIGH_MGR_NUM INTEGER, /* 상위관리자번호 */
	MEMB_CD CHAR(4), /* 회원구분 */
	MAIL_CD CHAR(4) /* 구분 */
);

CREATE UNIQUE INDEX PK_MGR
	ON MGR (
		MGR_NUM ASC
	);

CREATE INDEX FK_MGR_TO_MGR
	ON MGR (
		HIGH_MGR_NUM ASC
	);

CREATE INDEX FK_CD_TO_MGR
	ON MGR (
		MEMB_CD ASC
	);

CREATE INDEX FK_CD_TO_MGR2
	ON MGR (
		MAIL_CD ASC
	);

ALTER TABLE MGR
	ADD
		CONSTRAINT PK_MGR
		PRIMARY KEY (
			MGR_NUM
		);

/* 멤버쉽 */
CREATE TABLE MEMBERSHIP (
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	MSHIP_CARD_NUM VARCHAR(16) NOT NULL, /* 멤버쉽카드번호 */
	NM VARCHAR2(50) NOT NULL, /* 이름 */
	POINT INTEGER NOT NULL, /* 포인트 */
	ISSUE_DATE DATE NOT NULL, /* 발급일시 */
	ISSUE_CNT SMALLINT DEFAULT 1 NOT NULL, /* 발급회수 */
	DEG CHAR(4) /* 등급 */
);

CREATE UNIQUE INDEX PK_MEMBERSHIP
	ON MEMBERSHIP (
		MEMB_NUM ASC
	);

CREATE INDEX FK_USR_TO_MEMBERSHIP
	ON MEMBERSHIP (
		MEMB_NUM ASC
	);

CREATE INDEX FK_CD_TO_MEMBERSHIP
	ON MEMBERSHIP (
		DEG ASC
	);

CREATE UNIQUE INDEX UIX_MEMBERSHIP
	ON MEMBERSHIP (
		MSHIP_CARD_NUM ASC
	);

ALTER TABLE MEMBERSHIP
	ADD
		CONSTRAINT PK_MEMBERSHIP
		PRIMARY KEY (
			MEMB_NUM
		);

ALTER TABLE MEMBERSHIP
	ADD
		CONSTRAINT UK_MEMBERSHIP
		UNIQUE (
			MSHIP_CARD_NUM
		);

/* 전자지갑 */
CREATE TABLE ELEC_WALLET (
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	POINT INTEGER DEFAULT 100000 NOT NULL /* 포인트 */
);

COMMENT ON COLUMN ELEC_WALLET.POINT IS '회원 첫가입 100000 Point';

CREATE UNIQUE INDEX PK_ELEC_WALLET
	ON ELEC_WALLET (
		MEMB_NUM ASC
	);

ALTER TABLE ELEC_WALLET
	ADD
		CONSTRAINT PK_ELEC_WALLET
		PRIMARY KEY (
			MEMB_NUM
		);

/* 게시판 */
CREATE TABLE BOARD (
	BOARD_NUM INTEGER NOT NULL, /* 게시판번호 */
	TITLE VARCHAR2(100) NOT NULL, /* 제목 */
	CONT NVARCHAR2(2000) NOT NULL, /* 내용 */
	WRITER_NM VARCHAR(50) NOT NULL, /* 작성자이름  */
	WRITE_DATE DATE DEFAULT sysdate NOT NULL, /* 작성일시 */
	REVIEW_CNT INTEGER DEFAULT 0 NOT NULL, /* 조회수  */
	HIGH_BOARD_NUM INTEGER, /* 상위게시판번호 */
	MEMB_NUM INTEGER, /* 회원번호  */
	QUES_CD CHAR(4) /* 질문구분 */
);

CREATE UNIQUE INDEX PK_BOARD
	ON BOARD (
		BOARD_NUM ASC
	);

CREATE INDEX FK_BOARD_TO_BOARD
	ON BOARD (
		HIGH_BOARD_NUM ASC
	);

CREATE INDEX FK_USR_TO_BOARD
	ON BOARD (
		MEMB_NUM ASC
	);

CREATE INDEX IX_BOARD
	ON BOARD (
		TITLE ASC
	);

CREATE INDEX IX_BOARD2
	ON BOARD (
		CONT ASC
	);

CREATE INDEX IX_BOARD3
	ON BOARD (
		WRITER_NM ASC
	);

ALTER TABLE BOARD
	ADD
		CONSTRAINT PK_BOARD
		PRIMARY KEY (
			BOARD_NUM
		);

/* 첨부파일 */
CREATE TABLE ATTAC_FILE (
	ATTAC_FILE_NUM INTEGER NOT NULL, /* 첨부파일번호 */
	FILE_NM VARCHAR(100) NOT NULL, /* 파일이름  */
	FILE_PATH VARCHAR(255) NOT NULL, /* 파일경로  */
	REAL_NM VARCHAR(100) NOT NULL, /* 실제이름 */
	FILE_SIZE INTEGER NOT NULL, /* 파일사이즈 */
	BOARD_NUM INTEGER /* 게시판번호 */
);

COMMENT ON COLUMN ATTAC_FILE.FILE_SIZE IS '파일 사이즈 10M 이하';

CREATE UNIQUE INDEX PK_ATTAC_FILE
	ON ATTAC_FILE (
		ATTAC_FILE_NUM ASC
	);

CREATE INDEX FK_BOARD_TO_ATTAC_FILE
	ON ATTAC_FILE (
		BOARD_NUM ASC
	);

ALTER TABLE ATTAC_FILE
	ADD
		CONSTRAINT PK_ATTAC_FILE
		PRIMARY KEY (
			ATTAC_FILE_NUM
		);

ALTER TABLE ATTAC_FILE
	ADD
		CONSTRAINT CK_ATTAC_FILE
		CHECK (FILE_SIZE between 1 and 1000000);

/* 상품분류 */
CREATE TABLE PROD_CATE (
	PROD_CATE_NUM CHAR(4) NOT NULL, /* 상품분류코드 */
	PROD_CATE_NM VARCHAR(50) NOT NULL, /* 상품분류명 */
	SHORT_CONT VARCHAR(255) NOT NULL, /* 상품분류설명 */
	HIGH_PROD_CATE_NUM CHAR(4), /* 상위상품분류코드 */
	USE_CD CHAR(4) /* 사용구분 */
);

COMMENT ON COLUMN PROD_CATE.PROD_CATE_NUM IS '1000	패션의류/잡화		
	1100	여성패션	
		1101	티셔츠
		1102	맨투맨/후드집업
		1103	블라우스/셔츠
		1104	원피스/정장세트
		1105	니트류/조끼
		1106	바지/레깅스
		1107	스커트/치마
		1108	아우터
		1109	패션운동복
		1110	비키니/비치웨어
		1111	빅사이즈 의류
		1112	속옷/잠옷
		1113	커플룩/패밀리룩
		1114	임부복
		1115	한복/파티복
		1116	신발
		1117	가방/잡화
		1118	해외직구
	1200	남성패션	
		1201	티셔츠
		1202	맨투맨
		1203	셔츠
		1204	바지
		1205	트레이닝
		1206	후드집업/집업류
		1207	스웨터
		1208	가디건
		1209	베스트/조끼
		1210	아우터
		1211	속옷/잠옷
		1212	빅사이즈 의류
		1213	패션 래쉬가드
		1214	커플룩/패밀리룩
		1215	한복/코스튬
		1216	신발
		1217	가방/잡화
		1218	해외직구
	1300	 스포츠패션	
		1301	여성스포츠의류
		1302	남성스포츠의류
		1303	남녀스포츠의류
		1304	스포츠슈즈
		1305	스포츠잡화
		1306	유아동스포츠패션
	1400	신발	
		1401	스니커즈/슬립온
		1402	운동화/런닝화
		1403	여성단화/플랫
		1404	여성하이힐
		1405	여성워커/부츠
		1406	여성샌들/쪼리
		1407	남성로퍼/웰트화
		1408	남성정장구두
		1409	남성워커/부츠
		1410	남성샌들/쪼리
		1411	슬리퍼/실내화
		1412	기능화
		1413	깔창/신발끈
		1414	신발관리용품
		1415	해외직구
	1500	가방/잡화	
		1501	여성가방
		1502	남성가방
		1503	남녀캐주얼가방
		1504	여행가방/소품
		1505	지갑/벨트
		1506	양말/스타킹
		1507	머플러/스카프/숄
		1508	모자
		1509	장갑/시즌잡화
		1510	넥타이/소품
		1511	우산/양산/우비
		1512	아이웨어
		1513	시계
		1514	쥬얼리
		1515	해외직구
	1600	명품패션	
		1601	여성의류
		1602	남성의류
		1603	속옷
		1604	신발
		1605	가방
		1606	지갑
		1607	시계/쥬얼리
		1608	벨트
		1609	모자
		1610	스카프/머플러
		1611	안경테/선글라스
		1612	넥타이
		1613	기타패션잡화
2000	뷰티		
	2100	스킨케어	
		2101	기초화장품
		2102	클렌징/필링
		2103	마스크/팩
		2104	선케어/태닝
	2200	메이크업	
		2201	아이 메이크업
		2202	립 메이크업
		2203	베이스 메이크업
		2204	치크/기타 메이크업
	2300	향수	
		2301	여성향수
		2302	남성향수
		2303	드레스퍼퓸
	2400	헤어	
		2401	샴푸/린스
		2402	트리트먼트/팩
		2403	스타일링/케어/세트
		2404	염색/파마
	2500	바디	
		2501	샤워/입욕용품
		2502	바디로션/크림
		2503	핸드/풋/데오
		2504	제모/슬리밍/청결제
	2600	네일	
		2601	큐티클/영양
		2602	일반네일
		2603	젤네일
		2604	네일케어도구
		2605	네일아트소품/도구
		2606	네일세트
	2700	남성화장품	
		2701	남성스킨케어
		2702	남성메이크업
		2703	남성화장품세트
		2704	남성 헤어케어
		2705	남성 바디케어
		2706	남성 쉐이빙 케어
	2800	명품화장품	
		2801	스킨케어
		2802	메이크업
		2803	향수
		2804	헤어케어
		2805	바디케어
		2806	남성화장품
		2807	뷰티소품
	2900	헬스화장품	
		2901	스킨케어
		2902	페이스메이크업
		2903	립케어
		2904	헤어케어
		2905	바디케어
		2906	세트
		2907	뷰티소품
3000	식품		
	3100	유기농/친환경 전문관	
		3101	과일
		3102	견과/건과
		3103	채소
		3104	쌀/잡곡
		3105	축산/계란
		3106	수산물/건어물
		3107	음료
		3108	유제품/두유
		3109	커피/원두/차
		3110	과자/시리얼
		3111	면/통조림/가공식품
		3112	가루/조미료/오일
		3113	장/소스/드레싱/식초
	3200	과일	
		3201	사과/배
		3202	귤/한라봉/감귤류
		3203	감/홍시/곶감
		3204	키위/참다래
		3205	토마토/자두/복숭아/포도
		3206	수박/메론/참외
		3207	딸기/블루베리/베리류
		3208	바나나/오렌지/파인애플
		3209	자몽/레몬/라임/석류
		3210	망고/체리/아보카도/기타
		3211	냉동과일/간편과일
		3212	과일가루
		3213	과일선물세트
	3300	견과/건과	
		3301	땅콩/호두
		3302	밤/잣/은행
		3303	아몬드/피스타치오
		3304	기타견과류
		3305	호박씨/해바라기씨
		3306	기타씨앗
		3307	혼합견과/세트
		3308	건과일/건채소
	3400	채소	
		3401	두부/콩나물
		3402	감자/고구마
		3403	당근/뿌리채소
		3404	오이/고추/열매채소
		3405	양파/마늘/파
		3406	배추/무/김장채소
		3407	시금치/나물/잎줄기채소
		3408	상추/깻잎/쌈채소
		3409	샐러드/손질채소
		3410	새송이/버섯류
		3411	인삼/건강차재료
		3412	기타채소
		3413	건나물/건채소
	3500	쌀/잡곡	
		3501	백미
		3502	현미/찹쌀/흑미
		3503	기능성쌀/기타쌀
		3504	콩/팥/보리
		3505	조/수수/깨
		3506	기타잡곡/혼합곡
		3507	슈퍼곡물
		3508	기타씨앗
		3509	쌀/잡곡 가루
		3510	곡류선물세트
	3600	축산/계란	
		3601	소고기
		3602	돼지고기
		3603	닭/오리고기
		3604	양/말고기
		3605	기타 육고기
		3606	계란/알류/가공란
		3607	축산선물세트
	3700	수산물/건어물	
		3701	생선
		3702	오징어/낙지/연체류
		3703	새우/게/갑각류
		3704	전복/굴/조개류
		3705	멸치/천연조미료
		3706	김/미역/해조류
		3707	건오징어/쥐포/어포
		3708	황태/진미채
		3709	생선알
		3710	기타수산물/건어물
		3711	수산물선물세트
	3800	생수/음료	
		3801	생수/탄산수
		3802	과일/야채음료
		3803	탄산/스포츠음료
		3804	커피음료/차음료
		3805	두유
		3806	일반우유
		3807	멸균우유
		3808	숙취/건강음료
		3809	유아음료
		3810	기타주스/음료
		3811	음료선물세트
	3900	건강식품	
		3901	비타민/영양제
		3902	홍삼/인삼
		3903	헬스/다이어트식품
		3904	영양식/선식
		3905	꿀/로얄젤리
		3906	건강차 원물
		3907	건강분말/건강환
		3908	한방재료
		3909	임산부식품
		3910	유아건강식품
4000	전자제품		
	4100	노트북/PC/태블릿	
		4101	노트북
		4102	노트북용 액세서리
		4103	데스크탑
		4104	PC 중고/리퍼비시
		4105	태블릿 PC
		4106	태블릿PC 액세서리
	4200	저장장치/공유기	
		4201	외장하드/NAS
		4202	HDD
		4203	SSD
		4204	ODD/공디스크
		4205	USB메모리
		4206	메모리카드/카드리더
		4207	공유기/랜카드
		4208	네트워크장비
		4209	CCTV/IP카메라
	4300	모니터/프린터	
		4301	모니터
		4302	모니터 주변기기
		4303	프린터/복합기
		4304	스캐너
		4305	복사기
		4306	POS/바코드스캔
		4307	잉크/토너
	4400	PC부품/주변기기	
		4401	마우스/키보드
		4402	스피커/헤드셋/웹캠
		4403	CPU
		4404	램(RAM)
		4405	그래픽/TV카드
		4406	메인보드/확장카드
		4407	케이스/파워
		4408	USB허브/케이블/젠더
		4409	멀티탭/PC관리용품
		4410	쿨러
		4411	소프트웨어
	4500	휴대폰/액세서리	
		4501	휴대폰 케이스
		4502	휴대폰 액세서리
		4503	배터리/충전/케이블
		4504	스마트워치/밴드
		4505	태블릿 PC
		4506	태블릿PC 액세서리
		4507	메모리카드/리더기
		4508	휴대폰
	4600	음향기기/이어폰	
		4601	이어폰
		4602	헤드폰
		4603	스피커
		4604	홈시어터/오디오
		4605	라디오/카세트/MP3
		4606	녹음/어학/사전
		4607	PA/마이크/레코딩
		4608	음향 액세서리
	4700	TV/영상가전	
		4701	TV
		4702	TV 액세서리
		4703	블루레이/DVD/DivX
		4704	빔/프로젝터/스크린
	4800	카메라/캠코더	
		4801	DSLR
		4802	DSLR 렌즈
		4803	미러리스
		4804	미러리스 렌즈
		4805	하이엔드/컴팩트
		4806	카메라 액세서리
		4807	액션캠/캠코더
		4808	즉석/기타카메라
		4809	포토프린터/용지
		4810	중고/리퍼/병행
	4900	냉장고/김치냉장고	
		4901	냉장고
		4902	김치냉장고
5000	자동차용품		
	5100	실내용품	
		5101	인테리어용품
		5102	차량용수납용품
		5103	차량용편의용품
	5200	실외용품/익스테리어	
		5201	와이퍼
		5202	스티커/엠블럼
		5203	안테나/볼
		5204	주유구캡/혼유방지링
		5205	번호판 액세서리
		5206	썬바이저/썬루프
		5207	몰딩/가드
		5208	미러용품
		5209	루프용품
		5210	캐리어용품
		5211	차량용 바디커버
	5300	세차/관리용품	
		5301	세차용품
		5302	관리용품
		5303	세차용품세트
	5400	매트/시트/쿠션	
		5401	차량용카매트
		5402	차량용시트/유아시트
		5403	차량용쿠션
		5404	차량용방석
		5405	쿠션방석세트
6000	티켓		
	6100	국내여행	
		6101	호텔
		6102	리조트
		6103	펜션
		6104	캠핑/글램핑
		6105	부티크 호텔/모텔
		6106	게스트하우스
		6107	테마파크/워터파크
		6108	레포츠/체험/골프
		6109	내륙테마여행
		6110	전국렌터카
		6111	제주여행
		6112	제주항공권
		6113	제주렌터카
	6200	해외여행	
		6201	특가 항공
		6202	실시간 항공 예약
		6203	특가 호텔
		6204	전세계 호텔 예약
		6205	관광지입장권/교통패스
		6206	일본
		6207	동남아시아
		6208	괌/사이판/호주
		6209	홍콩/마카오/대만
		6210	중국
		6211	유럽
		6212	미주/하와이
	6300	공연/전시/체험	
		6301	골든라운지
		6302	뮤지컬/콘서트
		6303	연극/영화
		6304	체험/전시
		6305	아동가족극
		6306	키즈카페/파크';

COMMENT ON COLUMN PROD_CATE.HIGH_PROD_CATE_NUM IS '1000	패션의류/잡화		
	1100	여성패션	
		1101	티셔츠
		1102	맨투맨/후드집업
		1103	블라우스/셔츠
		1104	원피스/정장세트
		1105	니트류/조끼
		1106	바지/레깅스
		1107	스커트/치마
		1108	아우터
		1109	패션운동복
		1110	비키니/비치웨어
		1111	빅사이즈 의류
		1112	속옷/잠옷
		1113	커플룩/패밀리룩
		1114	임부복
		1115	한복/파티복
		1116	신발
		1117	가방/잡화
		1118	해외직구
	1200	남성패션	
		1201	티셔츠
		1202	맨투맨
		1203	셔츠
		1204	바지
		1205	트레이닝
		1206	후드집업/집업류
		1207	스웨터
		1208	가디건
		1209	베스트/조끼
		1210	아우터
		1211	속옷/잠옷
		1212	빅사이즈 의류
		1213	패션 래쉬가드
		1214	커플룩/패밀리룩
		1215	한복/코스튬
		1216	신발
		1217	가방/잡화
		1218	해외직구
	1300	 스포츠패션	
		1301	여성스포츠의류
		1302	남성스포츠의류
		1303	남녀스포츠의류
		1304	스포츠슈즈
		1305	스포츠잡화
		1306	유아동스포츠패션
	1400	신발	
		1401	스니커즈/슬립온
		1402	운동화/런닝화
		1403	여성단화/플랫
		1404	여성하이힐
		1405	여성워커/부츠
		1406	여성샌들/쪼리
		1407	남성로퍼/웰트화
		1408	남성정장구두
		1409	남성워커/부츠
		1410	남성샌들/쪼리
		1411	슬리퍼/실내화
		1412	기능화
		1413	깔창/신발끈
		1414	신발관리용품
		1415	해외직구
	1500	가방/잡화	
		1501	여성가방
		1502	남성가방
		1503	남녀캐주얼가방
		1504	여행가방/소품
		1505	지갑/벨트
		1506	양말/스타킹
		1507	머플러/스카프/숄
		1508	모자
		1509	장갑/시즌잡화
		1510	넥타이/소품
		1511	우산/양산/우비
		1512	아이웨어
		1513	시계
		1514	쥬얼리
		1515	해외직구
	1600	명품패션	
		1601	여성의류
		1602	남성의류
		1603	속옷
		1604	신발
		1605	가방
		1606	지갑
		1607	시계/쥬얼리
		1608	벨트
		1609	모자
		1610	스카프/머플러
		1611	안경테/선글라스
		1612	넥타이
		1613	기타패션잡화
2000	뷰티		
	2100	스킨케어	
		2101	기초화장품
		2102	클렌징/필링
		2103	마스크/팩
		2104	선케어/태닝
	2200	메이크업	
		2201	아이 메이크업
		2202	립 메이크업
		2203	베이스 메이크업
		2204	치크/기타 메이크업
	2300	향수	
		2301	여성향수
		2302	남성향수
		2303	드레스퍼퓸
	2400	헤어	
		2401	샴푸/린스
		2402	트리트먼트/팩
		2403	스타일링/케어/세트
		2404	염색/파마
	2500	바디	
		2501	샤워/입욕용품
		2502	바디로션/크림
		2503	핸드/풋/데오
		2504	제모/슬리밍/청결제
	2600	네일	
		2601	큐티클/영양
		2602	일반네일
		2603	젤네일
		2604	네일케어도구
		2605	네일아트소품/도구
		2606	네일세트
	2700	남성화장품	
		2701	남성스킨케어
		2702	남성메이크업
		2703	남성화장품세트
		2704	남성 헤어케어
		2705	남성 바디케어
		2706	남성 쉐이빙 케어
	2800	명품화장품	
		2801	스킨케어
		2802	메이크업
		2803	향수
		2804	헤어케어
		2805	바디케어
		2806	남성화장품
		2807	뷰티소품
	2900	헬스화장품	
		2901	스킨케어
		2902	페이스메이크업
		2903	립케어
		2904	헤어케어
		2905	바디케어
		2906	세트
		2907	뷰티소품
3000	식품		
	3100	유기농/친환경 전문관	
		3101	과일
		3102	견과/건과
		3103	채소
		3104	쌀/잡곡
		3105	축산/계란
		3106	수산물/건어물
		3107	음료
		3108	유제품/두유
		3109	커피/원두/차
		3110	과자/시리얼
		3111	면/통조림/가공식품
		3112	가루/조미료/오일
		3113	장/소스/드레싱/식초
	3200	과일	
		3201	사과/배
		3202	귤/한라봉/감귤류
		3203	감/홍시/곶감
		3204	키위/참다래
		3205	토마토/자두/복숭아/포도
		3206	수박/메론/참외
		3207	딸기/블루베리/베리류
		3208	바나나/오렌지/파인애플
		3209	자몽/레몬/라임/석류
		3210	망고/체리/아보카도/기타
		3211	냉동과일/간편과일
		3212	과일가루
		3213	과일선물세트
	3300	견과/건과	
		3301	땅콩/호두
		3302	밤/잣/은행
		3303	아몬드/피스타치오
		3304	기타견과류
		3305	호박씨/해바라기씨
		3306	기타씨앗
		3307	혼합견과/세트
		3308	건과일/건채소
	3400	채소	
		3401	두부/콩나물
		3402	감자/고구마
		3403	당근/뿌리채소
		3404	오이/고추/열매채소
		3405	양파/마늘/파
		3406	배추/무/김장채소
		3407	시금치/나물/잎줄기채소
		3408	상추/깻잎/쌈채소
		3409	샐러드/손질채소
		3410	새송이/버섯류
		3411	인삼/건강차재료
		3412	기타채소
		3413	건나물/건채소
	3500	쌀/잡곡	
		3501	백미
		3502	현미/찹쌀/흑미
		3503	기능성쌀/기타쌀
		3504	콩/팥/보리
		3505	조/수수/깨
		3506	기타잡곡/혼합곡
		3507	슈퍼곡물
		3508	기타씨앗
		3509	쌀/잡곡 가루
		3510	곡류선물세트
	3600	축산/계란	
		3601	소고기
		3602	돼지고기
		3603	닭/오리고기
		3604	양/말고기
		3605	기타 육고기
		3606	계란/알류/가공란
		3607	축산선물세트
	3700	수산물/건어물	
		3701	생선
		3702	오징어/낙지/연체류
		3703	새우/게/갑각류
		3704	전복/굴/조개류
		3705	멸치/천연조미료
		3706	김/미역/해조류
		3707	건오징어/쥐포/어포
		3708	황태/진미채
		3709	생선알
		3710	기타수산물/건어물
		3711	수산물선물세트
	3800	생수/음료	
		3801	생수/탄산수
		3802	과일/야채음료
		3803	탄산/스포츠음료
		3804	커피음료/차음료
		3805	두유
		3806	일반우유
		3807	멸균우유
		3808	숙취/건강음료
		3809	유아음료
		3810	기타주스/음료
		3811	음료선물세트
	3900	건강식품	
		3901	비타민/영양제
		3902	홍삼/인삼
		3903	헬스/다이어트식품
		3904	영양식/선식
		3905	꿀/로얄젤리
		3906	건강차 원물
		3907	건강분말/건강환
		3908	한방재료
		3909	임산부식품
		3910	유아건강식품
4000	전자제품		
	4100	노트북/PC/태블릿	
		4101	노트북
		4102	노트북용 액세서리
		4103	데스크탑
		4104	PC 중고/리퍼비시
		4105	태블릿 PC
		4106	태블릿PC 액세서리
	4200	저장장치/공유기	
		4201	외장하드/NAS
		4202	HDD
		4203	SSD
		4204	ODD/공디스크
		4205	USB메모리
		4206	메모리카드/카드리더
		4207	공유기/랜카드
		4208	네트워크장비
		4209	CCTV/IP카메라
	4300	모니터/프린터	
		4301	모니터
		4302	모니터 주변기기
		4303	프린터/복합기
		4304	스캐너
		4305	복사기
		4306	POS/바코드스캔
		4307	잉크/토너
	4400	PC부품/주변기기	
		4401	마우스/키보드
		4402	스피커/헤드셋/웹캠
		4403	CPU
		4404	램(RAM)
		4405	그래픽/TV카드
		4406	메인보드/확장카드
		4407	케이스/파워
		4408	USB허브/케이블/젠더
		4409	멀티탭/PC관리용품
		4410	쿨러
		4411	소프트웨어
	4500	휴대폰/액세서리	
		4501	휴대폰 케이스
		4502	휴대폰 액세서리
		4503	배터리/충전/케이블
		4504	스마트워치/밴드
		4505	태블릿 PC
		4506	태블릿PC 액세서리
		4507	메모리카드/리더기
		4508	휴대폰
	4600	음향기기/이어폰	
		4601	이어폰
		4602	헤드폰
		4603	스피커
		4604	홈시어터/오디오
		4605	라디오/카세트/MP3
		4606	녹음/어학/사전
		4607	PA/마이크/레코딩
		4608	음향 액세서리
	4700	TV/영상가전	
		4701	TV
		4702	TV 액세서리
		4703	블루레이/DVD/DivX
		4704	빔/프로젝터/스크린
	4800	카메라/캠코더	
		4801	DSLR
		4802	DSLR 렌즈
		4803	미러리스
		4804	미러리스 렌즈
		4805	하이엔드/컴팩트
		4806	카메라 액세서리
		4807	액션캠/캠코더
		4808	즉석/기타카메라
		4809	포토프린터/용지
		4810	중고/리퍼/병행
	4900	냉장고/김치냉장고	
		4901	냉장고
		4902	김치냉장고
5000	자동차용품		
	5100	실내용품	
		5101	인테리어용품
		5102	차량용수납용품
		5103	차량용편의용품
	5200	실외용품/익스테리어	
		5201	와이퍼
		5202	스티커/엠블럼
		5203	안테나/볼
		5204	주유구캡/혼유방지링
		5205	번호판 액세서리
		5206	썬바이저/썬루프
		5207	몰딩/가드
		5208	미러용품
		5209	루프용품
		5210	캐리어용품
		5211	차량용 바디커버
	5300	세차/관리용품	
		5301	세차용품
		5302	관리용품
		5303	세차용품세트
	5400	매트/시트/쿠션	
		5401	차량용카매트
		5402	차량용시트/유아시트
		5403	차량용쿠션
		5404	차량용방석
		5405	쿠션방석세트
6000	티켓		
	6100	국내여행	
		6101	호텔
		6102	리조트
		6103	펜션
		6104	캠핑/글램핑
		6105	부티크 호텔/모텔
		6106	게스트하우스
		6107	테마파크/워터파크
		6108	레포츠/체험/골프
		6109	내륙테마여행
		6110	전국렌터카
		6111	제주여행
		6112	제주항공권
		6113	제주렌터카
	6200	해외여행	
		6201	특가 항공
		6202	실시간 항공 예약
		6203	특가 호텔
		6204	전세계 호텔 예약
		6205	관광지입장권/교통패스
		6206	일본
		6207	동남아시아
		6208	괌/사이판/호주
		6209	홍콩/마카오/대만
		6210	중국
		6211	유럽
		6212	미주/하와이
	6300	공연/전시/체험	
		6301	골든라운지
		6302	뮤지컬/콘서트
		6303	연극/영화
		6304	체험/전시
		6305	아동가족극
		6306	키즈카페/파크';

CREATE UNIQUE INDEX PK_PROD_CATE
	ON PROD_CATE (
		PROD_CATE_NUM ASC
	);

CREATE INDEX FK_PROD_CATE_TO_PROD_CATE
	ON PROD_CATE (
		HIGH_PROD_CATE_NUM ASC
	);

ALTER TABLE PROD_CATE
	ADD
		CONSTRAINT PK_PROD_CATE
		PRIMARY KEY (
			PROD_CATE_NUM
		);

/* 신용경고 */
CREATE TABLE CRE_WARN (
	WARN_NUM INTEGER NOT NULL, /* 경고번호 */
	WARN_NM VARCHAR(50) NOT NULL, /* 경고명  */
	WARN_CONT VARCHAR(255) NOT NULL, /* 경고내용  */
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	WARN_CD CHAR(4) /* 경고구분 */
);

CREATE UNIQUE INDEX PK_CRE_WARN
	ON CRE_WARN (
		WARN_NUM ASC
	);

CREATE INDEX FK_USR_TO_CRE_WARN
	ON CRE_WARN (
		MEMB_NUM ASC
	);

CREATE INDEX FK_CD_TO_CRE_WARN
	ON CRE_WARN (
		WARN_CD ASC
	);

ALTER TABLE CRE_WARN
	ADD
		CONSTRAINT PK_CRE_WARN
		PRIMARY KEY (
			WARN_NUM
		);

/* 경매등록상품 */
CREATE TABLE REG_AUC (
	AUC_REG_NUM INTEGER NOT NULL, /* 경매등록번호 */
	AUC_PROD_NM VARCHAR(50) NOT NULL, /* 경매상품명 */
	SHORT_CONT NVARCHAR2(2000) NOT NULL, /* 경매상품설명 */
	REG_DTIME DATE DEFAULT sysdate NOT NULL, /* 등록일시 */
	START_DTIME DATE NOT NULL, /* 시작일시 */
	END_DTIME DATE NOT NULL, /* 종료일시 */
	START_PRICE INTEGER NOT NULL, /* 시작가 */
	QTY SMALLINT NOT NULL, /* 수량 */
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	PROD_CATE_NUM CHAR(4), /* 상품분류코드 */
	APPR_CD CHAR(4), /* 승인구분 */
	AUC_TYPE_NUM CHAR(4) /* 경매유형번호 */
);

CREATE UNIQUE INDEX PK_REG_AUC
	ON REG_AUC (
		AUC_REG_NUM ASC
	);

CREATE INDEX FK_USR_TO_REG_AUC
	ON REG_AUC (
		MEMB_NUM ASC
	);

CREATE INDEX FK_PROD_CATE_TO_REG_AUC
	ON REG_AUC (
		PROD_CATE_NUM ASC
	);

CREATE INDEX FK_CD_TO_REG_AUC
	ON REG_AUC (
		APPR_CD ASC
	);

CREATE INDEX FK_CD_TO_REG_AUC2
	ON REG_AUC (
		AUC_TYPE_NUM ASC
	);

CREATE INDEX IX_REG_AUC
	ON REG_AUC (
		START_DTIME ASC,
		END_DTIME ASC
	);

CREATE INDEX IX_REG_AUC2
	ON REG_AUC (
		START_PRICE ASC
	);

CREATE INDEX IX_REG_AUC3
	ON REG_AUC (
		AUC_PROD_NM ASC
	);

ALTER TABLE REG_AUC
	ADD
		CONSTRAINT PK_REG_AUC
		PRIMARY KEY (
			AUC_REG_NUM
		);

/* 등록거부 */
CREATE TABLE REG_REJ (
	AUC_REG_NUM INTEGER NOT NULL, /* 경매등록번호 */
	REG_REJ_REAS VARCHAR(255) NOT NULL /* 등록거부사유 */
);

CREATE UNIQUE INDEX PK_REG_REJ
	ON REG_REJ (
		AUC_REG_NUM ASC
	);

ALTER TABLE REG_REJ
	ADD
		CONSTRAINT PK_REG_REJ
		PRIMARY KEY (
			AUC_REG_NUM
		);

/* 입찰 */
CREATE TABLE REG_BIDDING (
	BID_NUM INTEGER NOT NULL, /* 입찰번호 */
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	AUC_REG_NUM INTEGER NOT NULL, /* 경매등록번호 */
	BID_QTY SMALLINT NOT NULL, /* 입찰수량 */
	REG_DTIME DATE DEFAULT sysdate NOT NULL /* 등록일시 */
);

CREATE UNIQUE INDEX PK_REG_BIDDING
	ON REG_BIDDING (
		BID_NUM ASC
	);

CREATE INDEX FK_USR_TO_REG_BIDDING
	ON REG_BIDDING (
		MEMB_NUM ASC
	);

CREATE INDEX FK_REG_AUC_TO_REG_BIDDING
	ON REG_BIDDING (
		AUC_REG_NUM ASC
	);

ALTER TABLE REG_BIDDING
	ADD
		CONSTRAINT PK_REG_BIDDING
		PRIMARY KEY (
			BID_NUM
		);

/* 입찰가등록 */
CREATE TABLE BIDDING (
	BID_PRICE_REG_NUM INTEGER NOT NULL, /* 입찰가등록번호 */
	BID_PRICE INTEGER NOT NULL, /* 입찰금액  */
	BID_DTIME DATE DEFAULT sysdate NOT NULL, /* 입찰일시 */
	BID_NUM INTEGER NOT NULL /* 입찰번호 */
);

CREATE UNIQUE INDEX PK_BIDDING
	ON BIDDING (
		BID_PRICE_REG_NUM ASC
	);

CREATE INDEX FK_REG_BIDDING_TO_BIDDING
	ON BIDDING (
		BID_NUM ASC
	);

CREATE INDEX IX_BIDDING
	ON BIDDING (
		BID_PRICE ASC
	);

ALTER TABLE BIDDING
	ADD
		CONSTRAINT PK_BIDDING
		PRIMARY KEY (
			BID_PRICE_REG_NUM
		);

/* 낙찰 */
CREATE TABLE SUCC_BIDDING (
	SBID_NUM INTEGER NOT NULL, /* 낙찰번호 */
	SBID_DATE DATE, /* 낙찰일자 */
	SBID_PRICE INTEGER NOT NULL /* 낙찰가 */
);

CREATE UNIQUE INDEX PK_SUCC_BIDDING
	ON SUCC_BIDDING (
		SBID_NUM ASC
	);

ALTER TABLE SUCC_BIDDING
	ADD
		CONSTRAINT PK_SUCC_BIDDING
		PRIMARY KEY (
			SBID_NUM
		);

/* 결재 */
CREATE TABLE PAY (
	PAY_NUM INTEGER NOT NULL, /* 결제번호  */
	PAY_PRICE INTEGER NOT NULL, /* 결제가격 */
	PAY_DATE DATE DEFAULT sysdate NOT NULL, /* 결제일자  */
	SBID_NUM INTEGER NOT NULL, /* 낙찰번호 */
	PAY_METH CHAR(4) /* 결제방법 */
);

COMMENT ON COLUMN PAY.SBID_NUM IS '1. 온라인입금
2. 멤버쉽포인트
3. 전자지갑포인트
4. 신용카드
5. 직불카드
6. 폰빌
';

CREATE UNIQUE INDEX PK_PAY
	ON PAY (
		PAY_NUM ASC
	);

CREATE INDEX FK_SUCC_BIDDING_TO_PAY
	ON PAY (
		SBID_NUM ASC
	);

CREATE UNIQUE INDEX FK_CD_TO_PAY
	ON PAY (
		PAY_METH ASC
	);

ALTER TABLE PAY
	ADD
		CONSTRAINT PK_PAY
		PRIMARY KEY (
			PAY_NUM
		);

/* 배송 */
CREATE TABLE DELI (
	DELI_NUM INTEGER NOT NULL, /* 배송번호 */
	DELI_DTIME DATE DEFAULT sysdate NOT NULL, /* 배송일시 */
	SBID_NUM INTEGER NOT NULL, /* 낙찰번호 */
	SHORT_CONT VARCHAR(255) NOT NULL /* 비고 */
);

CREATE UNIQUE INDEX PK_DELI
	ON DELI (
		DELI_NUM ASC
	);

CREATE INDEX FK_SUCC_BIDDING_TO_DELI
	ON DELI (
		SBID_NUM ASC
	);

ALTER TABLE DELI
	ADD
		CONSTRAINT PK_DELI
		PRIMARY KEY (
			DELI_NUM
		);

/* 배송비용 */
CREATE TABLE DELI_DETAIL (
	DELI_COST_NUM INTEGER NOT NULL, /* 배송비용번호  */
	DELI_COST INTEGER NOT NULL /* 배송비용 */
);

CREATE UNIQUE INDEX PK_DELI_DETAIL
	ON DELI_DETAIL (
		DELI_COST_NUM ASC
	);

ALTER TABLE DELI_DETAIL
	ADD
		CONSTRAINT PK_DELI_DETAIL
		PRIMARY KEY (
			DELI_COST_NUM
		);

/* 수령 */
CREATE TABLE REC (
	DELI_NUM INTEGER NOT NULL, /* 배송번호 */
	TAKE_DTIME DATE DEFAULT sysdate NOT NULL, /* 수령일시 */
	TAKE_CONFIRM CHAR(4) /* 수령확인 */
);

CREATE UNIQUE INDEX PK_REC
	ON REC (
		DELI_NUM ASC
	);

CREATE INDEX FK_DELI_TO_REC
	ON REC (
		DELI_NUM ASC
	);

CREATE INDEX FK_CD_TO_REC
	ON REC (
		TAKE_CONFIRM ASC
	);

ALTER TABLE REC
	ADD
		CONSTRAINT PK_REC
		PRIMARY KEY (
			DELI_NUM
		);

/* 수령거부 */
CREATE TABLE REC_REJ (
	DELI_NUM INTEGER NOT NULL, /* 배송번호 */
	REJ_REAS VARCHAR(255) NOT NULL /* 거부사유 */
);

CREATE UNIQUE INDEX PK_REC_REJ
	ON REC_REJ (
		DELI_NUM ASC
	);

ALTER TABLE REC_REJ
	ADD
		CONSTRAINT PK_REC_REJ
		PRIMARY KEY (
			DELI_NUM
		);

/* 경매상품첨부파일 */
CREATE TABLE REG_AUC_FILE (
	ATTAC_FILE_NUM INTEGER NOT NULL, /* 첨부파일번호 */
	FILE_NM VARCHAR(100), /* 파일이름  */
	FILE_PATH VARCHAR(255), /* 파일경로  */
	REAL_NM VARCHAR(100), /* 실제이름 */
	FILE_SIZE INTEGER, /* 파일사이즈 */
	BOARD_NUM INTEGER, /* 게시판번호 */
	AUC_REG_NUM INTEGER /* 경매등록번호 */
);

CREATE UNIQUE INDEX PK_REG_AUC_FILE
	ON REG_AUC_FILE (
		ATTAC_FILE_NUM ASC
	);

CREATE INDEX FK_REG_AUC_TO_REG_AUC_FILE
	ON REG_AUC_FILE (
		AUC_REG_NUM ASC
	);

ALTER TABLE REG_AUC_FILE
	ADD
		CONSTRAINT PK_REG_AUC_FILE
		PRIMARY KEY (
			ATTAC_FILE_NUM
		);

/* 분류 */
CREATE TABLE CD (
	CD CHAR(4) NOT NULL, /* 구분 */
	CATE_NM VARCHAR2(50) NOT NULL, /* 분류명 */
	CATE_CONT VARCHAR(255), /* 분류내용 */
	HIGH_CD CHAR(4) /* 상위구분 */
);

COMMENT ON COLUMN CD.CD IS '1000 	관리자구분코드
	1001 	수퍼관리자
	1002 	일반관리자
1100	경고구분코드
	1101. 경고 1번
	1102. 경고 2번
	1103. 그레이회원 등록
	1104. 다크그레이 회원 등록
	1105. 블랙 회원
1200	회원등급	
	1201. 정회원
	1202. 브론즈회원
	1203. 실버회원
	1204. 골드회원
	1205. VIP 회원
	1209. 블랙 회원 (멤버쉽 몰수)
1300	회원신용등급
	1301. 양호
	1302. 불량
1400	결제방법
	1401. 온라인입금
	1402. 멤버쉽포인트
	1403. 전자지갑포인트
	1404. 신용카드
	1405. 직불카드
	1406. 폰빌
1500	경매등록승인
	1501 승인
	1502 승인
1600 상품수령/미수령
	1601. 수령
	1602. 미수령
1700 회원탈퇴구분
	1701. 탈퇴
	1702. 회원
1800 경매유형
	1801. 순경매
	1802. 역경매
	1803. 더치경매
	1804. 쌍방향경매
1900 이메일유형
	1901. daum.net
	1902. naver.com
	1903. google.com
	1904. nate.com
	1905. empas.com
2000 회원구분
	2001 개인
	2002 기업
2100 카테고리 사용구분
	2101 사용
	2102 미사용
2200	카테고리사용구분
	2201	사용	
	2202	미사용
9900 검색구분코드
	9901 작성자
	9902 제목
	9903 ';

CREATE UNIQUE INDEX PK_CD
	ON CD (
		CD ASC
	);

CREATE INDEX FK_CD_TO_CD
	ON CD (
		HIGH_CD ASC
	);

ALTER TABLE CD
	ADD
		CONSTRAINT PK_CD
		PRIMARY KEY (
			CD
		);

/* 회원첨부파일 */
CREATE TABLE USR_FILE (
	MEMB_NUM INTEGER NOT NULL, /* 회원번호  */
	FILE_NM VARCHAR(100) NOT NULL, /* 파일이름  */
	FILE_PATH VARCHAR(255) NOT NULL, /* 파일경로  */
	REAL_NM VARCHAR(100) NOT NULL, /* 실제이름 */
	FILE_SIZE INTEGER NOT NULL /* 파일사이즈 */
);

COMMENT ON COLUMN USR_FILE.FILE_SIZE IS '파일 사이즈 10M 이하';

CREATE UNIQUE INDEX PK_USR_FILE
	ON USR_FILE (
		MEMB_NUM ASC
	);

ALTER TABLE USR_FILE
	ADD
		CONSTRAINT PK_USR_FILE
		PRIMARY KEY (
			MEMB_NUM
		);

ALTER TABLE USR_FILE
	ADD
		CONSTRAINT CK_USR_FILE
		CHECK (FILE_SIZE between 1 and 1000000);

/* 경로 */
CREATE TABLE PATH (
	PATH_NUM INTEGER NOT NULL, /* 경로번호 */
	PATH_NM VARCHAR(100), /* 경로이름 */
	PATH VARCHAR(255) /* 경로  */
);

CREATE UNIQUE INDEX PK_PATH
	ON PATH (
		PATH_NUM ASC
	);

ALTER TABLE PATH
	ADD
		CONSTRAINT PK_PATH
		PRIMARY KEY (
			PATH_NUM
		);

ALTER TABLE USR
	ADD
		CONSTRAINT FK_CD_TO_USR
		FOREIGN KEY (
			MEMB_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE USR
	ADD
		CONSTRAINT FK_CD_TO_USR2
		FOREIGN KEY (
			WITHDRAWAL_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE USR
	ADD
		CONSTRAINT FK_CD_TO_USR3
		FOREIGN KEY (
			CRE_DEG_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE USR
	ADD
		CONSTRAINT FK_CD_TO_USR4
		FOREIGN KEY (
			MAIL_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE PRI_USR
	ADD
		CONSTRAINT FK_USR_TO_PRI_USR
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE COM_USR
	ADD
		CONSTRAINT FK_USR_TO_COM_USR
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE MGR
	ADD
		CONSTRAINT FK_MGR_TO_MGR
		FOREIGN KEY (
			HIGH_MGR_NUM
		)
		REFERENCES MGR (
			MGR_NUM
		);

ALTER TABLE MGR
	ADD
		CONSTRAINT FK_CD_TO_MGR
		FOREIGN KEY (
			MEMB_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE MGR
	ADD
		CONSTRAINT FK_CD_TO_MGR2
		FOREIGN KEY (
			MAIL_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE MEMBERSHIP
	ADD
		CONSTRAINT FK_USR_TO_MEMBERSHIP
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE MEMBERSHIP
	ADD
		CONSTRAINT FK_CD_TO_MEMBERSHIP
		FOREIGN KEY (
			DEG
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE ELEC_WALLET
	ADD
		CONSTRAINT FK_USR_TO_ELEC_WALLET
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_BOARD_TO_BOARD
		FOREIGN KEY (
			HIGH_BOARD_NUM
		)
		REFERENCES BOARD (
			BOARD_NUM
		);

ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_USR_TO_BOARD
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE ATTAC_FILE
	ADD
		CONSTRAINT FK_BOARD_TO_ATTAC_FILE
		FOREIGN KEY (
			BOARD_NUM
		)
		REFERENCES BOARD (
			BOARD_NUM
		);

ALTER TABLE PROD_CATE
	ADD
		CONSTRAINT FK_PROD_CATE_TO_PROD_CATE
		FOREIGN KEY (
			HIGH_PROD_CATE_NUM
		)
		REFERENCES PROD_CATE (
			PROD_CATE_NUM
		);

ALTER TABLE PROD_CATE
	ADD
		CONSTRAINT FK_CD_TO_PROD_CATE
		FOREIGN KEY (
			USE_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE CRE_WARN
	ADD
		CONSTRAINT FK_USR_TO_CRE_WARN
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE CRE_WARN
	ADD
		CONSTRAINT FK_CD_TO_CRE_WARN
		FOREIGN KEY (
			WARN_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE REG_AUC
	ADD
		CONSTRAINT FK_USR_TO_REG_AUC
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE REG_AUC
	ADD
		CONSTRAINT FK_PROD_CATE_TO_REG_AUC
		FOREIGN KEY (
			PROD_CATE_NUM
		)
		REFERENCES PROD_CATE (
			PROD_CATE_NUM
		);

ALTER TABLE REG_AUC
	ADD
		CONSTRAINT FK_CD_TO_REG_AUC
		FOREIGN KEY (
			APPR_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE REG_AUC
	ADD
		CONSTRAINT FK_CD_TO_REG_AUC2
		FOREIGN KEY (
			AUC_TYPE_NUM
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE REG_REJ
	ADD
		CONSTRAINT FK_REG_AUC_TO_REG_REJ
		FOREIGN KEY (
			AUC_REG_NUM
		)
		REFERENCES REG_AUC (
			AUC_REG_NUM
		);

ALTER TABLE REG_BIDDING
	ADD
		CONSTRAINT FK_USR_TO_REG_BIDDING
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);

ALTER TABLE REG_BIDDING
	ADD
		CONSTRAINT FK_REG_AUC_TO_REG_BIDDING
		FOREIGN KEY (
			AUC_REG_NUM
		)
		REFERENCES REG_AUC (
			AUC_REG_NUM
		);

ALTER TABLE BIDDING
	ADD
		CONSTRAINT FK_REG_BIDDING_TO_BIDDING
		FOREIGN KEY (
			BID_NUM
		)
		REFERENCES REG_BIDDING (
			BID_NUM
		);

ALTER TABLE SUCC_BIDDING
	ADD
		CONSTRAINT FK_BIDDING_TO_SUCC_BIDDING
		FOREIGN KEY (
			SBID_NUM
		)
		REFERENCES BIDDING (
			BID_PRICE_REG_NUM
		);

ALTER TABLE PAY
	ADD
		CONSTRAINT FK_SUCC_BIDDING_TO_PAY
		FOREIGN KEY (
			SBID_NUM
		)
		REFERENCES SUCC_BIDDING (
			SBID_NUM
		);

ALTER TABLE PAY
	ADD
		CONSTRAINT FK_CD_TO_PAY
		FOREIGN KEY (
			PAY_METH
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE DELI
	ADD
		CONSTRAINT FK_SUCC_BIDDING_TO_DELI
		FOREIGN KEY (
			SBID_NUM
		)
		REFERENCES SUCC_BIDDING (
			SBID_NUM
		);

ALTER TABLE DELI_DETAIL
	ADD
		CONSTRAINT FK_DELI_TO_DELI_DETAIL
		FOREIGN KEY (
			DELI_COST_NUM
		)
		REFERENCES DELI (
			DELI_NUM
		);

ALTER TABLE REC
	ADD
		CONSTRAINT FK_DELI_TO_REC
		FOREIGN KEY (
			DELI_NUM
		)
		REFERENCES DELI (
			DELI_NUM
		);

ALTER TABLE REC
	ADD
		CONSTRAINT FK_CD_TO_REC
		FOREIGN KEY (
			TAKE_CONFIRM
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE REC_REJ
	ADD
		CONSTRAINT FK_REC_TO_REC_REJ
		FOREIGN KEY (
			DELI_NUM
		)
		REFERENCES REC (
			DELI_NUM
		);

ALTER TABLE REG_AUC_FILE
	ADD
		CONSTRAINT FK_REG_AUC_TO_REG_AUC_FILE
		FOREIGN KEY (
			AUC_REG_NUM
		)
		REFERENCES REG_AUC (
			AUC_REG_NUM
		);

ALTER TABLE CD
	ADD
		CONSTRAINT FK_CD_TO_CD
		FOREIGN KEY (
			HIGH_CD
		)
		REFERENCES CD (
			CD
		);

ALTER TABLE USR_FILE
	ADD
		CONSTRAINT FK_USR_TO_USR_FILE
		FOREIGN KEY (
			MEMB_NUM
		)
		REFERENCES USR (
			MEMB_NUM
		);