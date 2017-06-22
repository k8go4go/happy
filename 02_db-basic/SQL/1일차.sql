-- HR 계정 활성화하기

conn /as sysdba;

alter user hr 
      identified by hr 
      account unlock;
      
conn hr/hr;

-- 현재 사용자의 전체 테이블 목록 보기
select * from tab;

-- SQL 작성 시 값이 아닌 부분은 대소문자 구분 안함
-- CREATE : 테이블 생성
-- 테이블명, 컬럼명은 내부적으로 대문자로 관리
-- CRREAT TABLE board   ->    BOARD
class 클래스명 {
	타입 변수명; 
}

CREATE TABLE 테이블명 (
	컬럼명  컬럼타입(크기),
	컬럼명  컬럼타입(크기),
	....
	컬럼명  컬럼타입(크기)
);  

-- 테이블 생성시의 네이밍룰
-- t_테이블명,  tb_테이블명, t업무관련키워드_이름

create table t_board 
create table tb_board 
create table tc_board 


create table tb_board (
	no number(6),
	title varchar2(200),
	writer varchar2(30),
	content varchar2(4000),
	REG_DATE date
);

select * from tab;

-- 테이블 삭제 : drop table 테이블명;
drop table tb_board;

select * from tab;

-- 테이블의 제약조건
-- 제약조건 방식에 따른 종류 : 테이블 레벨, 컬럼 레벨
-- 타입 종류 
-- 1. PK : Primary Key
--    하나의 테이블에 하나의 키만 존재함
--    각 로우 데이터를 구분
--    UNIQUE + NOT NULL
-- 2. NN : NOT NULL
--    무조건 값이 입력되어야 한다. 
-- 3. UN : UNIQUE 
--    값이 중복되지 않는다.
-- 4. CK : CHECK
--    값이 입력되기 전 값을 체크
-- 5. FK : FOREIGN KEY
--    다른 테이블의 컬럼의 값을 참조
--    또는 자신 테이블의 컬럼의 값을 참조해서 설정  

-- 디폴트값 : 컬럼명 default 값
-- 컬럼에 값이 입력되지 않은 경우 디폴트로 
-- 설정된 값이 입력
 
-- sysdate : 오라클의 날짜 함수, 현재 시간 정보
create table 테이블명 (
   컬럼명  데이터타입(크기) 제약조건,  <- 컬럼레벨 
   컬럼명  데이터타입(크기) 제약조건,
   제약조건   <-  테이블레벨  
)
create table tb_board (
	no number(6) primary key,
	title varchar2(200) not null,
	writer varchar2(30) not null,
	content varchar2(4000) not null,
	REG_DATE date default sysdate
);

-- 제약조건 체크 확인
INSERT INTO TB_BOARD(NO, TITLE, WRITER, CONTENT, REG_DATE)
VALUES(1, 'HI', 'HONG', 'TEST', SYSDATE);

-- 테이블에 데이터 확인
-- SELECT * FROM 테이블명;
SELECT * FROM TB_BOARD;

-- NO 제약조건 때문에 오류 발생함 : 값이 중복됨...
INSERT INTO TB_BOARD(NO, TITLE, WRITER, CONTENT, REG_DATE)
VALUES(1, 'HELLO', 'HONG', 'TEST', SYSDATE);

-- CONTENT 컬럼은 NOT NULL 이므로 NULL 값 입력이 안됨 : 에러
INSERT INTO TB_BOARD(NO, TITLE, WRITER, REG_DATE)
VALUES(1, 'HELLO', 'HONG', SYSDATE);

-- default에 의해서 sysdate 값이 입력됨
INSERT INTO TB_BOARD(NO, TITLE, WRITER, CONTENT)
VALUES(2, 'HELLO', 'kim', '연습중...');

SELECT * FROM TB_BOARD;

-- 테이블명 변경 : RENAME A TO B;
-- TB_BOARD 의 이름을 TB_BOARD_BACK;
RENAME TB_BOARD TO TB_BOARD_BACK;

SELECT * FROM TAB;

-- TB_BOARD_BACK 의 이름을 TB_BOARD;
RENAME TB_BOARD_BACK TO TB_BOARD;

SELECT * FROM TAB;

SELECT * FROM TB_BOARD;

-- TB_BOARD 테이블의 모든 데이터를 삭제
-- 복구 불가능
TRUNCATE TABLE TB_BOARD; 
-- 복구 가능
DELETE FROM TB_BOARD;

SELECT * FROM TB_BOARD;

-- INSERT
-- 입력 시 주의점 : 문자열을 입력할 경우 "'"으로 문자열을 묶어준다.
INSERT INTO TB_BOARD(NO, WRITER, TITLE, CONTENT)
VALUES(1, 'hong', '입력 연습', 'SQL 입력');

INSERT INTO TB_BOARD(NO, WRITER, TITLE, CONTENT)
VALUES(2, 'kim', '입력 연습2', 'SQL 입력2');

-- 모든 컬럼에 값이 다 입력됨..
-- 권장하지 않는다. 쿼리 해석이 어려워진다.
INSERT INTO TB_BOARD
VALUES(3, 'lee', '입력 연습3', 'SQL 입력3', sysdate);

SELECT * FROM TB_BOARD;

-- 수정 : UPDATE
-- 3번 게시물의 WRITER의 값을 LEE로 변경
UPDATE TB_BOARD
   SET WRITER = 'LEE'
 WHERE NO = 3;  

SELECT * FROM TB_BOARD;

-- 3번 게시물의 WRITER의 값을 KANG, TITLE의 값을 연습으로 변경
UPDATE TB_BOARD
   SET WRITER = 'KANG',
       TITLE = '연습'
 WHERE NO = 3;      

SELECT * FROM TB_BOARD;

-- 삭제 : DELETE
-- 3번 게시물을 삭제
DELETE 
  FROM TB_BOARD
 WHERE NO = 3;

SELECT * FROM TB_BOARD;

-- 전체 게시물 삭제
DELETE 
  FROM TB_BOARD;

SELECT * FROM TB_BOARD;

---------------------------------------
--  SELECT 절
--  FROM 테이블명
---------------------------------------
-- * : 테이블 안의 모든 컬럼 정보를 출력

SELECT *
  FROM TB_BOARD;
  
SELECT NO, TITLE
  FROM TB_BOARD;
  
SELECT *
  FROM TAB;

-- 원하는 컬럼만 조회
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE
  FROM EMPLOYEES;
  
  
-- 컬럼의 산술연산
-- SALARY : 사원의 급여
SELECT EMPLOYEE_ID, LAST_NAME, SALARY
  FROM EMPLOYEES;

-- 숫자 컬럼은 산술연산 가능
SELECT EMPLOYEE_ID, LAST_NAME, SALARY * 1000
  FROM EMPLOYEES;
  
-- ALIAS : 컬럼의 별칭
-- 컬럼명 AS 별칭,   컬럼명  별칭
SELECT EMPLOYEE_ID AS ID, LAST_NAME 이름, SALARY * 1000 SAL
  FROM EMPLOYEES;
  
-- 합성연산자( || ) :  자바의 + 연산의 기능과 유사함  
SELECT EMPLOYEE_ID, LAST_NAME, SALARY
  FROM EMPLOYEES;
  
-- 100번 사원의 이름은 King 이고 급여는 24000000원 입니다.
-- employee_id번 사원의 이름은 last_name 이고 
-- 급여는 salary * 1000원 입니다.
  
select employee_id || '번 사원의 이름은 ' || last_name || 
       '이고 급여는 ' || salary * 1000 || '원 입니다.' as 사원정보
  from employees;
  
  
---------------------------------------
--  WHERE 절
--  : 전체 데이터의 범위를 줄이는 역할수행
---------------------------------------
-- 사원의 정보 : 원하는 정보를 출력..
-- 사원의 급여가 10000 이상인 사원의 정보를 출력하시오  
select *
  from employees
 where salary >= 10000;

-- 사원의 부서가 100번인 사원의 정보를 출력하시오 
select *
  from employees
 where department_id = 100;
 
-- 사원의 부서가 100번이 아닌 사원의 정보를 출력하시오  
select *
  from employees
 where department_id != 100; 

-- 사원의 이름(last_name)이 'King'인 사원의 정보를 출력하시오 
select *
  from employees
 where last_name = 'King'; 

-- 사원의 부서가 100이면서 급여가 10000이상인 사원의 정보를 출력
-- if (department_id == 100 && salary >= 10000)
select *
  from employees
 where department_id = 100 
   and salary >= 10000;
 

-- 사원의 부서가 100이거나 또는 110번인 사원의 정보를 출력
-- if (department_id == 100 || department_id == 110) 
select *
  from employees
 where department_id = 100 
    or department_id = 110;
 
-- 사원의 부서가 90번 또는 100번에 소속된 사원 중에서 
-- 급여가 10000 이상인 사원들의 정보를 출력
select *
  from employees
 where (department_id = 90 or department_id = 100)
   and salary >= 10000;

-- SQL 연산자
-- BETWEEN A AND B : A와 B 사이의 값을 선택(A, B 포함)
-- A의 값이 B의 값보다 작아야 한다.
-- 급여가 10000이상이고 15000 이하인 사원의 정보를 출력
SELECT *
  FROM EMPLOYEES
 WHERE SALARY >= 10000
   AND SALARY <= 15000;
   
SELECT *
  FROM EMPLOYEES
 WHERE SALARY BETWEEN 10000 AND 15000; 
 

-- 사원이 소속된 부서가 90, 100, 110, 120번 부서인 사원의 정보를 출력
-- IN 연산자 :   컬럼명  IN  (값1, ....)
 SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 90
    OR DEPARTMENT_ID = 100
    OR DEPARTMENT_ID = 110
    OR DEPARTMENT_ID = 120;
   
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (90, 100, 110, 120);
    
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (90, 100)
   AND SALARY >= 10000;    
    
-- LIKE 연산자  : 패턴 형식에 일치하는 값 추출
-- 컬럼  LIKE  '패턴문자 값'
-- 패턴문자 :   % (0개 이상의 문자), _ (한개문자)

-- 사원의 이름이 'L'로 시작하는 사원의 정보를 출력
-- LAST_NAME :   LI,  LLO, RI, LIKKE
SELECT *
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE 'L%';
 
-- 사원의 이름이 4글자인 사원의 정보를 출력 
SELECT *
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE '____';
    
 
-- 사원 이름의 두번째가 h인 사원의 정보를 출력 
SELECT *
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE '_h%';
 
-- 이메일의 첫글자가 'D'이고 마지막 글자가 'T'인 사원의 정보 출력
SELECT *
  FROM EMPLOYEES
 WHERE EMAIL LIKE 'D%T';
 
-- 게시판 검색
SELECT *
  FROM TB_BOARD
 WHERE TITLE LIKE '%안녕%';
 
-- 이름이 'King' 인 사원의 정보를 출력 
SELECT *
  FROM EMPLOYEES
 WHERE LAST_NAME = 'KING';  
 
-- IS NULL : NULL 인지 판단하는 연산자
-- NULL 과의 비교연산은 FALSE 반환
-- NULL 과의 산술연산은 NULL 반환
-- NULL은 미정의 값
-- COMMISSION_PCT 을 받지 않는 사원 정보 출력
SELECT * 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT = NULL; 
 
SELECT * 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL; 
 
SELECT * 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL; 
 
    
    
   
   
   

 
   
   
   