create table tb_user (
    id    varchar2(20),
    name  varchar2(30),
    pass  varchar2(20)
);

insert into tb_user values ('a', '홍길동', '1');

insert into tb_user values ('b', '장길산', '2');

insert into tb_user values ('c', '강감찬', '3');

commit;