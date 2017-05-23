/* ȸ����ȣ ������ */
CREATE SEQUENCE usr_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* �����ڹ�ȣ ������ */
CREATE SEQUENCE mgr_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* �Խ��ǹ�ȣ ������ */
CREATE SEQUENCE board_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ��� ��� ������ */
CREATE SEQUENCE reg_auc_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ÷������ ������ */
CREATE SEQUENCE atta_file_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ��ǰ÷������ ������ */
CREATE SEQUENCE prod_file_seq;

/* ��� ÷�� ���� ������ */
CREATE SEQUENCE auc_file_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ���� ������ */
CREATE SEQUENCE bid_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ���� ��� ������ */
CREATE SEQUENCE bid_reg_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ���� ������ */
CREATE SEQUENCE pay_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ��� ������ */
CREATE SEQUENCE deli_seq 
	MINVALUE 1
	INCREMENT BY 1
	START WITH 1
	ORDER;

/* ȸ�� */
CREATE TABLE USR (
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	MEMB_ID VARCHAR(50) NOT NULL, /* ȸ��ID  */
	SEC_NUM VARCHAR(50) NOT NULL, /* ��й�ȣ */
	EMAIL VARCHAR2(40) NOT NULL, /* �̸���  */
	TEL_NUM VARCHAR2(30) NOT NULL, /* ��ȭ��ȣ */
	MOBIL_NUM VARCHAR(13) NOT NULL, /* �ڵ�����ȣ */
	ZIP_NUM VARCHAR(6) NOT NULL, /* �����ȣ  */
	ADDRESS VARCHAR2(255) NOT NULL, /* �ּ�  */
	DETA_ADDRESS VARCHAR(255) NOT NULL, /* ���ּ� */
	REG_DTIME DATE DEFAULT sysdate NOT NULL, /* ����Ͻ� */
	MEMB_CD CHAR(4), /* ȸ������ */
	WITHDRAWAL_CD CHAR(4), /* Ż�𱸺�  */
	CRE_DEG_CD CHAR(4), /* �ſ��ޱ���  */
	MAIL_CD CHAR(4) /* ���� */
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

/* ����ȸ�� */
CREATE TABLE PRI_USR (
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	NM VARCHAR(50) NOT NULL, /* �̸� */
	SOC_REG_NUM VARCHAR2(13) NOT NULL /* �ֹε�Ϲ�ȣ */
);

CREATE UNIQUE INDEX PK_PRI_USR
	ON PRI_USR (
		MEMB_NUM ASC
	);

ALTER TABLE PRI_USR
	ADD
		CONSTRAINT PK_PRI_USR
		PRIMARY KEY (
			MEMB_NUM
		);

/* ���ȸ�� */
CREATE TABLE COM_USR (
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	CORP_NM VARCHAR(50) NOT NULL, /* ȸ���̸� */
	BUS_NUM VARCHAR2(10), /* ����ڵ�Ϲ�ȣ */
	CEO_NM VARCHAR(50) NOT NULL, /* ��ǥ���̸� */
	CHGR_NM VARCHAR(50) NOT NULL /* ������̸� */
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

ALTER TABLE COM_USR
	ADD
		CONSTRAINT PK_COM_USR
		PRIMARY KEY (
			MEMB_NUM
		);

/* ����ȸ�� */
CREATE TABLE MGR (
	MGR_NUM INTEGER NOT NULL, /* �����ڹ�ȣ  */
	MGR_NM VARCHAR(50) NOT NULL, /* �������̸� */
	MEMB_ID VARCHAR(50) NOT NULL, /* ȸ��ID  */
	SEC_NUM VARCHAR(50) NOT NULL, /* ��й�ȣ */
	EMAIL VARCHAR2(40) NOT NULL, /* �̸���  */
	TEL_NUM VARCHAR2(30) NOT NULL, /* ��ȭ��ȣ  */
	MOBIL_NUM VARCHAR(13) NOT NULL, /* �ڵ�����ȣ  */
	REG_DTIME DATE DEFAULT sysdate NOT NULL, /* ����Ͻ� */
	HIGH_MGR_NUM INTEGER, /* ���������ڹ�ȣ */
	MEMB_CD CHAR(4), /* ȸ������ */
	MAIL_CD CHAR(4) /* ���� */
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

/* ����� */
CREATE TABLE MEMBERSHIP (
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	MSHIP_CARD_NUM VARCHAR(16) NOT NULL, /* �����ī���ȣ */
	NM VARCHAR2(50) NOT NULL, /* �̸� */
	POINT INTEGER NOT NULL, /* ����Ʈ */
	ISSUE_DATE DATE NOT NULL, /* �߱��Ͻ� */
	ISSUE_CNT SMALLINT DEFAULT 1 NOT NULL, /* �߱�ȸ�� */
	DEG CHAR(4) /* ��� */
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

/* �������� */
CREATE TABLE ELEC_WALLET (
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	POINT INTEGER DEFAULT 100000 NOT NULL /* ����Ʈ */
);

COMMENT ON COLUMN ELEC_WALLET.POINT IS 'ȸ�� ù���� 100000 Point';

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

/* �Խ��� */
CREATE TABLE BOARD (
	BOARD_NUM INTEGER NOT NULL, /* �Խ��ǹ�ȣ */
	TITLE VARCHAR2(100) NOT NULL, /* ���� */
	CONT NVARCHAR2(2000) NOT NULL, /* ���� */
	WRITER_NM VARCHAR(50) NOT NULL, /* �ۼ����̸�  */
	WRITE_DATE DATE DEFAULT sysdate NOT NULL, /* �ۼ��Ͻ� */
	REVIEW_CNT INTEGER DEFAULT 0 NOT NULL, /* ��ȸ��  */
	HIGH_BOARD_NUM INTEGER, /* �����Խ��ǹ�ȣ */
	MEMB_NUM INTEGER, /* ȸ����ȣ  */
	QUES_CD CHAR(4) /* �������� */
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

/* ÷������ */
CREATE TABLE ATTAC_FILE (
	ATTAC_FILE_NUM INTEGER NOT NULL, /* ÷�����Ϲ�ȣ */
	FILE_NM VARCHAR(100) NOT NULL, /* �����̸�  */
	FILE_PATH VARCHAR(255) NOT NULL, /* ���ϰ��  */
	REAL_NM VARCHAR(100) NOT NULL, /* �����̸� */
	FILE_SIZE INTEGER NOT NULL, /* ���ϻ����� */
	BOARD_NUM INTEGER /* �Խ��ǹ�ȣ */
);

COMMENT ON COLUMN ATTAC_FILE.FILE_SIZE IS '���� ������ 10M ����';

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

/* ��ǰ�з� */
CREATE TABLE PROD_CATE (
	PROD_CATE_NUM CHAR(4) NOT NULL, /* ��ǰ�з��ڵ� */
	PROD_CATE_NM VARCHAR(50) NOT NULL, /* ��ǰ�з��� */
	SHORT_CONT VARCHAR(255) NOT NULL, /* ��ǰ�з����� */
	HIGH_PROD_CATE_NUM CHAR(4) /* ������ǰ�з��ڵ� */
);

COMMENT ON COLUMN PROD_CATE.PROD_CATE_NUM IS '1000	�м��Ƿ�/��ȭ		
	1100	�����м�	
		1101	Ƽ����
		1102	������/�ĵ�����
		1103	���콺/����
		1104	���ǽ�/���弼Ʈ
		1105	��Ʈ��/����
		1106	����/���뽺
		1107	��ĿƮ/ġ��
		1108	�ƿ���
		1109	�мǿ��
		1110	��Ű��/��ġ����
		1111	������� �Ƿ�
		1112	�ӿ�/���
		1113	Ŀ�÷�/�йи���
		1114	�Ӻκ�
		1115	�Ѻ�/��Ƽ��
		1116	�Ź�
		1117	����/��ȭ
		1118	�ؿ�����
	1200	�����м�	
		1201	Ƽ����
		1202	������
		1203	����
		1204	����
		1205	Ʈ���̴�
		1206	�ĵ�����/������
		1207	������
		1208	�����
		1209	����Ʈ/����
		1210	�ƿ���
		1211	�ӿ�/���
		1212	������� �Ƿ�
		1213	�м� ��������
		1214	Ŀ�÷�/�йи���
		1215	�Ѻ�/�ڽ�Ƭ
		1216	�Ź�
		1217	����/��ȭ
		1218	�ؿ�����
	1300	 �������м�	
		1301	�����������Ƿ�
		1302	�����������Ƿ�
		1303	���ེ�����Ƿ�
		1304	����������
		1305	��������ȭ
		1306	���Ƶ��������м�
	1400	�Ź�	
		1401	����Ŀ��/������
		1402	�ȭ/����ȭ
		1403	������ȭ/�÷�
		1404	����������
		1405	������Ŀ/����
		1406	��������/�ɸ�
		1407	��������/��Ʈȭ
		1408	�������屸��
		1409	������Ŀ/����
		1410	��������/�ɸ�
		1411	������/�ǳ�ȭ
		1412	���ȭ
		1413	��â/�Ź߲�
		1414	�Ź߰�����ǰ
		1415	�ؿ�����
	1500	����/��ȭ	
		1501	��������
		1502	��������
		1503	����ĳ�־󰡹�
		1504	���డ��/��ǰ
		1505	����/��Ʈ
		1506	�縻/��Ÿŷ
		1507	���÷�/��ī��/��
		1508	����
		1509	�尩/������ȭ
		1510	��Ÿ��/��ǰ
		1511	���/���/���
		1512	���̿���
		1513	�ð�
		1514	���
		1515	�ؿ�����
	1600	��ǰ�м�	
		1601	�����Ƿ�
		1602	�����Ƿ�
		1603	�ӿ�
		1604	�Ź�
		1605	����
		1606	����
		1607	�ð�/���
		1608	��Ʈ
		1609	����
		1610	��ī��/���÷�
		1611	�Ȱ���/���۶�
		1612	��Ÿ��
		1613	��Ÿ�м���ȭ
2000	��Ƽ		
	2100	��Ų�ɾ�	
		2101	����ȭ��ǰ
		2102	Ŭ��¡/�ʸ�
		2103	����ũ/��
		2104	���ɾ�/�´�
	2200	����ũ��	
		2201	���� ����ũ��
		2202	�� ����ũ��
		2203	���̽� ����ũ��
		2204	ġũ/��Ÿ ����ũ��
	2300	���	
		2301	�������
		2302	�������
		2303	�巹����Ǿ
	2400	���	
		2401	��Ǫ/����
		2402	Ʈ��Ʈ��Ʈ/��
		2403	��Ÿ�ϸ�/�ɾ�/��Ʈ
		2404	����/�ĸ�
	2500	�ٵ�	
		2501	����/�Կ��ǰ
		2502	�ٵ�μ�/ũ��
		2503	�ڵ�/ǲ/����
		2504	����/������/û����
	2600	����	
		2601	ťƼŬ/����
		2602	�Ϲݳ���
		2603	������
		2604	�����ɾ��
		2605	���Ͼ�Ʈ��ǰ/����
		2606	���ϼ�Ʈ
	2700	����ȭ��ǰ	
		2701	������Ų�ɾ�
		2702	��������ũ��
		2703	����ȭ��ǰ��Ʈ
		2704	���� ����ɾ�
		2705	���� �ٵ��ɾ�
		2706	���� ���̺� �ɾ�
	2800	��ǰȭ��ǰ	
		2801	��Ų�ɾ�
		2802	����ũ��
		2803	���
		2804	����ɾ�
		2805	�ٵ��ɾ�
		2806	����ȭ��ǰ
		2807	��Ƽ��ǰ
	2900	�ｺȭ��ǰ	
		2901	��Ų�ɾ�
		2902	���̽�����ũ��
		2903	���ɾ�
		2904	����ɾ�
		2905	�ٵ��ɾ�
		2906	��Ʈ
		2907	��Ƽ��ǰ
3000	��ǰ		
	3100	�����/ģȯ�� ������	
		3101	����
		3102	�߰�/�ǰ�
		3103	ä��
		3104	��/���
		3105	���/���
		3106	���깰/�Ǿ
		3107	����
		3108	����ǰ/����
		3109	Ŀ��/����/��
		3110	����/�ø���
		3111	��/������/������ǰ
		3112	����/���̷�/����
		3113	��/�ҽ�/�巹��/����
	3200	����	
		3201	���/��
		3202	��/�Ѷ��/���ַ�
		3203	��/ȫ��/����
		3204	Ű��/���ٷ�
		3205	�丶��/�ڵ�/������/����
		3206	����/�޷�/����
		3207	����/��纣��/������
		3208	�ٳ���/������/���ξ���
		3209	�ڸ�/����/����/����
		3210	����/ü��/�ƺ�ī��/��Ÿ
		3211	�õ�����/�������
		3212	���ϰ���
		3213	���ϼ�����Ʈ
	3300	�߰�/�ǰ�	
		3301	����/ȣ��
		3302	��/��/����
		3303	�Ƹ��/�ǽ�Ÿġ��
		3304	��Ÿ�߰���
		3305	ȣ�ھ�/�عٶ�⾾
		3306	��Ÿ����
		3307	ȥ�հ߰�/��Ʈ
		3308	�ǰ���/��ä��
	3400	ä��	
		3401	�κ�/�ᳪ��
		3402	����/����
		3403	���/�Ѹ�ä��
		3404	����/����/����ä��
		3405	����/����/��
		3406	����/��/����ä��
		3407	�ñ�ġ/����/���ٱ�ä��
		3408	����/����/��ä��
		3409	������/����ä��
		3410	������/������
		3411	�λ�/�ǰ������
		3412	��Ÿä��
		3413	�ǳ���/��ä��
	3500	��/���	
		3501	���
		3502	����/����/���
		3503	��ɼ���/��Ÿ��
		3504	��/��/����
		3505	��/����/��
		3506	��Ÿ���/ȥ�հ�
		3507	���۰
		3508	��Ÿ����
		3509	��/��� ����
		3510	���������Ʈ
	3600	���/���	
		3601	�Ұ��
		3602	�������
		3603	��/�������
		3604	��/�����
		3605	��Ÿ �����
		3606	���/�˷�/������
		3607	��꼱����Ʈ
	3700	���깰/�Ǿ	
		3701	����
		3702	��¡��/����/��ü��
		3703	����/��/������
		3704	����/��/������
		3705	��ġ/õ�����̷�
		3706	��/�̿�/������
		3707	�ǿ�¡��/����/����
		3708	Ȳ��/����ä
		3709	������
		3710	��Ÿ���깰/�Ǿ
		3711	���깰������Ʈ
	3800	����/����	
		3801	����/ź���
		3802	����/��ä����
		3803	ź��/����������
		3804	Ŀ������/������
		3805	����
		3806	�Ϲݿ���
		3807	��տ���
		3808	����/�ǰ�����
		3809	��������
		3810	��Ÿ�ֽ�/����
		3811	���ἱ����Ʈ
	3900	�ǰ���ǰ	
		3901	��Ÿ��/������
		3902	ȫ��/�λ�
		3903	�ｺ/���̾�Ʈ��ǰ
		3904	�����/����
		3905	��/�ξ�����
		3906	�ǰ��� ����
		3907	�ǰ��и�/�ǰ�ȯ
		3908	�ѹ����
		3909	�ӻ�ν�ǰ
		3910	���ưǰ���ǰ
4000	������ǰ		
	4100	��Ʈ��/PC/�º�	
		4101	��Ʈ��
		4102	��Ʈ�Ͽ� �׼�����
		4103	����ũž
		4104	PC �߰�/���ۺ��
		4105	�º� PC
		4106	�º�PC �׼�����
	4200	������ġ/������	
		4201	�����ϵ�/NAS
		4202	HDD
		4203	SSD
		4204	ODD/����ũ
		4205	USB�޸�
		4206	�޸�ī��/ī�帮��
		4207	������/��ī��
		4208	��Ʈ��ũ���
		4209	CCTV/IPī�޶�
	4300	�����/������	
		4301	�����
		4302	����� �ֺ����
		4303	������/���ձ�
		4304	��ĳ��
		4305	�����
		4306	POS/���ڵ彺ĵ
		4307	��ũ/���
	4400	PC��ǰ/�ֺ����	
		4401	���콺/Ű����
		4402	����Ŀ/����/��ķ
		4403	CPU
		4404	��(RAM)
		4405	�׷���/TVī��
		4406	���κ���/Ȯ��ī��
		4407	���̽�/�Ŀ�
		4408	USB���/���̺�/����
		4409	��Ƽ��/PC������ǰ
		4410	��
		4411	����Ʈ����
	4500	�޴���/�׼�����	
		4501	�޴��� ���̽�
		4502	�޴��� �׼�����
		4503	���͸�/����/���̺�
		4504	����Ʈ��ġ/���
		4505	�º� PC
		4506	�º�PC �׼�����
		4507	�޸�ī��/������
		4508	�޴���
	4600	������/�̾���	
		4601	�̾���
		4602	�����
		4603	����Ŀ
		4604	Ȩ�þ���/�����
		4605	����/ī��Ʈ/MP3
		4606	����/����/����
		4607	PA/����ũ/���ڵ�
		4608	���� �׼�����
	4700	TV/������	
		4701	TV
		4702	TV �׼�����
		4703	��緹��/DVD/DivX
		4704	��/��������/��ũ��
	4800	ī�޶�/ķ�ڴ�	
		4801	DSLR
		4802	DSLR ����
		4803	�̷�����
		4804	�̷����� ����
		4805	���̿���/����Ʈ
		4806	ī�޶� �׼�����
		4807	�׼�ķ/ķ�ڴ�
		4808	�Ｎ/��Ÿī�޶�
		4809	����������/����
		4810	�߰�/����/����
	4900	�����/��ġ�����	
		4901	�����
		4902	��ġ�����
5000	�ڵ�����ǰ		
	5100	�ǳ���ǰ	
		5101	���׸����ǰ
		5102	�����������ǰ
		5103	���������ǿ�ǰ
	5200	�ǿܿ�ǰ/�ͽ��׸���	
		5201	������
		5202	��ƼĿ/����
		5203	���׳�/��
		5204	������ĸ/ȥ��������
		5205	��ȣ�� �׼�����
		5206	�������/�����
		5207	����/����
		5208	�̷���ǰ
		5209	������ǰ
		5210	ĳ�����ǰ
		5211	������ �ٵ�Ŀ��
	5300	����/������ǰ	
		5301	������ǰ
		5302	������ǰ
		5303	������ǰ��Ʈ
	5400	��Ʈ/��Ʈ/���	
		5401	������ī��Ʈ
		5402	�������Ʈ/���ƽ�Ʈ
		5403	���������
		5404	������漮
		5405	��ǹ漮��Ʈ
6000	Ƽ��		
	6100	��������	
		6101	ȣ��
		6102	����Ʈ
		6103	���
		6104	ķ��/�۷���
		6105	��Ƽũ ȣ��/����
		6106	�Խ�Ʈ�Ͽ콺
		6107	�׸���ũ/������ũ
		6108	������/ü��/����
		6109	�����׸�����
		6110	��������ī
		6111	���ֿ���
		6112	�����װ���
		6113	���ַ���ī
	6200	�ؿܿ���	
		6201	Ư�� �װ�
		6202	�ǽð� �װ� ����
		6203	Ư�� ȣ��
		6204	������ ȣ�� ����
		6205	�����������/�����н�
		6206	�Ϻ�
		6207	�����ƽþ�
		6208	��/������/ȣ��
		6209	ȫ��/��ī��/�븸
		6210	�߱�
		6211	����
		6212	����/�Ͽ���
	6300	����/����/ü��	
		6301	�������
		6302	������/�ܼ�Ʈ
		6303	����/��ȭ
		6304	ü��/����
		6305	�Ƶ�������
		6306	Ű��ī��/��ũ';

COMMENT ON COLUMN PROD_CATE.HIGH_PROD_CATE_NUM IS '1000	�м��Ƿ�/��ȭ		
	1100	�����м�	
		1101	Ƽ����
		1102	������/�ĵ�����
		1103	���콺/����
		1104	���ǽ�/���弼Ʈ
		1105	��Ʈ��/����
		1106	����/���뽺
		1107	��ĿƮ/ġ��
		1108	�ƿ���
		1109	�мǿ��
		1110	��Ű��/��ġ����
		1111	������� �Ƿ�
		1112	�ӿ�/���
		1113	Ŀ�÷�/�йи���
		1114	�Ӻκ�
		1115	�Ѻ�/��Ƽ��
		1116	�Ź�
		1117	����/��ȭ
		1118	�ؿ�����
	1200	�����м�	
		1201	Ƽ����
		1202	������
		1203	����
		1204	����
		1205	Ʈ���̴�
		1206	�ĵ�����/������
		1207	������
		1208	�����
		1209	����Ʈ/����
		1210	�ƿ���
		1211	�ӿ�/���
		1212	������� �Ƿ�
		1213	�м� ��������
		1214	Ŀ�÷�/�йи���
		1215	�Ѻ�/�ڽ�Ƭ
		1216	�Ź�
		1217	����/��ȭ
		1218	�ؿ�����
	1300	 �������м�	
		1301	�����������Ƿ�
		1302	�����������Ƿ�
		1303	���ེ�����Ƿ�
		1304	����������
		1305	��������ȭ
		1306	���Ƶ��������м�
	1400	�Ź�	
		1401	����Ŀ��/������
		1402	�ȭ/����ȭ
		1403	������ȭ/�÷�
		1404	����������
		1405	������Ŀ/����
		1406	��������/�ɸ�
		1407	��������/��Ʈȭ
		1408	�������屸��
		1409	������Ŀ/����
		1410	��������/�ɸ�
		1411	������/�ǳ�ȭ
		1412	���ȭ
		1413	��â/�Ź߲�
		1414	�Ź߰�����ǰ
		1415	�ؿ�����
	1500	����/��ȭ	
		1501	��������
		1502	��������
		1503	����ĳ�־󰡹�
		1504	���డ��/��ǰ
		1505	����/��Ʈ
		1506	�縻/��Ÿŷ
		1507	���÷�/��ī��/��
		1508	����
		1509	�尩/������ȭ
		1510	��Ÿ��/��ǰ
		1511	���/���/���
		1512	���̿���
		1513	�ð�
		1514	���
		1515	�ؿ�����
	1600	��ǰ�м�	
		1601	�����Ƿ�
		1602	�����Ƿ�
		1603	�ӿ�
		1604	�Ź�
		1605	����
		1606	����
		1607	�ð�/���
		1608	��Ʈ
		1609	����
		1610	��ī��/���÷�
		1611	�Ȱ���/���۶�
		1612	��Ÿ��
		1613	��Ÿ�м���ȭ
2000	��Ƽ		
	2100	��Ų�ɾ�	
		2101	����ȭ��ǰ
		2102	Ŭ��¡/�ʸ�
		2103	����ũ/��
		2104	���ɾ�/�´�
	2200	����ũ��	
		2201	���� ����ũ��
		2202	�� ����ũ��
		2203	���̽� ����ũ��
		2204	ġũ/��Ÿ ����ũ��
	2300	���	
		2301	�������
		2302	�������
		2303	�巹����Ǿ
	2400	���	
		2401	��Ǫ/����
		2402	Ʈ��Ʈ��Ʈ/��
		2403	��Ÿ�ϸ�/�ɾ�/��Ʈ
		2404	����/�ĸ�
	2500	�ٵ�	
		2501	����/�Կ��ǰ
		2502	�ٵ�μ�/ũ��
		2503	�ڵ�/ǲ/����
		2504	����/������/û����
	2600	����	
		2601	ťƼŬ/����
		2602	�Ϲݳ���
		2603	������
		2604	�����ɾ��
		2605	���Ͼ�Ʈ��ǰ/����
		2606	���ϼ�Ʈ
	2700	����ȭ��ǰ	
		2701	������Ų�ɾ�
		2702	��������ũ��
		2703	����ȭ��ǰ��Ʈ
		2704	���� ����ɾ�
		2705	���� �ٵ��ɾ�
		2706	���� ���̺� �ɾ�
	2800	��ǰȭ��ǰ	
		2801	��Ų�ɾ�
		2802	����ũ��
		2803	���
		2804	����ɾ�
		2805	�ٵ��ɾ�
		2806	����ȭ��ǰ
		2807	��Ƽ��ǰ
	2900	�ｺȭ��ǰ	
		2901	��Ų�ɾ�
		2902	���̽�����ũ��
		2903	���ɾ�
		2904	����ɾ�
		2905	�ٵ��ɾ�
		2906	��Ʈ
		2907	��Ƽ��ǰ
3000	��ǰ		
	3100	�����/ģȯ�� ������	
		3101	����
		3102	�߰�/�ǰ�
		3103	ä��
		3104	��/���
		3105	���/���
		3106	���깰/�Ǿ
		3107	����
		3108	����ǰ/����
		3109	Ŀ��/����/��
		3110	����/�ø���
		3111	��/������/������ǰ
		3112	����/���̷�/����
		3113	��/�ҽ�/�巹��/����
	3200	����	
		3201	���/��
		3202	��/�Ѷ��/���ַ�
		3203	��/ȫ��/����
		3204	Ű��/���ٷ�
		3205	�丶��/�ڵ�/������/����
		3206	����/�޷�/����
		3207	����/��纣��/������
		3208	�ٳ���/������/���ξ���
		3209	�ڸ�/����/����/����
		3210	����/ü��/�ƺ�ī��/��Ÿ
		3211	�õ�����/�������
		3212	���ϰ���
		3213	���ϼ�����Ʈ
	3300	�߰�/�ǰ�	
		3301	����/ȣ��
		3302	��/��/����
		3303	�Ƹ��/�ǽ�Ÿġ��
		3304	��Ÿ�߰���
		3305	ȣ�ھ�/�عٶ�⾾
		3306	��Ÿ����
		3307	ȥ�հ߰�/��Ʈ
		3308	�ǰ���/��ä��
	3400	ä��	
		3401	�κ�/�ᳪ��
		3402	����/����
		3403	���/�Ѹ�ä��
		3404	����/����/����ä��
		3405	����/����/��
		3406	����/��/����ä��
		3407	�ñ�ġ/����/���ٱ�ä��
		3408	����/����/��ä��
		3409	������/����ä��
		3410	������/������
		3411	�λ�/�ǰ������
		3412	��Ÿä��
		3413	�ǳ���/��ä��
	3500	��/���	
		3501	���
		3502	����/����/���
		3503	��ɼ���/��Ÿ��
		3504	��/��/����
		3505	��/����/��
		3506	��Ÿ���/ȥ�հ�
		3507	���۰
		3508	��Ÿ����
		3509	��/��� ����
		3510	���������Ʈ
	3600	���/���	
		3601	�Ұ��
		3602	�������
		3603	��/�������
		3604	��/�����
		3605	��Ÿ �����
		3606	���/�˷�/������
		3607	��꼱����Ʈ
	3700	���깰/�Ǿ	
		3701	����
		3702	��¡��/����/��ü��
		3703	����/��/������
		3704	����/��/������
		3705	��ġ/õ�����̷�
		3706	��/�̿�/������
		3707	�ǿ�¡��/����/����
		3708	Ȳ��/����ä
		3709	������
		3710	��Ÿ���깰/�Ǿ
		3711	���깰������Ʈ
	3800	����/����	
		3801	����/ź���
		3802	����/��ä����
		3803	ź��/����������
		3804	Ŀ������/������
		3805	����
		3806	�Ϲݿ���
		3807	��տ���
		3808	����/�ǰ�����
		3809	��������
		3810	��Ÿ�ֽ�/����
		3811	���ἱ����Ʈ
	3900	�ǰ���ǰ	
		3901	��Ÿ��/������
		3902	ȫ��/�λ�
		3903	�ｺ/���̾�Ʈ��ǰ
		3904	�����/����
		3905	��/�ξ�����
		3906	�ǰ��� ����
		3907	�ǰ��и�/�ǰ�ȯ
		3908	�ѹ����
		3909	�ӻ�ν�ǰ
		3910	���ưǰ���ǰ
4000	������ǰ		
	4100	��Ʈ��/PC/�º�	
		4101	��Ʈ��
		4102	��Ʈ�Ͽ� �׼�����
		4103	����ũž
		4104	PC �߰�/���ۺ��
		4105	�º� PC
		4106	�º�PC �׼�����
	4200	������ġ/������	
		4201	�����ϵ�/NAS
		4202	HDD
		4203	SSD
		4204	ODD/����ũ
		4205	USB�޸�
		4206	�޸�ī��/ī�帮��
		4207	������/��ī��
		4208	��Ʈ��ũ���
		4209	CCTV/IPī�޶�
	4300	�����/������	
		4301	�����
		4302	����� �ֺ����
		4303	������/���ձ�
		4304	��ĳ��
		4305	�����
		4306	POS/���ڵ彺ĵ
		4307	��ũ/���
	4400	PC��ǰ/�ֺ����	
		4401	���콺/Ű����
		4402	����Ŀ/����/��ķ
		4403	CPU
		4404	��(RAM)
		4405	�׷���/TVī��
		4406	���κ���/Ȯ��ī��
		4407	���̽�/�Ŀ�
		4408	USB���/���̺�/����
		4409	��Ƽ��/PC������ǰ
		4410	��
		4411	����Ʈ����
	4500	�޴���/�׼�����	
		4501	�޴��� ���̽�
		4502	�޴��� �׼�����
		4503	���͸�/����/���̺�
		4504	����Ʈ��ġ/���
		4505	�º� PC
		4506	�º�PC �׼�����
		4507	�޸�ī��/������
		4508	�޴���
	4600	������/�̾���	
		4601	�̾���
		4602	�����
		4603	����Ŀ
		4604	Ȩ�þ���/�����
		4605	����/ī��Ʈ/MP3
		4606	����/����/����
		4607	PA/����ũ/���ڵ�
		4608	���� �׼�����
	4700	TV/������	
		4701	TV
		4702	TV �׼�����
		4703	��緹��/DVD/DivX
		4704	��/��������/��ũ��
	4800	ī�޶�/ķ�ڴ�	
		4801	DSLR
		4802	DSLR ����
		4803	�̷�����
		4804	�̷����� ����
		4805	���̿���/����Ʈ
		4806	ī�޶� �׼�����
		4807	�׼�ķ/ķ�ڴ�
		4808	�Ｎ/��Ÿī�޶�
		4809	����������/����
		4810	�߰�/����/����
	4900	�����/��ġ�����	
		4901	�����
		4902	��ġ�����
5000	�ڵ�����ǰ		
	5100	�ǳ���ǰ	
		5101	���׸����ǰ
		5102	�����������ǰ
		5103	���������ǿ�ǰ
	5200	�ǿܿ�ǰ/�ͽ��׸���	
		5201	������
		5202	��ƼĿ/����
		5203	���׳�/��
		5204	������ĸ/ȥ��������
		5205	��ȣ�� �׼�����
		5206	�������/�����
		5207	����/����
		5208	�̷���ǰ
		5209	������ǰ
		5210	ĳ�����ǰ
		5211	������ �ٵ�Ŀ��
	5300	����/������ǰ	
		5301	������ǰ
		5302	������ǰ
		5303	������ǰ��Ʈ
	5400	��Ʈ/��Ʈ/���	
		5401	������ī��Ʈ
		5402	�������Ʈ/���ƽ�Ʈ
		5403	���������
		5404	������漮
		5405	��ǹ漮��Ʈ
6000	Ƽ��		
	6100	��������	
		6101	ȣ��
		6102	����Ʈ
		6103	���
		6104	ķ��/�۷���
		6105	��Ƽũ ȣ��/����
		6106	�Խ�Ʈ�Ͽ콺
		6107	�׸���ũ/������ũ
		6108	������/ü��/����
		6109	�����׸�����
		6110	��������ī
		6111	���ֿ���
		6112	�����װ���
		6113	���ַ���ī
	6200	�ؿܿ���	
		6201	Ư�� �װ�
		6202	�ǽð� �װ� ����
		6203	Ư�� ȣ��
		6204	������ ȣ�� ����
		6205	�����������/�����н�
		6206	�Ϻ�
		6207	�����ƽþ�
		6208	��/������/ȣ��
		6209	ȫ��/��ī��/�븸
		6210	�߱�
		6211	����
		6212	����/�Ͽ���
	6300	����/����/ü��	
		6301	�������
		6302	������/�ܼ�Ʈ
		6303	����/��ȭ
		6304	ü��/����
		6305	�Ƶ�������
		6306	Ű��ī��/��ũ';

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

/* �ſ��� */
CREATE TABLE CRE_WARN (
	WARN_NUM INTEGER NOT NULL, /* ����ȣ */
	WARN_NM VARCHAR(50) NOT NULL, /* ����  */
	WARN_CONT VARCHAR(255) NOT NULL, /* �����  */
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	WARN_CD CHAR(4) /* ����� */
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

/* ��ŵ�ϻ�ǰ */
CREATE TABLE REG_AUC (
	AUC_REG_NUM INTEGER NOT NULL, /* ��ŵ�Ϲ�ȣ */
	AUC_PROD_NM VARCHAR(50) NOT NULL, /* ��Ż�ǰ�� */
	SHORT_CONT NVARCHAR2(2000) NOT NULL, /* ��Ż�ǰ���� */
	REG_DTIME DATE DEFAULT sysdate NOT NULL, /* ����Ͻ� */
	START_DTIME DATE NOT NULL, /* �����Ͻ� */
	END_DTIME DATE NOT NULL, /* �����Ͻ� */
	START_PRICE INTEGER NOT NULL, /* ���۰� */
	QTY SMALLINT NOT NULL, /* ���� */
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	PROD_CATE_NUM CHAR(4), /* ��ǰ�з��ڵ� */
	APPR_CD CHAR(4), /* ���α��� */
	AUC_TYPE_NUM CHAR(4) /* ���������ȣ */
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

/* ��ϰź� */
CREATE TABLE REG_REJ (
	AUC_REG_NUM INTEGER NOT NULL, /* ��ŵ�Ϲ�ȣ */
	REG_REJ_REAS VARCHAR(255) NOT NULL /* ��ϰźλ��� */
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

/* ���� */
CREATE TABLE REG_BIDDING (
	BID_NUM INTEGER NOT NULL, /* ������ȣ */
	MEMB_NUM INTEGER NOT NULL, /* ȸ����ȣ  */
	AUC_REG_NUM INTEGER NOT NULL, /* ��ŵ�Ϲ�ȣ */
	BID_QTY SMALLINT NOT NULL, /* �������� */
	REG_DTIME DATE DEFAULT sysdate NOT NULL /* ����Ͻ� */
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

/* ��������� */
CREATE TABLE BIDDING (
	BID_PRICE_REG_NUM INTEGER NOT NULL, /* ��������Ϲ�ȣ */
	BID_PRICE INTEGER NOT NULL, /* �����ݾ�  */
	BID_DTIME DATE DEFAULT sysdate NOT NULL, /* �����Ͻ� */
	BID_NUM INTEGER NOT NULL /* ������ȣ */
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

/* ���� */
CREATE TABLE SUCC_BIDDING (
	SBID_NUM INTEGER NOT NULL, /* ������ȣ */
	SBID_DATE DATE, /* �������� */
	SBID_PRICE INTEGER NOT NULL /* ������ */
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

/* ���� */
CREATE TABLE PAY (
	PAY_NUM INTEGER NOT NULL, /* ������ȣ  */
	PAY_PRICE INTEGER NOT NULL, /* �������� */
	PAY_DATE DATE DEFAULT sysdate NOT NULL, /* ��������  */
	SBID_NUM INTEGER NOT NULL, /* ������ȣ */
	PAY_METH CHAR(4) /* ������� */
);

COMMENT ON COLUMN PAY.SBID_NUM IS '1. �¶����Ա�
2. ���������Ʈ
3. ������������Ʈ
4. �ſ�ī��
5. ����ī��
6. ����
';

CREATE UNIQUE INDEX PK_PAY
	ON PAY (
		PAY_NUM ASC
	);

CREATE INDEX FK_SUCC_BIDDING_TO_PAY
	ON PAY (
		SBID_NUM ASC
	);

CREATE INDEX FK_CD_TO_PAY
	ON PAY (
		PAY_METH ASC
	);

ALTER TABLE PAY
	ADD
		CONSTRAINT PK_PAY
		PRIMARY KEY (
			PAY_NUM
		);

/* ��� */
CREATE TABLE DELI (
	DELI_NUM INTEGER NOT NULL, /* ��۹�ȣ */
	DELI_DTIME DATE DEFAULT sysdate NOT NULL, /* ����Ͻ� */
	SBID_NUM INTEGER NOT NULL, /* ������ȣ */
	SHORT_CONT VARCHAR(255) NOT NULL /* ��� */
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

/* ��ۺ�� */
CREATE TABLE DELI_DETAIL (
	DELI_COST_NUM INTEGER NOT NULL, /* ��ۺ���ȣ  */
	DELI_COST INTEGER NOT NULL /* ��ۺ�� */
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

/* ���� */
CREATE TABLE REC (
	DELI_NUM INTEGER NOT NULL, /* ��۹�ȣ */
	TAKE_DTIME DATE DEFAULT sysdate NOT NULL, /* �����Ͻ� */
	TAKE_CONFIRM CHAR(4) /* ����Ȯ�� */
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

/* ���ɰź� */
CREATE TABLE REC_REJ (
	DELI_NUM INTEGER NOT NULL, /* ��۹�ȣ */
	REJ_REAS VARCHAR(255) NOT NULL /* �źλ��� */
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

/* ��Ż�ǰ÷������ */
CREATE TABLE REG_AUC_FILE (
	ATTAC_FILE_NUM INTEGER NOT NULL, /* ÷�����Ϲ�ȣ */
	FILE_NM VARCHAR(100), /* �����̸�  */
	FILE_PATH VARCHAR(255), /* ���ϰ��  */
	REAL_NM VARCHAR(100), /* �����̸� */
	FILE_SIZE INTEGER, /* ���ϻ����� */
	BOARD_NUM INTEGER, /* �Խ��ǹ�ȣ */
	AUC_REG_NUM INTEGER /* ��ŵ�Ϲ�ȣ */
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

/* �з� */
CREATE TABLE CD (
	CD CHAR(4) NOT NULL, /* ���� */
	CATE_NM VARCHAR2(50) NOT NULL, /* �з��� */
	CATE_CONT VARCHAR(255), /* �з����� */
	HIGH_CD CHAR(4) /* �������� */
);

COMMENT ON COLUMN CD.CD IS '1000 	�����ڱ����ڵ�
	1001 	���۰�����
	1002 	�Ϲݰ�����
1100	������ڵ�
	1101. ��� 1��
	1102. ��� 2��
	1103. �׷���ȸ�� ���
	1104. ��ũ�׷��� ȸ�� ���
	1105. �� ȸ��
1200	ȸ�����	
	1201. ��ȸ��
	1202. �����ȸ��
	1203. �ǹ�ȸ��
	1204. ���ȸ��
	1205. VIP ȸ��
	1209. �� ȸ�� (����� ����)
1300	ȸ���ſ���
	1301. ��ȣ
	1302. �ҷ�
1400	�������
	1401. �¶����Ա�
	1402. ���������Ʈ
	1403. ������������Ʈ
	1404. �ſ�ī��
	1405. ����ī��
	1406. ����
1500	��ŵ�Ͻ���
	1501 ����
	1502 ����
1600 ��ǰ����/�̼���
	1601. ����
	1602. �̼���
1700 ȸ��Ż�𱸺�
	1701. Ż��
	1702. ȸ��
1800 �������
	1801. �����
	1802. �����
	1803. ��ġ���
	1804. �ֹ�����
1900 �̸�������
	1901. daum.net
	1902. naver.com
	1903. google.com
	1904. nate.com
	1905. empas.com
2000 ȸ������
	2001 ����
	2002 ���';

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