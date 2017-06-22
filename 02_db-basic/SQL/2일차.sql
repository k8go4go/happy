-- order by : ASC(오름차순)  DESC(내림차순)
-- order by 표현식 | 컬럼명 [ASC(디폴트) | DESC]
order by no; -- asc 디폴트 설정
order by salary * 1000;
order by no asc;
order by no desc;

-- 사원의 정보를 출력합니다.
-- 단 사원의 급여가 높은 사원부터 출력합니다.
from -> 사원
select -> 사원의 정보
where -> 없음
order by -> 급여가 높은

select *
  from employees
 order by salary desc; 
 
-- 사원의 정보를 부서번호 순으로 출력하시오
select department_id, last_name, salary
  from employees
 order by department_id;  

-- 사원의 정보를 부서번호 순으로 출력하시오
-- 단, 부서번호가 같을 경우 급여순으로 출력
select department_id, last_name, salary
  from employees
 order by department_id, salary;  

-- 사원의 연봉을 출력합니다
-- 연봉 :  급여 * 15
-- 단, 출력시 연봉이 높은 사원부터 출력
select salary * 15 
  from employees
 order by salary * 15 desc;
 
-- order by 절은 컬럼의 alias 사용 가능 
select salary * 15 as year_sal
  from employees
 order by year_sal desc;
 
-- distinct
select department_id
  from employees; 

select distinct department_id
  from employees; 

select distinct department_id, last_name
  from employees; 

--------------------------------
GROUP BY 
- 데이터들을 소그룹으로 묶는다
- 그룹함수 
  : 그룹핑된 데이터와 같이 주로 사용
  : 여러개의 데이터를 받아서 하나의 결과를 반화
  : COUNT, SUM, MAX, MIN, AVG      
--------------------------------
-- 사원들의 수, 최대급여를 출력하시오

SELECT COUNT(*), MAX(SALARY), MIN(SALARY),
       SUM(SALARY), AVG(SALARY)
  FROM EMPLOYEES;
  
-- 100번 부서의 각종 정보 출력
SELECT COUNT(*), MAX(SALARY), MIN(SALARY),
       SUM(SALARY), AVG(SALARY)
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100; 
 
-- 각 부서의 정보를 출력(수, 최대, 최소...)
100  ....
110  ....
120  ....

SELECT DEPARTMENT_ID, 
       COUNT(*), MAX(SALARY), MIN(SALARY),
       SUM(SALARY), AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID;
 
SELECT DEPT_ID, JOB_ID, MAX(SAL), MIN(SAL)
  FROM tb_group
 GROUP BY DEPT_ID, JOB_ID; 
 
 
-- 각 부서별 최대급여를 출력합니다.
-- 단, 최대급여가 높은 부서부터 출력 
SELECT DEPARTMENT_ID, MAX(SALARY) MAX_SAL
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY MAX_SAL DESC;

-- 각 부서별 최대급여를 출력합니다.
-- 최대급여가 10000 이상인 부서를 대상으로 
-- 단, 최대급여가 높은 부서부터 출력 
select department_id, max(salary) max_sal
  from employees
 where max(salary) >= 10000   
 group by department_id
 order by max_sal desc; 

--------------------------------------
HAVING
 : 그룹에 대한 제약을 처리
--------------------------------------

select department_id, max(salary) max_sal
  from employees   
 group by department_id
having max(salary) >= 10000
 order by max_sal desc; 
 
-- 부서별 평균 급여를 출력합니다.
-- 단, 100번보다 큰 부서는 제외하고 
-- 부서의 평균 급여가 5000 이상인 부서만 출력
-- 부서번호 순으로 출력합니다. 
select department_id DEPT_ID, 
       avg(salary) AVG_SAL
  from employees
 where department_id <= 100
 group by department_id
having avg(salary) >= 5000
 order by department_id;  

-- 실행순서
-- FROM -> WHERE -> GROUP BY -> HAVING 
-- SELECT -> ORDER BY

-------------------------------------
함수 - 단일행 함수
문자 함수
숫자 함수
날짜 함수
변환 함수 : TO_CHAR, TO_DATE, TO_NUMBER
기타 함수 : NVL, DECODE, CASE
------------------------------------- 

SELECT LAST_NAME, LOWER(LAST_NAME),
       UPPER(LAST_NAME),
       CONCAT(LAST_NAME, '사원'),
       LAST_NAME || '사원'
  FROM EMPLOYEES; 
 
SELECT LAST_NAME, FIRST_NAME,
       CONCAT( UPPER(FIRST_NAME), LAST_NAME )
  FROM EMPLOYEES; 
  
String msg = "hello";
"el" 만 추출하기
msg.substring(1, 3)

select last_name, 
       substr(last_name, 1, 2)
  from employees;
  
select '2017-05-02'
  from employees;
  
-- dummy table : dual
    
select '2017-05-02'
  from dual;
  
-- 실행 시 결과가 2017,   05,   02  출력
  
select substr('2017-05-02', 1, 4),
       substr('2017-05-02', 6, 2),
       substr('2017-05-02', 9, 2)
  from dual;

select last_name, length(last_name),
       lpad(last_name, 10, '*'), 
       rpad(last_name, 10, '*')     
  from employees;
  
select 'hi hello sql',
       replace('hi hello sql', 'el', 'ak'), 
       translate('hi hello sql', 'el', 'ak')
  from dual;  
  
-- 숫자형 함수
select abs(100), abs(-100)
  from dual;  
  
-- ceil : 입력된 수보다 크거나 같으면서 
--        가장 작은 정수  
-- floor : 입력된 수보다 작거나 같으면서 
--        가장 큰 정수
select ceil(1.1), floor(1.1)
  from dual;  
  
select sign(-10), sign(0), sign(10)
  from dual;  
  
select round(73.727), 
       round(73.727, 2),
       round(73.727, -2),
       trunc(73.727), 
       trunc(73.727, 2),
       trunc(73.727, -2)
  from dual;  
  
-- 날짜형 함수
select sysdate
  from dual;
  
select sysdate, 
       add_months(sysdate, 1),
       add_months(sysdate, -1)
  from dual;        
  
-- 각 사원의 입사일로부터 1년뒤의 날짜를 출력
select hire_date, add_months(hire_date, 12)
  from employees;
  
-- months_between(날짜1, 날짜2) 
-- 두날짜간의 개월 차를 반환
-- 사원의 근무 개월을 출력
select trunc(months_between(sysdate, hire_date))
  from employees;  

select sysdate, last_day(sysdate)
  from dual;  
  
-- 날짜 + 숫자 = 날짜
-- 날짜 - 숫자 = 날짜
-- 날짜 - 날짜 = 숫자
select sysdate, sysdate + 7, sysdate - 7,
       sysdate + 1/24
  from dual;
  
select sysdate - hire_date
  from employees;  

-- 변환형 함수
-- to_char(날짜, '패턴') : 날짜를 문자로
-- to_char(숫자, '패턴') : 숫자를 문자로

select sysdate,
       to_char(sysdate, 'yyyy-mm-dd'),
       to_char(sysdate, 'hh24:mi:ss') 
  from dual;
  
-- to_date
-- to_date('문자', '패턴') : 문자를 날짜로  
select sysdate,
       to_date('2017-03-11', 'yyyy-mm-dd') 
  from dual;
  
insert into tb_board(
    no, title, writer, content, reg_date
) values (
    3, 'test', 'tester', 'exam', 
    to_date('2017-01-01', 'yyyy-mm-dd')
);  
  
-- 숫자를 문자로
select 892768491,
       to_char(89112323),     
       to_char(892768491, '999,999,999'),
       to_char(892768491, '99,999,999')
  from dual;
  
-- to_number : 문자를 숫자로 변환
-- to_number('문자', '패턴')  
select to_number('892,768', '999,999,999')
  from dual;  
  
-- 사원중에서 5월에 입사한 사원들의 
-- 정보만 출력하시오
select *
  from employees
 where to_char(hire_date, 'mm') = '05'; 
    
-- 현재 월과 동일한 월에 입사한 
-- 사원의 정보를 출력하시오   
select *
  from employees
 where to_char(hire_date, 'mm') = to_char(sysdate, 'mm');
 
-- 기타 함수
-- nvl('표현식|컬럼', '값')
-- null일 경우에 특정한 값을 설정 
select salary, commission_pct,
       salary + salary * nvl(commission_pct, 0) sal
  from employees; 

-- 그룹 함수는 null값을 배제하고 처리한다.  
select sum(commission_pct)
  from employees;  
  
select * from employees;  
  

select last_name, employee_id, manager_id
  from employees;

-- 관리자가 없는 사원은 
-- manager_id에 '관리자 없음' 출력
select last_name, employee_id, 
       nvl(to_char(manager_id), '관리자 없음')
  from employees;

select last_name, employee_id, 
       nvl(manager_id || '', '관리자 없음')
  from employees;
       
-- decode : 자바의 switch 문 같은 용도
-- switch (job_id) {
      case "IT_PROG": 
         .....
      case "...": 
         .....
      default:
         .....   
-- }
select job_id, 
       decode (job_id, 'IT_PROG', '개발자',
                      'SA_MAN', '세일즈',
                      '그냥 직원') 
       as job_type               
  from employees;
  
-- case ~ end
select job_id, 
       case job_id when 'IT_PROG' then '개발자'
                  when 'SA_MAN' then '세일즈'
                  else '그냥 직원' 
       end as job_type               
  from employees;
  
select job_id, 
       case when job_id = 'IT_PROG' then '개발자'
            when job_id = 'SA_MAN' then '세일즈'
            else '그냥 직원' 
       end as job_type               
  from employees;
  
-- 사원의 급여에 따라서 다음과 같이 출력한다.
-- 급여가 15000 이상이라면 '고급 인력'
-- 급여가 10000 ~ 14999 사이라면 '중급 인력'
-- 급여가 10000 미만일 경우 '초급 인력'
-- 출력은 급여와 급여 타입(고급,... )을 출력
select salary,
       case when salary >= 15000 then '고급 인력'
            when salary >= 10000 then '중급 인력'
            else '초급 인력'
        end as sal_type
  from employees;
  

----------------------------------
시퀀스(SEQUENCE) 객체
고유번호 생성기
----------------------------------

DELETE FROM TB_BOARD;

SELECT NVL(MAX(NO), 0) + 1 FROM TB_BOARD;


INSERT INTO TB_BOARD(
    NO, TITLE, WRITER, CONTENT
) VALUES (
    (SELECT NVL(MAX(NO), 0) + 1 FROM TB_BOARD), 
    '제목', '글쓴이', '내용'
);
    
SELECT * FROM TB_BOARD;
  
-- 시퀀스 생성 : S_테이블명_컬럼명

CREATE SEQUENCE S_BOARD_NO;  
  
-- 번호 추출 :  시퀀스명.nextval

select s_board_no.nextval
  from dual;
  
  
select s_board_no.currval
  from dual;
  
INSERT INTO TB_BOARD(
    NO, TITLE, WRITER, CONTENT
) VALUES (
    s_board_no.nextval, 
    '제목', '글쓴이', '내용'
);  