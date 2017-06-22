문제 1.

select name, title, salary, dept_id
  from s_emp 
 where title in ('과장', '사원')
   and dept_id in (112, 118)
   and salary between 1500 and 4000;

   
문제 2.

select name, title, salary
  from s_emp 
 where manager_id is null;
 

문제 3.

select name, title, salary
  from s_emp 
 where title like '%부장'
   and salary >= 3000;
   

문제 4.

select name, title, salary, dept_id
  from s_emp 
 where (title like '%부장' or title = '과장')
   and dept_id in (112, 113, 117, 118)
   and salary between 2300 and 3000;

   
문제 5. 

select name, title, salary, start_date
  from s_emp 
 where (title like '%부장' or title = '과장')
   and TO_CHAR(START_DATE, 'mm') = '03'

   
문제 6. 

select name, (salary*16) + 1000 "직원연봉"
  from s_emp;

  
문제 7. 

select name || ' ' || title || '의 급여 ' || salary "직원 급여"
  from s_emp;


문제 8.  

select name, salary, commission_pct, manager_id
  from s_emp 
 where (commission_pct is not null or manager_id is not null)
   and salary >= 2500;

