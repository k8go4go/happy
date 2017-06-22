select last_name, department_id
  from employees;
  
select department_id, department_name
  from departments; 
  
-- 60
select department_id
  from employees
 where last_name = 'Hunold'; 
 
select department_name
  from departments
 where department_id = 60;    
  
-- Hunold   60   IT
select employees.last_name, 
       employees.department_id,
       departments.department_name
  from employees, 
       departments;
  
-- 테이블 별칭(alias) 사용  
select e.last_name, 
       e.department_id,
       d.department_name
  from employees e, 
       departments d;  
  
-- Equi Join( = )  
select e.last_name, 
       e.department_id,
       d.department_name
  from employees e, 
       departments d
 where e.department_id = d.department_id;   
  
-- 각 사원의 직무에 따른 최소 급여와 최대 급여를
-- 화면에 출력한다.
-- (이름, 직무명, 최소, 최대 급여)
select e.last_name, 
       j.job_title, j.max_salary, j.min_salary
  from employees e, 
       jobs j
 where e.job_id = j.job_id; 
   

-- Canada 에 근무하는 사원의 
-- 도시명, 부서명, 사원명 출력하시오 
select e.last_name, d.department_name, l.city  
  from employees e, 
       departments d, locations l, countries c
 where e.department_id = d.department_id
   and d.location_id = l.location_id
   and l.country_id = c.country_id
   and c.country_name = 'Canada';  
  
select *
  from salgrade;  
  
select last_name, salary
  from employees;  
  
-- non equi join ( = 이외의 연산자 사용 )  
-- 사원의 이름, 급여, 급여등급 출력
select e.last_name, e.salary, s.grade
  from employees e, salgrade s
 where e.salary between s.min_sal and s.max_sal; 

-- self join 
-- ( 물리적 테이블은 1나.. 논리적 테이블 2개이상)
select employee_id, last_name, manager_id
  from employees; 

-- 사원번호  사원명  관리자번호  관리자명
select e.employee_id, e.last_name, 
       m.employee_id, m.last_name
  from employees e, 
       employees m
 where e.manager_id = m.employee_id
 order by e.employee_id;

-- outer join 
-- ( 조인조건을 만족하지 않더라도 결과에 포함 )
-- (+) 결과가 모자른 쪽에 붙인다. 
-- 양쪽에 같이 붙일수 없다.
select e.employee_id, e.last_name, 
       m.employee_id, m.last_name
  from employees e, 
       employees m
 where e.manager_id = m.employee_id(+)
 order by e.employee_id;  
  
select e.employee_id, e.last_name, 
       nvl(m.employee_id || '', '관리자 없음'), 
       nvl(m.last_name, '관리자 없음')
  from employees e, 
       employees m
 where e.manager_id = m.employee_id(+)
 order by e.employee_id;    
     
 
 
 
 
 
 
-- oracle 9i 부터 
-- cross join (Cartesian product 대체)
select e.last_name, 
       e.department_id,
       d.department_name
  from employees e 
 cross join departments d;  
  
-- Equi Join, NonEqui Join, Self Join
-- inner join on 대체
-- 테이블 inner join 테이블 on 증거조건 
select e.last_name, 
       e.department_id,
       d.department_name
  from employees e 
 inner join departments d
    on e.department_id = d.department_id;   
  
-- 각 사원의 직무에 따른 최소 급여와 최대 급여를
-- 화면에 출력한다.
-- (이름, 직무명, 최소, 최대 급여)
select e.last_name, 
       j.job_title, j.max_salary, j.min_salary
  from employees e 
 inner join jobs j
    on e.job_id = j.job_id; 
   

-- Canada 에 근무하는 사원의 
-- 도시명, 부서명, 사원명 출력하시오 
select e.last_name, d.department_name, l.city  
  from employees e
 inner join departments d
    on e.department_id = d.department_id
 inner join locations l
    on d.location_id = l.location_id
 inner join countries c
    on l.country_id = c.country_id
 where c.country_name = 'Canada';  
  

-- non equi join ( = 이외의 연산자 사용 )  
-- 사원의 이름, 급여, 급여등급 출력
select e.last_name, e.salary, s.grade
  from employees e 
 inner join salgrade s
    on e.salary between s.min_sal and s.max_sal; 

-- 사원번호  사원명  관리자번호  관리자명
select e.employee_id, e.last_name, 
       m.employee_id, m.last_name
  from employees e 
 inner join employees m
    on e.manager_id = m.employee_id
 order by e.employee_id;

-- outer join 
-- ( 조인조건을 만족하지 않더라도 결과에 포함 )
-- (full | left | right) outer join 
-- 양쪽에 같이 붙일수 없다.
select e.employee_id, e.last_name, 
       m.employee_id, m.last_name
  from employees e
  left outer join employees m
    on e.manager_id = m.employee_id(+)
 order by e.employee_id;  
  

-------------------------------------
-- SET 연산자
-------------------------------------
-- 양쪽 데이터 모두 출력
-- 중복된 데이터는 한번만 
select * 
  from tc_seta
 union  
select *
  from tc_setb; 

-- 양쪽 데이터 모두 출력
select * 
  from tc_seta
 union all 
select *
  from tc_setb; 

-- 양쪽 중복된 데이터만 출력
select * 
  from tc_seta
 intersect 
select *
  from tc_setb; 
  
select * 
  from tc_seta
 minus 
select *
  from tc_setb; 
  
select last_name
  from employees
 union all
select department_name
  from departments; 
  
-- 주의 1. 컬럼의 수가 동일해야 한다.  
select last_name, salary
  from employees
 union all
select department_name
  from departments;   

-- 주의 2. 대응되는 컬럼의 데이터 타입은 동일해야 한다.
select last_name, salary
  from employees
 union all
select department_id, department_name
  from departments;  
    
-- 주의 3. order by 절은 맨 마지막에 위치해야 함  
select last_name, salary
  from employees
 order by salary 
 union all
select department_name, department_id
  from departments;  

-- 컬럼의 이름은 처음 실행된 SELECT 문이 사용
select last_name, salary
  from employees
 union all
select department_name, department_id
  from departments
 order by salary; 
 
--------------------------------------------
-- 서브쿼리(subquery)
-------------------------------------------- 
-- Chen 의 부서번호 
select department_id
  from employees
 where last_name = 'Chen';

-- Chen 과 같은 부서에 근무하는 사원의 정보 출력
select *
  from employees
 where department_id = 100;  
  
-- (서브쿼리) 
-- Single Row SubQuery 
-- : 서브쿼리의 결과 행이 하나인 것
select *
  from employees
 where department_id = (select department_id
                         from employees
                        where last_name = 'Chen');
                        
-- King과 같은 부서에 근무하는 사원의 정보 출
-- Multi Row SubQuery
-- : 서브쿼리의 결과행이 여러개인 것
-- : IN, ANY, ALL
select *
  from employees
 where department_id in (select department_id
                         from employees
                        where last_name = 'King');
  
-- 2개의 행 반 
select department_id
  from employees
 where last_name = 'King';
 
-- 30부서의 사원들이 받는 급여보다 급여를 많이
-- 받는 사원의 정보를 출력
select last_name, salary
  from employees
 where salary >ALL (select salary 
                     from employees
                    where department_id = 30);  
 
select last_name, salary
  from employees
 where salary > (select max(salary) 
                  from employees
                 where department_id = 30);  
 
select last_name, salary
  from employees
 where salary <ALL (select salary 
                     from employees
                    where department_id = 30);  
 
select last_name, salary
  from employees
 where salary <ANY (select salary 
                     from employees
                    where department_id = 30);  
  
select last_name, salary
  from employees
 where salary < (select max(salary) 
                  from employees
                 where department_id = 30);  

-- 각 부서에서 가장 작은 급여를 받는 사원 정보 출력
select last_name, salary
  from employees
 where salary in (부서에서 가장 작은 급여);

-- multi column subquery
-- : 서브쿼리의 실행된 컬럼의 개수가 여러개                           
select last_name, salary
  from employees
 where (department_id, salary) in 
                (select department_id, min(salary) 
                   from employees
                  group by department_id);
 
-- 서브쿼리가 자주 사용되는 위치
-- INSERT, UPDATE, DELETE
insert into tb_board(
    no, title, writer, content
) values (
    (select nvl(max(no), 0) + 1 from tb_board),
    'aa', 'bb', 'cc'
);

-- SELECT
select e.last_name, e.department_id,  
       d.department_name
  from employees e 
 inner join departments d
    on e.department_id = d.department_id;

-- SELECT Subquery
select e.last_name, e.department_id,  
       (select department_name
          from departments
         where department_id = e.department_id)
       as dept_name   
  from employees e;
  
-- FROM 절의 서브쿼리
-- Inline View
select *
  from (select employee_id eid, salary sal
          from employees
         order by sal) a;


-- 위의 쿼리를 조인으로 변경한다. 
select last_name, salary
  from employees
 where (department_id, salary) in 
                (select department_id, min(salary) 
                   from employees
                  group by department_id);
                  
select last_name, salary
  from employees a,
       (select department_id, min(salary) sal 
                   from employees
                  group by department_id) b                   
 where a.department_id = b.department_id
   and a.salary = b.sal;
                  
select last_name, salary
  from employees a
 inner join (select department_id, min(salary) sal 
               from employees
              group by department_id) b                   
    on a.department_id = b.department_id
   and a.salary = b.sal; 
 
---------------------------------------- 
-- rownum 의 이해 
----------------------------------------
-- 급여를 많이 받는 상위 5명의 정보를 출력
select rownum, last_name, salary
  from employees
 where rownum = 1;

select rownum, last_name, salary
  from employees
 where rownum < 3;
 
-- 순서대로 앞에서 5명을 추출한뒤 
-- 추출된 사원의 급여순으로 정렬
 select rownum, last_name, salary
   from employees
  where rownum < 6
  order by salary desc;
 
 select last_name, salary
   from employees
  order by salary desc;
 
  where rownum < 6; 

select rownum, a.last_name, a.salary
  from (select *
          from employees
         order by salary desc) a
 where rownum < 6;  


select rownum rnum, a.last_name, a.salary
  from (select *
          from employees
         order by salary desc) a;  

select *
  from (
        select rownum rnum, a.last_name, a.salary
          from (
                select *
                  from employees
                 order by salary desc
               ) a
       )
 where rnum between 5 and 8;
 
-- 테이블 생성시 서브쿼리 활용하기
create table employees_copy
as 
select * from employees; 
 
drop table employees_copy;

select * from employees_copy;

-- 테이블 구조만 복사
create table employees_copy
as 
select * from employees
 where 1 != 1; 

select * from employees_copy;

-- 테이블이 존재하는 상태에서 데이터를 복사
insert into employees_copy
select * from employees;

select * from employees_copy;

-----------------------------------------
-- alter : 테이블 변경
-- 컬럼 추가, 컬럼 삭제, 
-- 컬럼 변경(타입, 크기, default, not null)
-- 추가 : add, 삭제 : drop, 변경 : modify
-----------------------------------------
alter table 테이블명
add (컬럼...);

alter table 테이블명
drop (컬럼);

alter table 테이블명
modify (컬럼);

9i 부터 컬럼의 이름 변경
alter table 테이블명
rename column a to b;

create table tb_alter (
    nama varchar2(10),
    age varchar2(3)
);

-- 컬럼 추가
alter table tb_alter
add (email varchar2(20));

select * from tb_alter;

desc tb_alter;

-- 컬럼 이름 변경
alter table tb_alter
rename column nama to name;

select * from tb_alter;

-- 컬럼 삭제
alter table tb_alter
drop (email);

select * from tb_alter;

-- 컬럼 변경
alter table tb_alter
modify (age number(3));

       
select rownum, a.no, a.title
  from (select *
          from tb_board
         order by no desc) a
 where rownum < 6;  
 
