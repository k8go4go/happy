문제 1.

select dept_id, min(salary)
  from s_emp
 group by dept_id;

 
문제 2.

select title, min(salary)
  from s_emp 
 where title not like '%부장' 
 group by title;
 
 
문제 3.

select title, avg(salary)
  from s_emp  
 group by title;


문제 4.

select title, count(*)
  from s_emp  
 group by title;


문제 5.

select title, max(salary)
  from s_emp  
 group by title
having max(salary) >= 2000;


문제 6.

select title, min(salary) as min_sal
  from s_emp 
 where title not like '%부장' 
 group by title
 order by min_sal desc;


문제 7.

select title, avg(salary) as avg_sal
  from s_emp 
 where title != '사원' 
 group by title
 order by avg_sal;
 
 
문제 8.
 
select title, sum(salary) as sum_sal
  from s_emp 
 where title != '사원' 
 group by title
having sum(salary) >= 2000 
 order by sum_sal desc;
 
 
문제 9.

select upper(substr(mailid, 1, 1)) || lower(substr(mailid, 2)) 
  from s_emp; 
  

문제 10.
  
select name 
  from s_emp
 where length(name) > 2;

 
문제 11.
select name, 
       trunc(months_between(sysdate, start_date)) * salary as 총급여
  from s_emp; 

  
문제 12.
  
select name, nvl(commission_pct || '', '커미션 없음')
  from s_emp  

  
문제 13.

select name, 
       case when title = '사원' then salary * 1.1
            when title = '과장' then salary * 1.2
            else salary * 1.1
        end as 급여    
  from s_emp  


문제 14.

select name, lpad('*', trunc(salary / 100), '*') 
  from s_emp;









