-- 그룹

create table tb_group (
    id varchar2(3),
    sal number,
    job_id varchar2(2),
    dept_id number
);  
  
insert into tb_group values('a', 1000, 'SA', 10);  
insert into tb_group values('b', 2000, 'CM', 30);  
insert into tb_group values('c', 3000, 'CM', 20);  
insert into tb_group values('d', 4000, 'LA', 10);  
insert into tb_group values('e', 3000, 'SA', 30);  
insert into tb_group values('f', 2000, 'SA', 10);


-- 조인
drop table salgrade;
create table salgrade (
    grade char(1),
    min_sal number(6),
    max_sal number(6)
);

insert into salgrade values ('1', 20000, 100000);
insert into salgrade values ('2', 10000, 19999);
insert into salgrade values ('3', 6000, 9999);
insert into salgrade values ('4', 3000, 5999);
insert into salgrade values ('5', 1, 2999);


-- set 연산자
drop table tc_seta;
create table tc_seta (
    no number,
    data varchar2(2)
);

drop table tc_setb;
create table tc_setb (
    no number,
    data varchar2(2)
);

insert into tc_seta values(1, 'a');
insert into tc_seta values(2, 'b');
insert into tc_seta values(3, 'c');
insert into tc_seta values(4, 'd');

insert into tc_setb values(3, 'c');
insert into tc_setb values(4, 'd');
insert into tc_setb values(5, 'e');
insert into tc_setb values(6, 'f');